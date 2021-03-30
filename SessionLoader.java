import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This object is a session loader, used to initialize the previous state of the program
 * when it was last closed so you can start where you left off
 *
 * CSC 3304 Programming project No 1
 *
 * @author Gareth Bloemeke
 * @since 3/6/2021
 *
 */

public class SessionLoader {

    /**
     * A File Controller used for reference
     */
    private FileController fileController;
    /**
     * A File Checker used for reference
     */
    private FileChecker fileChecker;

    private ImportLog importlog;

    /**
     * This object is a session loader, used to initialize the previous state of the program
     * when it was last closed so you can start where you left off
     *
     * CSC 3304 Programming project No 1
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */

    public SessionLoader(FileController fc, FileChecker fcc, ImportLog im){
        fileController = fc;
        fileChecker = fcc;
        importlog = im;
    }

    /**
     * Reads session.dat from the disk and determines what combination of files and folders
     * need to be read in
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void loadListFromDisk(File f) throws FileNotFoundException {
        Scanner in = new Scanner(f);
        String firstImport = in.next();
        //this first chunk handles loading files
        if(firstImport.equals("FILES")){
            importlog.log("Started Files");
            loadFilesFromDisk(f,in);
        }else{
            importlog.log("Started Folders");
            loadFoldersFromDisk(f,in,firstImport);
            System.out.println(in.nextLine());
            if(in.nextLine().equals("FILES")) {
                importlog.log("Started Files");
                loadFilesFromDisk(f, in);
            }
        }
    }


    /**
     * loads the folders from session.dat and initializes them in the program
     *
     *
     * parameters:
     * f [File] session.dat, for reference
     * in [Scanner] used to read session.dat
     * firstImport [String] the first string imported for the checksum
     * still needed in initialization
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void loadFoldersFromDisk(File f, Scanner in, String firstImport){
        int folderCount = Character.getNumericValue(firstImport.charAt(0));
        importlog.log("Initializing folder read" + folderCount);
        for(int i = 0; i < folderCount; i++){
            in.next();
            String temp= in.next();
            fileController.addFolder(temp);
        }
    }

    /**
     * loads the files from session.dat and initializes them in the program
     *
     *
     * parameters:
     * f [File] session.dat, for reference
     * in [Scanner] used to read session.dat
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void loadFilesFromDisk(File f, Scanner in) throws FileNotFoundException{
        int numFiles = in.nextInt();
        in.nextLine();
        File[] files = new File[numFiles];
        File temp;
        String temps;
        for(int i = 0; i < numFiles; i++){
            temps = in.nextLine();
            temp = new File(temps);
            if(temp.exists()){
                files[i]=temp;
            }
            importlog.log(temp.toString()+" " + "exists: "+ temp.exists());
        }
        importlog.log("passing validated files to initializer");
        fileChecker.virtualFileInitializer(files);
    }
}
