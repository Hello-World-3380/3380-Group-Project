

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class StateDemo {

    public static int current = 0;

    static State state = new MainMenuState();

    static GUI gui;

    public static ImportLog importLog = new ImportLog();
    public static UpdateLog updateLog = new UpdateLog();
    public static ExportLog exportLog = new ExportLog();
    public static FileChecker fileChecker = new FileChecker(importLog);
    public static FileController fileController = new FileController(fileChecker,updateLog);
    public static SessionLoader sessionLoader = new SessionLoader(fileController, fileChecker,importLog);

    public static Updater updatePOG = new Updater();


    public static void main(String[] args) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
        Date date = new Date(System.currentTimeMillis());
        try {
            PrintStream out = new PrintStream(formatter.format(date));
            System.setOut(out);
        }catch(IOException e){

        }

        File previousSession = new File("session.dat");
        importLog.log(date.toString());

        if (previousSession.exists() && previousSession.length() != 0) {
            importLog.log("From the ashes, the old session rises");
            try {
                sessionLoader.loadListFromDisk(previousSession);
            } catch (FileNotFoundException e) {
                importLog.log("File does not exist, somehow");
            }
        }else{
            importLog.log("No valid session data remains");
        }

        gui = new GUI();

            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    try {

                        gui.getMainMenu().setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                public void run() {
                    try {
                        exportLog.log("Initializing Shutdown Hook");
                        File output = new File(("session.dat"));
                        //flushes the file's contents
                        PrintWriter pwriter = new PrintWriter(output);
                        pwriter.print("");
                        pwriter.close();
                        exportLog.log("Closed previous file");
                        //writes the new data into the dat file
                        BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
                        if (fileChecker.folderList.size() != 0) {
                            writer.append("" + fileChecker.folderList.size() + "\n");
                            for (int i = 0; i < fileChecker.folderList.size(); i++) {
                                writer.append(fileChecker.folderList.get(i).toExportString());
                                writer.append("\n");
                            }
                            if(fileChecker.fileList.size()==0){
                                writer.append("false");
                            }
                        }
                        if (fileChecker.fileList.size() != 0) {
                            writer.append("FILES\n");
                            writer.append("" + fileChecker.fileList.size() + "\n");

                            for (int i = 0; i < fileChecker.fileList.size(); i++) {
                                writer.append(fileChecker.fileList.get(i).toExportString());
                                writer.append("\n");
                            }
                        }

                        writer.close();

                    } catch (IOException e) {
                    }
                }
            }, "Shutdown thread"));

        }
    }
