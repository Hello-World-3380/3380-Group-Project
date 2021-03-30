import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This object contains a file checker that creates a new set of files and checks their validity and type
 * being sorted.
 *
 * CSC 3304 Programming project No 1
 *
 * @author Gareth Bloemeke
 * @since 3/6/2021
 *
 */

public class FileChecker {

    /**
     * A List used to store all the virtual files in the session
     */
    public List<VirtualFile> fileList = new ArrayList<>();
    /**
     * A String used to store all the virtual folders in the session
     */
    public List<VirtualFolder> folderList = new ArrayList<>();

    private ImportLog im;

    /**
     * Construct a File Checker
     *
     * routine: FileChecker
     *
     * return type: none
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public FileChecker(ImportLog im){
        this.im = im;
    }

    /**
     * Virtual File Initializer takes an input of files and constructs a virtual file
     * object for use by the program
     *
     * routine: File Checker
     *
     *
     * parameters:
     * Files[] files a list of files from the browser
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public void virtualFileInitializer(File[] files){
        int indexofextension;
        String fullName, name,extension;
        for(int i = 0; i<files.length; i++){
            fullName = files[i].getName();
            indexofextension=fullName.lastIndexOf('.');
            if(indexofextension==-1){
                name = fullName;
                extension = "";
            }else{
                name = fullName.substring(0,indexofextension);
                extension = fullName.substring(indexofextension+1).toLowerCase();
            }
            VirtualFile vf = new VirtualFile(name,files[i].getAbsolutePath(),extension,TypeMatch(extension),files[i]);
            im.log("Added a file: "+ vf.toString());
            fileList.add(vf);
        }
    }

    /**
     * TypeMatch matches most common file formats with a type, IMAGE, AUDIO TEXT VIDEO or FILE
     * This is used to aid the renderer later on as well as keep track of major things
     *
     * routine: File Checker
     *
     *
     * parameters:
     * String extension - the extension of the file
     *
     * @author Gareth Bloemeke
     * @since 3/6/2021
     *
     */
    public String TypeMatch(String extension){
        switch (extension) {
            case "gif":
            case "png":
            case "jpg":
            case "jpeg":
            case "bmp":
            case "wbmp":
            case "hdr":
            case "icns":
            case "iff":
            case "pcx":
            case "pict":
            case "pnm":
            case "psd":
            case "sgi":
            case "tga":
            case "tif":
            case "webp":
            case "thumbsdb":
                return "IMAGE";
            case "pcm":
            case "wav":
            case "aiff":
            case "mp3":
            case "acc":
            case "ogg":
            case "flac":
            case "wma":
            case "alac":
            case "m4a":
            case "midi":
                return "AUDIO";
            case "txt":
            case "pptx":
            case "docx":
            case "pdf":
                return "TEXT";
            case "avchd":
            case "avi":
            case "flv":
            case "mkv":
            case "mov":
            case "mp4":
            case "webm":
            case "wmv":
                return "VIDEO";
            default:
                return "FILE";
        }
    }
}
