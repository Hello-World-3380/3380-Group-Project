import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This object is a file controller, it handles movement and deletion of files
 * as well as creation of folders
 *
 * CSC 3304 Programming project No 1
 *
 * @author Gareth Bloemeke
 * @since 3/6/2021
 *
 */
public class FileController {

    /**
     * A File Checker used for reference
     */
    public FileChecker fileChecker;
    private UpdateLog ul;

    /**
     * This object is a file controller, it handles movement and deletion of files
     * as well as creation of folders
     *
     * CSC 3304 Programming project No 1
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public FileController(FileChecker fcin, UpdateLog ul){
        fileChecker = fcin;
        this.ul = ul;
    }

    /**
     * moves a file from one location to another then deletes the virtual file previously associated with it
     *
     *
     * parameters:
     * vf [Virtual File] the file to move
     * vfo [Virtual Folder] the folder to move it into
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void moveFile(VirtualFile vf, VirtualFolder vfo){
        try {

            Files.move(Paths.get(vf.getLocation()), Paths.get(vfo.getDir()+"\\"+vf.getFullName()));
            fileChecker.fileList.remove(fileChecker.fileList.indexOf(vf));
            ul.log("Moved file "+vf.getName()+" from "+vf.getLocation()+" to "+vfo.getDir());
        }catch(IOException ex){
            if(!vf.getFile().exists()){
                ul.log("File "+vf.getName()+" does not exist...");
                fileChecker.fileList.remove(fileChecker.fileList.indexOf(vf));
            }else{
                ul.log("The file "+vf.getName()+" could not be moved...");
                ul.log("Perhaps there is already one with the same name in the destination folder?");
            }
        }
    }

    /**
     * moves the front of the queue to the back
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void sortLater(){
        VirtualFile temp = fileChecker.fileList.get(0);
        fileChecker.fileList.remove(0);
        fileChecker.fileList.add(temp);
        ul.log("Moved " + temp.toString() + " to be sorted later");
    }

    /**
     * deletes a file from your computer
     *
     *
     * parameters:
     * vf [Virtual File] virtual file to delete
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void deleteFile(VirtualFile vf){

        try {
            Files.delete(Paths.get(vf.getLocation()));
            ul.log("Deleted " + vf.toString());
            fileChecker.fileList.remove(fileChecker.fileList.indexOf(vf));
        }catch(IOException ex){

            if(!vf.getFile().exists()){
                ul.log("This file does not exist");
                fileChecker.fileList.remove(fileChecker.fileList.indexOf(vf));
            }else{
                ul.log("This file could not be deleted. ");
            }
        }

    }

    /**
     * adds a virtual folder to the array of virtual folders
     *
     *
     * parameters:
     * directory [String] the directory, used to initialize the golder
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void addFolder(String directory){
        String name = directory.substring(1+directory.lastIndexOf("\\"));
        VirtualFolder vfo = new VirtualFolder(name, directory);
        fileChecker.folderList.add(vfo);
        System.out.println(vfo.toString());
        //make sure to save a list of folders that remain around when its closed
    }

    /**
     * changes the color of the folder to a different one
     *
     *
     * parameters:
     * vfo [Virtual Folder] the virtual folder to change
     * color [String] the color to change it too
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void changeColor(VirtualFolder vfo, String color){
        vfo.setColor(color);
    }


}
