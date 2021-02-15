import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static List<SimulatedFolder> sortDirs =  new ArrayList();
    public static String[] fakeDirectories = {"Documents", "Family Photos", "SchoolWork", "Tax Documents", "Games", "Pet Pictures", "Desktop", "System32"};
    public static String[] fakeFiles = {"GrandmaSkiing.png","I-9 Form.pdf", "1350 Assingment 1.txt", "Grandmadiving.png", "Buisiness Expenses.pdf","IRS Returns.pdf","GrandmainHawaii.png","ArtProject.psd","3DModelTest.fbx","DELETE ME.txt","Grandma1.jpg","Tax Evasion Release Form.pdf"};
    public static String[] colors = {"Red","Orange","Yellow","Green","Blue","Purple","Black","White","Manilla","Brown"};
    public static Scanner scan = new Scanner(System.in);
    public static File outputLog = new File("output.txt");
    public static String log = "";
    public static int currentFile = 0;

    public static void main(String[] args) throws java.io.IOException {
        FileWriter writer = new FileWriter("output.txt");
        if(sortDirs.size()==0){
            System.out.println("First we have to make a directory for you to sort into!");
            log+=addDir();
        }
        boolean running = true;
        while(currentFile < fakeFiles.length&&running) {
            printGUI();
            int input = 0;
            System.out.println("What would you like to do next?");
            System.out.println("1: Move the file to another Folder");
            System.out.println("2: Create a new Directory");
            System.out.println("3: Move the file to the Recycling Bin");
            System.out.println("4: Exit the program");
            System.out.println("5: Print Log");

            input = scan.nextInt();
            while (input < 0 || input > 5) {
                System.out.println("Please select a valid option");
                input = scan.nextInt();
            }
            flushConsole();
            if (input == 1) {
                System.out.print("Current Folders: ");
                for (int i = 0; i < sortDirs.size(); i++) {
                    System.out.print(i + ": " + sortDirs.get(i).name);
                }
                input = scan.nextInt();
                while (input < 0 || input > sortDirs.size()) {
                    System.out.println("Please select a valid option!");
                    input = scan.nextInt();
                }
                System.out.println("Moved " + fakeFiles[currentFile] + " to " + sortDirs.get(input).name);
                log += "Moved " + fakeFiles[currentFile] + " to " + sortDirs.get(input).name+"\n";
                currentFile++;
            } else if (input == 2) {
                log+=addDir();
            } else if (input == 3) {
                System.out.println("Moved " + fakeFiles[currentFile] + " to Recycle Bin");
                log += "Moved " + fakeFiles[currentFile] + " to Recycle Bin\n";
                currentFile++;
            } else if (input == 4) {
                running = false;
            }else if(input==5){
                System.out.println(log);
            }
        }

    }

    public static void printGUI(){
        flushConsole();
        for(int i = 0; i< sortDirs.size(); i++){
            System.out.print(sortDirs.get(i).name+"\t");
        }
        System.out.print("Recycling Bin");
        System.out.print("\n\n\n\n\n\n");
        System.out.println("Currently Sorting: "+fakeFiles[currentFile]);
    }

    public static String askForInput(){
        return "";
    }

    public static String addDir(){
        System.out.println("Choose the name of your directory or pick a pre-existing one");
        System.out.println("Enter 1 to select a pre-existing one, or enter 2 to create a new one");
        int input = scan.nextInt();
        String storedName = "";
        while(input!=1 && input!=2){
            System.out.println("Please select a valid option!");
            input = scan.nextInt();
        }
        if(input==1){
            System.out.println("Current Directories are: ");
            for(int i = 0; i<fakeDirectories.length;i++){
                System.out.println(i+":"+fakeDirectories[i] + " ");
            }
            System.out.println();
            System.out.println("Please select one by entering the number corresponding to it");
            int selectedDir = scan.nextInt();
            while(selectedDir< 0 || selectedDir > fakeDirectories.length-2){
                if(selectedDir == fakeDirectories.length-1){
                    System.out.println("Error, you cannot select System folders for sorting!");
                }else{
                    System.out.println("Please select a valid option!");
                }
                selectedDir = scan.nextInt();
            }
            storedName = fakeDirectories[selectedDir];
        }else if(input==2){
            System.out.println("Please select a name for your new directory!");
            String name = scan.next();
            storedName = name;
        }
        flushConsole();
        //Add the actual directory
        System.out.println("Added "+storedName+" to the roster");
        SimulatedFolder newFolder = new SimulatedFolder();
        newFolder.name = storedName;
        sortDirs.add(newFolder);
        System.out.println("Please select a color for this folder");
        for(int i = 0; i<colors.length; i++){
            System.out.print(i+": "+colors[i]+" ");
        }
        System.out.println("Please select one by number");
        input = scan.nextInt();
        while(input < 0 || input > fakeDirectories.length){
            System.out.println("Please select a valid option!");
            input = scan.nextInt();
        }
        System.out.println("Set color to " + colors[input]);
        newFolder.color=colors[input];

        System.out.println("Would you like to add a custom icon?");
        System.out.println("Enter 1 to select one, or enter 2 to forgo one");
        input=scan.nextInt();
        while(input!=1 && input!=2){
            System.out.println("Please select a valid option!");
            input = scan.nextInt();
        }
        if(input==1){
            newFolder.hasCustomIcon=true;
            System.out.println("User will now select an image from their computer");
        }

        System.out.println("Folder Creation complete, returning to main");
        System.out.println("Logged: Action -> Create new folder, Folder: " + newFolder.toString());
        return newFolder.toString()+"\n";
    }

    public static void flushConsole(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
