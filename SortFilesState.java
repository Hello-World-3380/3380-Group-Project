

import javax.swing.JFrame;

/**
* This class is the state the program will be in when in the options menu and contains the method that
* tells the state to change if the program is in this state
*
* CSC 3380 Project
*
* @author Lukas Frick
* @edit Christopher Bowen
* 
*/
public class SortFilesState extends State{

	
	/*
	 * This is an abstract implementation of the method to handle updating the state
	 *
	 * routine:handleUpdate
	 *
	 * parameters:
	 * 
	 * int i 
	 * 
	 * @author Lukas Frick
	 * @edit Christopher Bowen
	 *
	 */
	@Override
	State handleUpdate(int i) {
            // TODO Auto-generated method stub
           // StateDemo.createMainMenu().setVisible(true);
         StateDemo.gui.getMainMenu().setVisible(true);
            return new MainMenuState();
	}
}
