

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

/**
* This class is the state the program will be in when in the main menu and contains the method that
* tells the state to change if the program is in this state
*
* CSC 3380 Project
*
* @author Lukas Frick
* @edited Christopher Bowen
*/

public class MainMenuState extends State {
	
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
		if (i == 1) {
                    
                   // StateDemo.createOptions().setVisible(true);
                    StateDemo.gui.getOptions().setVisible(true);
                    return new OptionsState();
                } else if (i == 2) {
                    
                   // StateDemo.createSortFiles().setVisible(true);
                	 StateDemo.gui.getSortFiles().setVisible(true);
                    return new SortFilesState();
                } else {
                    return new MainMenuState();
                }
	}
	
	
	
}
