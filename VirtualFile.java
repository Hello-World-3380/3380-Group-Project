

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This object contains a virtual representation of the files
 * being sorted.
 *
 * CSC 3304 Programming project No 1
 *
 * @author Gareth Bloemeke
 * @since 3/6/2021
 *
 */


public class VirtualFile {

    /**
     * A String used to store the file's name
     */
    private String name;

    /**
     * A String used to store the file's location
     */
    private String location;

    /**
     * A String used to store the file's extension
     */
    private String extension;

    /**
     * A String used to store the type of a file (based on the file's extension)
     */
    private String fileType;

    /**
     * A String used to store the file's name and extension, used in toString
     */
    private String fullName;

    /**
     * Stores the file object for easy use
     */
    private File file;

    /**
     * Construct a virtual file, assigns values to name, location, extension and fullname
     *
     * routine: VirtualFile
     *
     * return type: none
     *
     * parameters:
     * nameIn [String] the name of the file
     * locationIn [String] the location of the file
     * extensionIn [String] the file extension
     * typeIn [String] takes in the type of the file
     *
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public VirtualFile(String nameIn, String locationIn, String extensionIn, String typeIn, File fileIn){
        this.name = nameIn;
        this.location = locationIn;
        this.extension = extensionIn;
        this.fullName=nameIn+"."+extensionIn;
        this.fileType = typeIn;
        this.file = fileIn;
    }

    /**
     * Gets the name of the file
     *
     * routine: getName
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the file
     *
     * routine: setName
     *
     * parameters:
     * name [String] the name to update name to
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void setName(String name) {
        this.name = name;
        this.fullName = this.name+"."+this.extension;
    }

    /**
     * Gets the location of the file
     *
     * routine: getLocation
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the full name of the file (with extension)
     *
     * routine: getLocation
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getFullName(){
        return fullName;
    }

    /**
     * Sets the location of the file
     *
     * routine: setLocation
     *
     * parameters:
     * location [String] the location to update location to
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the extension of the file
     *
     * routine: getLocation
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Gets the fileType of the file
     *
     * routine: getFileType
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the extension of the file
     *
     * routine: setExtension
     *
     * parameters:
     * name [String] the extension to update extension to
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void setExtension(String extension) {
        this.extension = extension;
        this.fullName = this.name+"."+this.extension;
    }

    /**
     * Returns a String version of the file for reference and logging capabilities
     *
     * routine: toString
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String toString(){
        return "Name: " + this.fullName + " Location: " + this.location + " Type: "+ this.fileType;
    }


    /**
     * Returns a String version of the file for reference and logging capabilities
     *
     * routine: toExportString
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String toExportString(){
        return location;
    }

    /**
     * Returns a File object for reference
     *
     * routine: getFile
     *
     * return type: File
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */

    public File getFile() { return file; }

    /**
     * Returns a Icon object for use in rendering
     *
     * routine: getIcon
     *
     * return type: Icon
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */

    public Icon getIcon(){
        return FileSystemView.getFileSystemView().getSystemIcon(this.file);
    }

    /**
     * Returns a BufferedImage object for use in rendering
     *
     * routine: getImage
     *
     * return type: BufferedImage
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public BufferedImage getImage()throws java.io.IOException{
        return ImageIO.read(this.file);
    }

}