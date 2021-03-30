/**
* This class is an object of Mainframe that is a Jframe. It also
* includes methods to acess the jframe and files
*
* CSC 3304 Programming project No 1
*
* @author Christopher Bowen & Jon Milner
* 
* @since 
*
*/

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainMenu extends JFrame {

	/*
	 * Private data types of the Jframe for MainMenu
	 */
	
	private JPanel contentPane;
	private JTextField LogoText;
	final JLabel label = new JLabel();
	
	private JTextField infoText;
	private JTextField teamNameText;
	
	/*
	 * JFrame being used to create MainMenu
	 */
	
	 JFrame frame = new JFrame("");
	
	  /*
	   *  Private data type of selected files
	   */
	 
	 private  File[] files;
	
	 /*
	 * This is a constructor of the object mainmenu.
	 *
	 * routine: MainMenu
	 * 
	 * @author Christopher Bowen
	 * @since 
	 *
	 */
	
	public MainMenu() {
		
		 /*
		  *  Seting up the Jframe 
		  */
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("/uipack_fixed/PNG/filePic.png"));
		setTitle("FileSorter 2.0");
		setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 /*
		  *  Creating the button to go to the sort state
		  */
		
		JButton sortButton = new JButton("Sort");
		sortButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sortButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		sortButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		/*
		 *  When clicked the Jframe is updated to the sort jframe
		 */
		
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StateDemo.updatePOG.update(2);
				dispose();
				
			}
		});
		
		/*
		 *  Creating the button to go to the Select Files state
		 */
		
		JButton slectFilesButton = new JButton("Select Files");
		slectFilesButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		slectFilesButton.setToolTipText("Hold ctrl To Select Multiple Items");
		slectFilesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		slectFilesButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

		
		
		slectFilesButton.addActionListener(new ActionListener() {
			
			
			//must use ctrl to select multiple files also change because taken from stack overflow
			
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setMultiSelectionEnabled(true);

	            int option = fileChooser.showOpenDialog(frame);
	            
	            if(option == JFileChooser.APPROVE_OPTION){
	               files = fileChooser.getSelectedFiles();
	               
	               String fileNames = "";
	               for(File file: files){
	                  fileNames += file.getName() + " ";
	               }
	               label.setText("File(s) Selected: " + fileNames);
	            }else{
	               label.setText("Open command canceled");
	            }
				
	            if(files != null) {
	            
	            StateDemo.fileChecker.virtualFileInitializer(files);
				
			}
			}
		});
		
		 /*
		  *  Creating the button to go to the options state
		  */
		
		JButton optionsButton = new JButton("Options");
		optionsButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		optionsButton.addActionListener(new ActionListener() {
			
			/*
			 *  When clicked the Jframe is updated to the options jframe
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				
				StateDemo.updatePOG.update(1);
				dispose();

				
			}
		});
		
		
		 /*
		  *  Creating the Logo at the top of the JFrame
		  */
		
		LogoText = new JTextField();
		LogoText.setFocusable(false);
		LogoText.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		LogoText.setEditable(false);
		LogoText.setHorizontalAlignment(SwingConstants.CENTER);
		LogoText.setFont(new Font("DialogInput", Font.BOLD, 60));
		LogoText.setText("SortIt!");
		LogoText.setBorder(null);
		LogoText.setBackground(SystemColor.activeCaption);
		LogoText.setColumns(10);
		
		
		
		 /*
		  *  Creating a text field to help explain to the user that you must hold ctrl to select multiple files
		  */
		
		infoText = new JTextField();
		infoText.setBorder(null);
		infoText.setHorizontalAlignment(SwingConstants.CENTER);
		infoText.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		infoText.setFocusable(false);
		infoText.setEditable(false);
		infoText.setText("Hold CTRL To Select Multiple Files");
		infoText.setBackground(SystemColor.activeCaption);
		infoText.setColumns(10);
		
		 /*
		  *  Adding our Team name to the Jframe
		  */
	
		teamNameText = new JTextField();
		teamNameText.setEditable(false);
		teamNameText.setBackground(SystemColor.activeCaption);
		teamNameText.setText("HelloWorld");
		teamNameText.setSelectionColor(SystemColor.activeCaption);
		teamNameText.setSelectedTextColor(SystemColor.window);
		teamNameText.setFont(new Font("Agency FB", Font.PLAIN, 11));
		teamNameText.setColumns(10);
		
		
		 /*
		  *  Creating and setting the layout of each of the buttons on the JFrame
		  */
		
		
		GroupLayout contentPane1 = new GroupLayout(contentPane);
		
		 /*
		  *  Horizontal alignment of objects
		  */
		
		contentPane1.setHorizontalGroup(
			contentPane1.createParallelGroup(Alignment.TRAILING)
				.addGroup(contentPane1.createSequentialGroup()
					.addGap(162)
					.addGroup(contentPane1.createParallelGroup(Alignment.TRAILING)
						.addComponent(optionsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
						.addComponent(slectFilesButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
						.addComponent(sortButton, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
					.addGap(157))
				.addGroup(contentPane1.createSequentialGroup()
					.addGap(92)
					.addComponent(LogoText, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
					.addGap(75))
				.addGroup(contentPane1.createSequentialGroup()
					.addGap(189)
					.addComponent(infoText, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(185))
				.addGroup(Alignment.LEADING, contentPane1.createSequentialGroup()
					.addComponent(teamNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(478, Short.MAX_VALUE))
		);
		
		 /*
		  *  Vertical alignment of objects
		  */
		
		contentPane1.setVerticalGroup(
			contentPane1.createParallelGroup(Alignment.TRAILING)
				.addGroup(contentPane1.createSequentialGroup()
					.addContainerGap()
					.addComponent(LogoText, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(sortButton, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoText)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slectFilesButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(optionsButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(64)
					.addComponent(teamNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		 /*
		  *  Setting the layout of the current pane
		  */
		
		contentPane.setLayout(contentPane1);
		
		
		
	}
	
	/*
	* This method is a getter for the JFrame Object
	*
	* routine: getFrame
	*
	* return type: JFrame
	*
	* parameters:
	* n/a
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/

	public JFrame getFrame() {
		return frame;
		
	}
	
	/*
	* This method is a getter for the files that are selected in the JFrame
	*
	* routine: getFiles
	*
	* return type: Files[]
	*
	* parameters:
	* n/a
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public File[] getFiles() {
		return files;
	}

	/*
	* This method is a setter for the files object in the MainMenu
	*
	* routine: setFiles
	*
	* return type: void
	*
	* parameters:
	* 
	* 	File[]   Files
	* 
	* @author Christopher Bowen
	* @since 
	*
	*/
	
	public void setFiles(File[] files) {
		this.files = files;
	}

}