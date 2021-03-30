
public class VirtualFolder {

    /**
     * A String used to store the folder's name
     */
    private String name;

    /**
     * A String used to store the folder's directory
     */
    private String dir;

    /**
     * A String used to store the folder's color
     */
    private String color;

    /**
     * Construct a virtual Folder, assigns values to name and directory
     *
     * routine: VirtualFolder
     *
     * return type: none
     *
     * parameters:
     * nameIn [String] the name of the folder
     * dirIn [String] the location of the directory
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public VirtualFolder(String nameIn, String dirIn){
        this.name = nameIn;
        this.dir = dirIn;
    }


    /**
     * Returns a name sstring for reference
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
     * Sets the name of the folder
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
    }

    /**
     * Returns a directory string for reference
     *
     * routine: getDir
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */

    public String getDir() {
        return dir;
    }

    /**
     * Sets the directory of the folder
     *
     * routine: setDir
     *
     * parameters:
     * directory [String] the name to update directory to
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * Returns a color string for reference
     *
     * routine: getColor
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the folder
     *
     * routine: setColor
     *
     * parameters:
     * color [String] the color to update folder to
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a String version of the folder for reference and logging capabilities
     *
     * routine: toExportString
     *
     * return type: String
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */

    public String toExportString(){ return name + " " + dir + " " + color;}


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
        return "Name: " + name + " Directory " + dir + " Color: " + color;
    }
}