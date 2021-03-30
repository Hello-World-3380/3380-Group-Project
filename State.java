/**
* This class is the abstract state that all of the other state classes override
*
* CSC 3380 Project
*
* @author Lukas Frick
* 
*/

abstract class State {

	/*
	 * This is an abstract method to handle updating the state
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
	
	abstract State handleUpdate(int i);
        
	
}