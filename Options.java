import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;

public class Options extends JFrame {

	/*
	 * Private data types of the Jframe for MainMenu
	 */
	
	private JPanel contentPane;
	private JTextField colorText;
	private JTextField largeFontText;
	private JTextField moreInfoText;


	/*
	 * JFrame being used to create MainMenu
	 */
	
	 JFrame frame = new JFrame("");
	 
	 /*
		 * This is a constructor of the object Options.
		 *
		 * routine: Options
		 * 
		 * @author Christopher Bowen
		 * @since 
		 *
		 */
	public Options() {
		
		//Updater updatePOG = new Updater();
		
		
		 /*
		  *  Setting up the Jframe 
		  */
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/uipack_fixed/gear2.png"));
		setTitle("File Sorter Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		 /*
		  *  Creating a label field for the Options Page
		  */
		
		JLabel TopOfPage = new JLabel("File Sorter Options ");
		TopOfPage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		TopOfPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		 /*
		  *  Creating a radio button field for Dusk mode
		  *  
		  *  (not implemented yet)
		  */

		JRadioButton DuskModeButton = new JRadioButton("Dusk Mode");
		DuskModeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		DuskModeButton.setBackground(SystemColor.activeCaption);
		
		 /*
		  *  Creating a radio button field for Large Font Mode
		  *  
		  *  (not implemented yet)
		  */
		
		JRadioButton LargeFontButton = new JRadioButton("Large Font");
		LargeFontButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		LargeFontButton.setBackground(SystemColor.activeCaption);
		
		
		 /*
		  * Creating a button field for Help
		  */
		
		JButton HelpButton = new JButton("Help");
                HelpButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		HelpButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                HelpButton.addActionListener(new ActionListener() {
                	
                	/*
        			 *  When clicked a pop up of dialog of Help 
        			 */	
                		
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "The Select Files button allows the user to choose files that will be available to sort\n"
                                        + "within the Sort menu. Holding Ctrl while selecting files allows for the selection of multiple files at once.\n\n"
                                        + "The Sort button brings the user to the Sort menu which allows the user to quickly move their chosen files\n"
                                        + "into a set of directories for organizational purposes.");
			}
			
		});
		

       /*
        * Text Box for the color radio button explaining what will happen
        */   
                
		colorText = new JTextField();
		colorText.setBorder(null);
		colorText.setEditable(false);
		colorText.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		colorText.setBackground(SystemColor.activeCaption);
		colorText.setHorizontalAlignment(SwingConstants.CENTER);
		colorText.setText("Change the color scheme ");
		colorText.setColumns(10);
		
		 /*
	      * Text Box for the large font radio button explaining what will happen
	      */ 
		
		largeFontText = new JTextField();
		largeFontText.setText("Makes the font larger");
		largeFontText.setHorizontalAlignment(SwingConstants.CENTER);
		largeFontText.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		largeFontText.setEditable(false);
		largeFontText.setColumns(10);
		largeFontText.setBorder(null);
		largeFontText.setBackground(SystemColor.activeCaption);
		
		 /*
	      * Text Box for the more information button explaining what will happen
	      */ 
		
		moreInfoText = new JTextField();
		moreInfoText.setText("More Information");
		moreInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		moreInfoText.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		moreInfoText.setEditable(false);
		moreInfoText.setColumns(10);
		moreInfoText.setBorder(null);
		moreInfoText.setBackground(SystemColor.activeCaption);
		
		
		 /*
		  * Creating a button field for going back to the mainmenu state
		  */
		
		JButton BackButton = new JButton("Back");
		
		BackButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 29));
		BackButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BackButton.setBackground(SystemColor.text);
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                    
				/*
    			 *  When clicked the state will change back to the main menu
    			 */	        
				
				StateDemo.updatePOG.update(0);
	                    dispose();
	          
			}
		});
		
		 /*
		  * Creating a button field for going back to the mainmenu state
		  */
                
                
                JButton AboutUsButton = new JButton("About Us");
                AboutUsButton.addActionListener(new ActionListener() {
			
                	public void actionPerformed(ActionEvent e) {
                		
                		/*
            			 *  When clicked a pop up of dialog of About Us
            			 */	
                		
                		JOptionPane.showMessageDialog(null, "This program is intended to be a visually appealing, intuitive GUI based program which will allow you to sort through files quickly.\n"
                                        + "Directories you can sort files into will be represented by color coded files (or custom icons) with large names, allowing for easy readability.\n"
                                        + "The program will present files one by one, and the user can quickly select which folder they want the file to be stored into, and the next file will appear immediately afterwards.\n"
                                        + "The benefits of this speed can help users who want to quickly sort their computer, and the simplistic design of the GUI can benefit those who struggle with complex GUIs.");
			}
		});
                
        AboutUsButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		AboutUsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		 /*
		  *  Horizontal alignment of objects
		  */
		
		GroupLayout contentPane1 = new GroupLayout(contentPane);
		contentPane1.setHorizontalGroup(
			contentPane1.createParallelGroup(Alignment.TRAILING)
				.addGroup(contentPane1.createSequentialGroup()
					.addGroup(contentPane1.createParallelGroup(Alignment.LEADING)
						.addGroup(contentPane1.createSequentialGroup()
							.addGap(149)
							.addComponent(HelpButton, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(49)
							.addComponent(AboutUsButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(16))
						.addGroup(contentPane1.createSequentialGroup()
							.addGap(121)
							.addComponent(TopOfPage, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
						.addGroup(contentPane1.createSequentialGroup()
							.addGap(196)
							.addGroup(contentPane1.createParallelGroup(Alignment.LEADING)
								.addComponent(LargeFontButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(DuskModeButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(BackButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
							.addGap(87))
						.addGroup(contentPane1.createSequentialGroup()
							.addGap(161)
							.addGroup(contentPane1.createParallelGroup(Alignment.LEADING)
								.addComponent(largeFontText, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addComponent(colorText, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addComponent(moreInfoText, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
							.addGap(46)))
					.addGap(145))
		);
		
		/*
		 *  Vertical alignment of objects
		 */
		
		contentPane1.setVerticalGroup(
			contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(contentPane1.createSequentialGroup()
					.addContainerGap()
					.addComponent(TopOfPage, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(19)
					.addComponent(moreInfoText, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(contentPane1.createParallelGroup(Alignment.BASELINE)
						.addComponent(HelpButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(AboutUsButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addGap(45)
					.addComponent(colorText, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DuskModeButton, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(largeFontText, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LargeFontButton, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
					.addGap(93)
					.addComponent(BackButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		
		 /*
		  *  Setting the layout of the current pane
		  */
		
		contentPane.setLayout(contentPane1);
	}
}