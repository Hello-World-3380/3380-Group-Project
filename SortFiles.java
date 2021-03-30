import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SortFiles extends JFrame {

	private JPanel contentPane;
	private JTextField txtPercentSorted;
	private JTextField displayName;
	private JTextField txtDeleteFile;
	private JTextField txtSortLater;
	private JTextField theEnd;
	private JButton addDirectory;
	private JTextField txtAddNewDirectory;
	private JButton directory1;
	private JButton directory2;
	private JButton directory3;
	private JLabel lblNewLabel;
	private JButton directory4;
	private JButton directory5;
	static JPopupMenu pm;
	static JFrame f;
	static JButton b;
	private int currentDirectory = 0;

	private boolean isImage = false; //false is icon true is image
	private BufferedImage imageContainer;
	private Icon iconContainer;
	private boolean isBeingInvoked = false;

	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */
	public SortFiles() {
		//updatePOG = new Updater();

		/*
		 * This gives the GUI the template to work in.
		 * Make the window non-resizable and gives the size of the JPanel
		 *
		 */
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SortFiles.class.getResource("/uipack_fixed/preview.png")));
		setTitle("FileSorter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//The progress bar and how it appears in the GUI
		JProgressBar progressBar = new JProgressBar(); // Making the progress bar

		//The progress bar is going to be used to show how many of the selected files have been sorted
		//The progress bar text box
		txtPercentSorted = new JTextField(); //Making the text box
		txtPercentSorted.setBackground(SystemColor.activeCaption);
		txtPercentSorted.setBorder(null);
		txtPercentSorted.setText("Percent Sorted");	//The text
		txtPercentSorted.setColumns(10);	//Size of the text box

		//Delete button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The delete button will permanently delete a file from the system
		//The button itself also is a png icon of a trash can for easy discernibility
		JButton deleteButton = new JButton("");
		deleteButton.setBackground(SystemColor.activeCaption);
		deleteButton.setBorderPainted(false); // No background
		deleteButton.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/PNG/trashcan.png"))); //Icon for the button
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.fileController.deleteFile(StateDemo.fileChecker.fileList.get(0));
				repaint();
			}
		});



		//This lables the delete file button so the user knows where to click to carry out the function
		//It also formats the way that the text box looks in the JPanel
		//Delete file text box
		txtDeleteFile = new JTextField();
		txtDeleteFile.setBackground(SystemColor.activeCaption);
		txtDeleteFile.setBorder(null);
		txtDeleteFile.setHorizontalAlignment(SwingConstants.CENTER); // Centering the text
		txtDeleteFile.setText("Delete File"); //The text
		txtDeleteFile.setColumns(10);	//Size of the box


		///Sort Later button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The Sort Later button will put a file at the end of the linked list to be sorted later
		//The button itself also is a png icon of a clock for easy discernibility
		JButton sortLaterButton = new JButton(""); //Name of the button
		sortLaterButton.setBackground(SystemColor.activeCaption);
		sortLaterButton.setBorder(null);
		sortLaterButton.setBorderPainted(false); // No background
		sortLaterButton.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/PNG/sortlater.png"))); //Icon for the button
		sortLaterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				StateDemo.fileController.sortLater();
				repaint();

			}
		});

		//This lables the sort later file button so the user knows where to click to carry out the function
		//It also formats the way that the text box looks in the JPanel
		//Sort Later text box
		txtSortLater = new JTextField(); //Making text box
		txtSortLater.setBackground(SystemColor.activeCaption);
		txtSortLater.setBorder(null);
		txtSortLater.setHorizontalAlignment(SwingConstants.CENTER);	// Centering the text
		txtSortLater.setText("Sort Later"); //The text
		txtSortLater.setColumns(10);	//Size of the box

		///Edit Directory button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The edit directory button will allow the user to add a directory, edit directory or remove a directory
		//The button itself also is a png icon of a file with a plus for easy discernibility
		//The action also calls for a pop up menu
		addDirectory = new JButton("");
		addDirectory.setOpaque(false);
		addDirectory.setBackground(SystemColor.activeCaption);
		addDirectory.setBorder(null);
		addDirectory.setBorderPainted(false); // No background
		addDirectory.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/PNG/add.png"))); //Icon for the button
		addDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				//if you click the create new one

				popup p = new popup();



			}
		});





		//This lables the Edit Directory file button so the user knows where to click to carry out the function
		//It also formats the way that the text box looks in the JPanel
		//Edit Directory text box
		txtAddNewDirectory = new JTextField(); //Making text box
		txtAddNewDirectory.setBackground(SystemColor.activeCaption);
		txtAddNewDirectory.setBorder(null);
		txtAddNewDirectory.setText("Edit directory"); //The text
		txtAddNewDirectory.setHorizontalAlignment(SwingConstants.CENTER); // Centering the text
		txtAddNewDirectory.setColumns(10);


		///Back button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The back button will allow the user to return to main menu
		JButton back = new JButton("Back");
		back.setFont(new Font("DialogInput", Font.PLAIN, 20));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.updatePOG.update(0);
				dispose();


			}
		});

		//Directory 1 button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The directory will have a pink color folder image to easily differentiate between directories
		//The directory is also labeled default "directory 1" and the user is able to change it if they wish
		//It is also set by default to not be visible until the user adds that directory
		//The action will move the current file being evaulted to the desired directory
		directory1 = new JButton("Directory 1");
		directory1.setHorizontalTextPosition(SwingConstants.CENTER);
		directory1.setVerticalTextPosition(SwingConstants.BOTTOM);
		directory1.setBackground(SystemColor.activeCaption);
		directory1.setBorder(null);
		directory1.setBorderPainted(false);
		directory1.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/rsz_pink_folder.png")));
		directory1.setVisible(false);
		directory1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(StateDemo.fileChecker.fileList.size()>0) {
					StateDemo.fileController.moveFile(StateDemo.fileChecker.fileList.get(0), StateDemo.fileChecker.folderList.get(0));

				}
				repaint();

			}

		});

		//Directory 2 button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The directory will have a yellow color folder image to easily differentiate between directories
		//The directory is also labeled default "directory 2" and the user is able to change it if they wish
		//It is also set by default to not be visible until the user adds that directory
		//The action will move the current file being evaulted to the desired directory
		directory2 = new JButton("Directory 2");
		directory2.setVerticalTextPosition(SwingConstants.BOTTOM);
		directory2.setVerticalAlignment(SwingConstants.BOTTOM);
		directory2.setHorizontalAlignment(SwingConstants.LEADING);
		directory2.setHorizontalTextPosition(SwingConstants.CENTER);
		directory2.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/rsz_yellow_folder.png")));
		directory2.setBorderPainted(false);
		directory2.setBorder(null);
		directory2.setBackground(SystemColor.activeCaption);
		directory2.setVisible(false);
		directory2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.fileController.moveFile( StateDemo.fileChecker.fileList.get(0), StateDemo.fileChecker.folderList.get(1));
				repaint();
			}
		});

		//Directory 3 button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The directory will have a blue color folder image to easily differentiate between directories
		//The directory is also labeled default "directory 3" and the user is able to change it if they wish
		//It is also set by default to not be visible until the user adds that directory
		//The action will move the current file being evaulted to the desired directory
		directory3 = new JButton("Directory 3");
		directory3.setHorizontalTextPosition(SwingConstants.CENTER);
		directory3.setVerticalTextPosition(SwingConstants.BOTTOM);
		directory3.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/rsz_blue_folder.png")));
		directory3.setBorderPainted(false);
		directory3.setBorder(null);
		directory3.setBackground(SystemColor.activeCaption);
		directory3.setVisible(false);
		directory3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.fileController.moveFile( StateDemo.fileChecker.fileList.get(0), StateDemo.fileChecker.folderList.get(2));
				repaint();
			}
		});

		//Directory 4 button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The directory will have a green color folder image to easily differentiate between directories
		//The directory is also labeled default "directory 4" and the user is able to change it if they wish
		//It is also set by default to not be visible until the user adds that directory
		//The action will move the current file being evaulted to the desired directory
		directory4 = new JButton("Directory 4");
		directory4.setVerticalTextPosition(SwingConstants.BOTTOM);
		directory4.setHorizontalTextPosition(SwingConstants.CENTER);
		directory4.setVisible(false);
		directory4.setBorderPainted(false);
		directory4.setBackground(SystemColor.activeCaption);
		directory4.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/rsz_green_folder.png")));
		directory4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.fileController.moveFile( StateDemo.fileChecker.fileList.get(0), StateDemo.fileChecker.folderList.get(3));
				repaint();
			}
		});

		displayName = new JTextField(); //Making text box
		displayName .setBackground(SystemColor.activeCaption);
		displayName .setBorder(null);
		displayName .setHorizontalAlignment(SwingConstants.CENTER);	// Centering the text
		displayName .setText("Sort Later"); //The text
		displayName .setColumns(10);
		//Directory 5 button and how it appears in the GUI
		//The button has no border and is painted the same color as the background
		//The directory will have a red color folder image to easily differentiate between directories
		//The directory is also labeled default "directory 5" and the user is able to change it if they wish
		//It is also set by default to not be visible until the user adds that directory
		//The action will move the current file being evaulted to the desired directory
		directory5 = new JButton("Directory 5");
		directory5.setHorizontalTextPosition(SwingConstants.CENTER);
		directory5.setVerticalTextPosition(SwingConstants.BOTTOM);
		directory5.setVisible(false);
		directory5.setIcon(new ImageIcon(SortFiles.class.getResource("/uipack_fixed/rsz_red_folder.png")));
		directory5.setBorderPainted(false);
		directory5.setBackground(SystemColor.activeCaption);
		directory5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StateDemo.fileController.moveFile( StateDemo.fileChecker.fileList.get(0), StateDemo.fileChecker.folderList.get(4));
				repaint();
			}
		});




		//This allows for each object to be placed in its desired position in the JFrame

		GroupLayout gl_contentPane = new GroupLayout(contentPane);

		//Horizontal Position
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(addDirectory, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(10)
																		.addComponent(txtAddNewDirectory, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
														.addGap(39)
														.addComponent(directory1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
														.addComponent(directory2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
														.addGap(24))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(35)
														.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 407, Short.MAX_VALUE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(67)
														.addComponent(txtPercentSorted, 150, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
														.addComponent(back, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addGap(32)))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(27)
												.addComponent(directory4)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(39)
												.addComponent(directory3, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(txtDeleteFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addContainerGap())))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(184)
												.addComponent(directory5, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(10)
																.addComponent(txtSortLater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(sortLaterButton))
												.addGap(22))))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(198, Short.MAX_VALUE)
								.addGap(623))
		);

		//Verticle Position
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtDeleteFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(addDirectory)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtAddNewDirectory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(directory1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
												.addComponent(directory2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
												.addComponent(directory3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
								.addGap(70)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(directory5)
										.addComponent(directory4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(342)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(115)
												.addComponent(txtPercentSorted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(sortLaterButton)
														.addComponent(back, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSortLater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())

		);
		contentPane.setLayout(gl_contentPane);

		loadFirstFolders();
	}

	private void loadFirstFolders(){
		System.out.println("Loading old folders");
		for(int i = 0; i<StateDemo.fileChecker.folderList.size();i++){
			createDirectory(new File(StateDemo.fileChecker.folderList.get(i).getDir()),StateDemo.fileChecker.folderList.get(i).getName(),false);
		}

	}
	/**
	 * Paints the image or icons on the GUI as you sort through your files
	 * Paints the image or icons on the GUI as you sort through your files
	 *
	 * routine: SortFiles
	 *
	 * parameters:
	 * g [Graphics] the engine to send the draw call too
	 *
	 * @author Gareth Bloemeke
	 * @since 3/6/2021
	 *
	 */
	public void paint(Graphics g) {
		//Override paint method in superclass
		super.paint(g);
		//Graphics2D g2 = (Graphics2D) g;

		if(StateDemo.fileChecker.fileList.size()>0) {
			if (StateDemo.fileChecker.fileList.get(0) != null) {
				txtPercentSorted.setText(StateDemo.fileChecker.fileList.get(0).getFullName());
				if (StateDemo.fileChecker.fileList.get(0).getFileType().equals("IMAGE")) {
					try {
						g.drawImage(StateDemo.fileChecker.fileList.get(0).getImage(), 500, 500, 200, 200, null);
					} catch (IOException b) {

					}
				} else {
					Icon icon = StateDemo.fileChecker.fileList.get(0).getIcon();
					int w = icon.getIconWidth();
					int h = icon.getIconHeight();
					GraphicsEnvironment ge =
							GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice gd = ge.getDefaultScreenDevice();
					GraphicsConfiguration gc = gd.getDefaultConfiguration();
					BufferedImage image = gc.createCompatibleImage(w, h, 1);
					Graphics2D g2 = image.createGraphics();
					icon.paintIcon(null, g2, 0, 0);
					g2.dispose();
					g.drawImage(image, 400, 400, 200, 200, null);
				}
			}
		}
	}

	//This will allow the user to edit the name of directory that they created
	private void EditDirectory(JButton directory, File path, String Name) {
		directory.setName(path.getAbsolutePath());
		directory.setText(Name);
	}

	//This is how the directories are created when the user pushes the add directory button
	//We have a limit of 5 directories that can be created
	//Also allows the user to choose the name of the directoy
	public void createDirectory(File path, String Name, boolean notFirst) {
		currentDirectory+=1;
		if(currentDirectory >= 5) {
			return;

		}else {
			switch(currentDirectory) {

				case 1:
					directory1.setVisible(true);
					directory1.setName(path.getAbsolutePath());
					directory1.setText(Name);
					if(notFirst) {
						StateDemo.fileController.addFolder(path.getAbsolutePath());
					}
					if (Name == null) {
						directory1.setText(path.getName());
					}
					break;
				case 2:
					directory2.setVisible(true);
					directory2.setName(path.getAbsolutePath());
					directory2.setText(Name);
					if(notFirst) {
						StateDemo.fileController.addFolder(path.getAbsolutePath());
					}
					if (Name == null) {
						directory2.setText(path.getName());
					}
					break;
				case 3:
					directory3.setVisible(true);
					directory3.setName(path.getAbsolutePath());
					directory3.setText(Name);
					if(notFirst) {
						StateDemo.fileController.addFolder(path.getAbsolutePath());
					}
					if (Name == null) {
						directory3.setText(path.getName());
					}
					break;
				case 4:
					directory4.setVisible(true);
					directory4.setName(path.getAbsolutePath());
					directory4.setText(Name);
					if(notFirst) {
						StateDemo.fileController.addFolder(path.getAbsolutePath());
					}
					if (Name == null) {
						directory4.setText(path.getName());
					}
					break;
				case 5:
					directory5.setVisible(true);
					directory5.setName(path.getAbsolutePath());
					directory5.setText(Name);
					if(notFirst) {
						StateDemo.fileController.addFolder(path.getAbsolutePath());
					}
					if (Name == null) {
						directory5.setText(path.getName());
					}
					break;
				default:
					break;
			}
			repaint();
		}
	}

	//This will delete a created
	private void deleteDirectory(int i) {
		if(i > currentDirectory) {
			return;
		}else {
			switch(i) {

				case 1:
					directory1.setVisible(false);
					directory1.setName(null);
					directory1.setText("");
					StateDemo.fileChecker.folderList.remove(0);

					break;
				case 2:
					directory2.setVisible(false);
					directory2.setName(null);
					directory2.setText("");
					StateDemo.fileChecker.folderList.remove(1);

					break;
				case 3:
					directory3.setVisible(false);
					directory3.setName(null);
					directory3.setText("");
					StateDemo.fileChecker.folderList.remove(2);

					break;
				case 4:
					directory4.setVisible(false);
					directory4.setName(null);
					directory4.setText("");
					StateDemo.fileChecker.folderList.remove(3);
					break;
				case 5:
					directory5.setVisible(false);
					directory5.setName(null);
					directory5.setText("");
					StateDemo.fileChecker.folderList.remove(4);

					break;
				default:
					break;
			}
			currentDirectory-=1;

		}

	}

	//This class is what creates the pop up that allows the options for the edit directory button
	private class popup extends JFrame implements ActionListener {
		// popup
		Popup editDir;

		// constructor
		popup()
		{
			setResizable(false);
			setBounds(100, 100, 450, 575);
			// create a frame
			JFrame dirEd = new JFrame("directory editor");


			dirEd.setSize(450, 575);

			PopupFactory pf = new PopupFactory();

			// create a panel
			JPanel p2 = new JPanel();



			// set Background of panel
			p2.setBackground(Color.red);



			// create a popup
			editDir = pf.getPopup(dirEd, p2, 180, 100);

			// create a button
			JButton create = new JButton("create new directory");
			create.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//if you click the create new one
					String name = JOptionPane.showInputDialog("Enter Name Of New Directory: ");

					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int option = fileChooser.showOpenDialog(contentPane);
					if(option == JFileChooser.APPROVE_OPTION){
						File file = fileChooser.getSelectedFile();
						createDirectory(file,name,true);
					}else {

						System.out.println("Welp");
					}




				}



			});


			JButton remove = new JButton("Remove a directory");
			remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int directory = Integer.parseInt(JOptionPane.showInputDialog("Enter Number Of Directory: "));

					deleteDirectory(directory);






				}


			});


			JButton edit = new JButton("Edit an existing directory");
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					int directory = Integer.parseInt(JOptionPane.showInputDialog("Enter Number Of Directory: "));

					//editDirectory(directory);







				}


			});


			// create a panel
			JPanel poppyUp = new JPanel();
			poppyUp.setBackground(SystemColor.activeCaption);

			//Adds the buttons to the popup
			poppyUp.add(create);
			poppyUp.add(remove);
			poppyUp.add(edit);
			dirEd.getContentPane().add(poppyUp);
			dirEd.show();

			//Labels the pop up menu to allow the user to know the purpose of the popup and how to navigate it
			JTextField txtDirectoryEditor = new JTextField();
			txtDirectoryEditor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			txtDirectoryEditor.setBackground(SystemColor.activeCaption);
			txtDirectoryEditor.setHorizontalAlignment(SwingConstants.CENTER);
			txtDirectoryEditor.setText("Directory Editor");
			txtDirectoryEditor.setColumns(10);

			//The verticle and horizontal layout of the buttons and text in the popup window
			GroupLayout gl_contentPane = new GroupLayout(poppyUp);
			//Horizontal
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(124)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(txtDirectoryEditor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
											.addComponent(create, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
											.addComponent(edit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
											.addComponent(remove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(137))
			);
			//Vertical
			gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(txtDirectoryEditor, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(70)
									.addComponent(create, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(remove, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(52)
									.addComponent(edit, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(73, Short.MAX_VALUE))
			);
			poppyUp.setLayout(gl_contentPane);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	}


}
