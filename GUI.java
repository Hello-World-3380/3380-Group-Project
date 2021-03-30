/**
* This class is an object of GUI that is a collection of MainMenu, Options, and SortFiles objects that are Jframes.
*  It also includes methods
*
* CSC 3380 Project
*
* @author Christopher Bowen & Jon Milner
* 
* @since 
*
*/

public class GUI {
	
	
	/**
	 * Private data types of the GUI
	 */

	private Options Options;
	private MainMenu MainMenu;
	private SortFiles SortFiles;
	
	
	/**
	 * This is a constructor of the object GUI
	 *
	 * routine: GUI
	 * 
	 * @author Christopher Bowen
	 * @since 
	 *
	 */
	public GUI() {
		
		this.Options = new Options();
		this.MainMenu = new MainMenu();
		this.SortFiles= new SortFiles();
		
	}
	
	/*
	* This method is a getter for the Options Object
	*
	* routine: getOptions
	*
	* return type: Options
	*
	* parameters:
	* n/a
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/

	public Options getOptions() {
		return Options;
	}
	
	/*
	* This method is a setter for the Options object
	*
	* routine: setSortFiles
	*
	* return type: void
	*
	* parameters:
	* 
	* 	Options options
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/ 
	
	public void setOptions(Options options) {
		Options = options;
	}

	/*
	* This method is a getter for the MainMenu Object
	*
	* routine: getMainMenu
	*
	* return type: MainMenu
	*
	* parameters:
	* n/a
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public MainMenu getMainMenu() {
		return MainMenu;
	}
	
	/*
	* This method is a setter for the MainMenu object
	*
	* routine: setSortFiles
	*
	* return type: void
	*
	* parameters:
	* 
	* 	MainMenu mainMenu
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public void setMainMenu(MainMenu mainMenu) {
		MainMenu = mainMenu;
	}

	/*
	* This method is a getter for the SortFiles Object
	*
	* routine: getSortFiles
	*
	* return type: SortFiles
	*
	* parameters:
	* n/a
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public SortFiles getSortFiles() {
		return SortFiles;
	}
	
	/*
	* This method is a setter for the SortFiles object
	*
	* routine: setSortFiles
	*
	* return type: void
	*
	* parameters:
	* 
	* 	SortFiles sortFiles
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public void setSortFiles(SortFiles sortFiles) {
		SortFiles = sortFiles;
	}
	
}
