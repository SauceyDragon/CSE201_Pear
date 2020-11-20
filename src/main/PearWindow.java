package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class PearWindow {

	private static PearWindow window;
	private JFrame frame;
	private JFrame frameView;
	private JFrame frameSortZA;
	private JFrame frameLog;
	private JFrame frameSortAZ;
	private JFrame frameFilter;
	private JFrame frameSearch;
	private JFrame frameComment;
	private JFrame frameRequest;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField txtEnterPrice;
	private JTextField txtEnterName;
	private JTextField textEnterComment;
	private JTextField textCommentNumber;
	private User u;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Store pear = new Store();
		
		pear.appList.add(new Application("Twitter", "A social media app for messages" , "twitter.co", "iphone", "2.0", "twittee.com", 0.99));
		pear.appList.add(new Application("Reddit", "A formum site" , "reddit", "windows", "1.6", "reddit.com", 1.95));
		pear.appList.add(new Application("Instagram", "A social media app for photos" , "facebook", "iphone", "1.0", "instagram.com", 2.99)); 
		pear.reqList.add(new Application("Twitch", "A streaming site for gamers" , "amazon.co", "windows", "1.6", "twitch.tv", 5.00));
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PearWindow(pear, pear.appList);
					//window.frame.setVisible(true);
					window.frameLog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PearWindow(Store s,ArrayList<Application> arrList) {
		u = new User();
		initialize(s,arrList);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Store s,ArrayList<Application> arrList) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frameView = new JFrame();
		frameView.getContentPane().setBackground(Color.WHITE);
		frameView.setBounds(100, 100, 700, 500);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameView.getContentPane().setLayout(null);
		
		frameSortZA = new JFrame();
		frameSortZA.getContentPane().setBackground(Color.WHITE);
		frameSortZA.setBounds(100, 100, 700, 500);
		frameSortZA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSortZA.getContentPane().setLayout(null);
		
		frameLog = new JFrame();
		frameLog.getContentPane().setBackground(Color.WHITE);
		frameLog.setBounds(100, 100, 700, 500);
		frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLog.getContentPane().setLayout(null);
		
		frameSortAZ = new JFrame();
		frameSortAZ.getContentPane().setBackground(Color.WHITE);
		frameSortAZ.setBounds(100, 100, 700, 500);
		frameSortAZ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSortAZ.getContentPane().setLayout(null);
		
		frameFilter = new JFrame();
		frameFilter.getContentPane().setBackground(Color.WHITE);
		frameFilter.setBounds(100, 100, 700, 500);
		frameFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFilter.getContentPane().setLayout(null);
		
		frameSearch = new JFrame();
		frameSearch.getContentPane().setBackground(Color.WHITE);
		frameSearch.setBounds(100, 100, 700, 500);
		frameSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSearch.getContentPane().setLayout(null);

		frameComment = new JFrame();
		frameComment.getContentPane().setBackground(Color.WHITE);
		frameComment.setBounds(100, 100, 700, 500);
		frameComment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameComment.getContentPane().setLayout(null);
		
		frameRequest = new JFrame();
		frameRequest.getContentPane().setBackground(Color.WHITE);
		frameRequest.setBounds(100, 100, 700, 500);
		frameRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRequest.getContentPane().setLayout(null);
		
		login(s,arrList);
		//home(s,arrList);
		//view(s,arrList,0);
		//comment(s,arrList,0);
		//requests(s,false);
	}
	public void requests(Store s, boolean isAdmin) {
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(true);
		window.frameComment.setVisible(false);
		
		
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameRequest.getContentPane().add(lblNewLabel);
		
		
		if(isAdmin) {

			if(s.reqList.isEmpty()) {
				JLabel lblNewLabel_1 = new JLabel("No current requests");
				lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(39, 92, 243, 16);
				frameRequest.getContentPane().add(lblNewLabel_1);
				
			}
			
			else {
			
				int x = 0;
				
				JLabel lblNewLabel_1 = new JLabel(s.reqList.get(x).getName());
				lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(39, 92, 243, 16);
				frameRequest.getContentPane().add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel(s.reqList.get(x).getDescription());
				lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(63, 135, 274, 16);
				frameRequest.getContentPane().add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel(s.reqList.get(x).getLink());
				lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(63, 191, 266, 16);
				frameRequest.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Developed by " + s.reqList.get(x).getOrganization());
				lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(63, 248, 266, 16);
				frameRequest.getContentPane().add(lblNewLabel_4);
			
				JLabel lblNewLabel_5 = new JLabel("For " + s.reqList.get(x).getPlatform());
				lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(63, 363, 266, 16);
				frameRequest.getContentPane().add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("Version: " + s.reqList.get(x).getVersion());
				lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_6.setBounds(63, 309, 266, 16);
				frameRequest.getContentPane().add(lblNewLabel_6);
				
				JLabel lblNewLabel_7 = new JLabel("$ " + String.valueOf(s.reqList.get(x).getPrice()));
				lblNewLabel_7.setFont(new Font("Apple Braille", Font.PLAIN, 15));
				lblNewLabel_7.setBounds(63, 417, 266, 16);
				frameRequest.getContentPane().add(lblNewLabel_7);
				
			
				JButton btnNewButton_4 = new JButton("Approve");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						s.appList.add(s.reqList.get(x));
						s.reqList.remove(x);
						
						window.frameRequest.dispose();
						frameRequest = new JFrame();
						frameRequest.getContentPane().setBackground(Color.WHITE);
						frameRequest.setBounds(100, 100, 700, 500);
						frameRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameRequest.getContentPane().setLayout(null);
						requests(s,true);
					}
				});
				btnNewButton_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
				btnNewButton_4.setBounds(555, 92, 117, 29);
				frameRequest.getContentPane().add(btnNewButton_4);
				
				JButton btnNewButton_9 = new JButton("Deny");
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						s.reqList.remove(x);
						
						window.frameRequest.dispose();
						frameRequest = new JFrame();
						frameRequest.getContentPane().setBackground(Color.WHITE);
						frameRequest.setBounds(100, 100, 700, 500);
						frameRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameRequest.getContentPane().setLayout(null);
						requests(s,true);
					}
				});
				btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
				btnNewButton_9.setBounds(555, 157, 117, 29);
				frameRequest.getContentPane().add(btnNewButton_9);
				
				
			}
		}
		else {
			JLabel lblNewLabel_1 = new JLabel("Make Request");
			lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(39, 92, 243, 16);
			frameRequest.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Name:  ");
			lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(79, 120, 60, 16);
			frameRequest.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Description:");
			lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(79, 148, 99, 16);
			frameRequest.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Organization:");
			lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(79, 176, 113, 16);
			frameRequest.getContentPane().add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Platform:");
			lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(79, 204, 113, 16);
			frameRequest.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Version:");
			lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_6.setBounds(79, 232, 113, 16);
			frameRequest.getContentPane().add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Link:");
			lblNewLabel_7.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_7.setBounds(79, 260, 113, 16);
			frameRequest.getContentPane().add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Price:");
			lblNewLabel_8.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_8.setBounds(79, 288, 113, 16);
			frameRequest.getContentPane().add(lblNewLabel_8);
			
			textField = new JTextField();
			textField.setBounds(246, 113, 243, 26);
			frameRequest.getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(246, 141, 243, 26);
			frameRequest.getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(246, 169, 243, 26);
			frameRequest.getContentPane().add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(246, 197, 243, 26);
			frameRequest.getContentPane().add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(246, 225, 243, 26);
			frameRequest.getContentPane().add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(246, 253, 243, 26);
			frameRequest.getContentPane().add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(246, 281, 243, 26);
			frameRequest.getContentPane().add(textField_6);
			
			JButton btnNewButton_8 = new JButton("Make Request");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().isEmpty() || textField.getText().equals("Enter a Title")) {
						textField.setText("Enter a Title");
					}
					else if(textField_1.getText().isEmpty() || textField_1.getText().equals("Enter a Description")) {
						textField_1.setText("Enter a Description");
					}
					else if(textField_2.getText().isEmpty() || textField_2.getText().equals("Enter a Organization")) {
						textField_2.setText("Enter a Organization");
					}
					else if(textField_3.getText().isEmpty() || textField_3.getText().equals("Enter a Platform")) {
						textField_3.setText("Enter a Platform");
					}
					else if(textField_4.getText().isEmpty() || textField_4.getText().equals("Enter a Version")) {
						textField_4.setText("Enter a Version");
					}
					else if(textField_5.getText().isEmpty() || textField_5.getText().equals("Enter a Link")) {
						textField_5.setText("Enter a Link");
					}
					else if(textField_6.getText().isEmpty() || textField_6.getText().equals("Enter a Price")) {
						textField_6.setText("Enter a Price");
					}
					else {
						s.reqList.add(new Application(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(),
								textField_4.getText(), textField_5.getText(), Double.parseDouble(textField_6.getText())));
						
						window.frame.setVisible(true);
						window.frameLog.setVisible(false);
						window.frameRequest.setVisible(false);
						window.frameRequest.dispose();
						frameRequest = new JFrame();
						frameRequest.getContentPane().setBackground(Color.WHITE);
						frameRequest.setBounds(100, 100, 700, 500);
						frameRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameRequest.getContentPane().setLayout(null);
						window.frameSortZA.setVisible(false);
						window.frameSortAZ.setVisible(false);
						window.frameFilter.setVisible(false);
						window.frameSearch.setVisible(false);
						window.frameComment.setVisible(false);
					}
				}
			});
			btnNewButton_8.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			btnNewButton_8.setBounds(272, 358, 117, 29);
			frameRequest.getContentPane().add(btnNewButton_8);
			
			
		}
		JButton btnNewButton_7 = new JButton("Back");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(true);
				window.frameLog.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameRequest.dispose();
				frameRequest = new JFrame();
				frameRequest.getContentPane().setBackground(Color.WHITE);
				frameRequest.setBounds(100, 100, 700, 500);
				frameRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameRequest.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
				//initialize(s, arrList);
				
			}
		});
		btnNewButton_7.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_7.setBounds(548, 16, 117, 29);
		frameRequest.getContentPane().add(btnNewButton_7);
		
		

		
		JPanel panel = new JPanel();
		panel.setBounds(6, 80, 688, 370);
		frameRequest.getContentPane().add(panel);
		
		
	}
	
	@SuppressWarnings("serial")
	public void comment(Store s,ArrayList<Application> arrList, int x) {
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameComment.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(x).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(39, 92, 243, 16);
		frameComment.getContentPane().add(lblNewLabel_1);
		
		JTree tree = new JTree();
		tree.setFont(new Font("Apple Braille", Font.PLAIN, 13));

		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Comments") {
				{
					for(int i = 0; i < s.appList.get(x).getCommentList().getSize(); i++) {
						add(new DefaultMutableTreeNode(s.appList.get(x).getCommentList().getAt(i)));
					}
					
				}
			}
		));
		
		tree.setBounds(49, 120, 625, 201);
		frameComment.getContentPane().add(tree);
		
		JButton btnNewButton_7 = new JButton("Home");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(true);
				window.frameLog.setVisible(false);
				window.frameComment.setVisible(false);
				window.frameComment.dispose();
				frameComment = new JFrame();
				frameComment.getContentPane().setBackground(Color.WHITE);
				frameComment.setBounds(100, 100, 700, 500);
				frameComment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameComment.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameComment.setVisible(false);
				//initialize(s, arrList);
				
			}
		});
		btnNewButton_7.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_7.setBounds(548, 16, 117, 29);
		frameComment.getContentPane().add(btnNewButton_7);
		
		
		
		
		if(u.ID != 0) {
		
			textEnterComment = new JTextField();
			textEnterComment.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			textEnterComment.setBounds(49, 385, 315, 26);
			frameComment.getContentPane().add(textEnterComment);
			textEnterComment.setColumns(10);
			
			JButton btnNewButton_3 = new JButton("Add Comment");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textEnterComment.getText().isEmpty()) {
						textEnterComment.setText("Enter Comment Here");
					}
					else {
						s.appList.get(x).getCommentList().insertLast((s.appList.get(x).getCommentList().getSize()) 
								+ ": " + textEnterComment.getText());
						window.frameComment.dispose();
						frameComment = new JFrame();
						frameComment.getContentPane().setBackground(Color.WHITE);
						frameComment.setBounds(100, 100, 700, 500);
						frameComment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameComment.getContentPane().setLayout(null);
						comment(s,arrList,x);
	
					}
				}
			});
			
			
			btnNewButton_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			btnNewButton_3.setBounds(387, 385, 117, 29);
			frameComment.getContentPane().add(btnNewButton_3);
			
		}
			
		if(u.ID > 1) {
			
			textCommentNumber = new JTextField();
			textCommentNumber.setBounds(453, 441, 59, 26);
			frameComment.getContentPane().add(textCommentNumber);
			textCommentNumber.setColumns(10);
			
			JButton btnNewButton_7_1 = new JButton("Remove Comment");
			btnNewButton_7_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textCommentNumber.getText().isEmpty()) {
						textCommentNumber.setText("Enter Comment Number");
					}
					else {
						s.appList.get(x).getCommentList().remove(Integer.valueOf(textCommentNumber.getText())-1);
						window.frameComment.dispose();
						frameComment = new JFrame();
						frameComment.getContentPane().setBackground(Color.WHITE);
						frameComment.setBounds(100, 100, 700, 500);
						frameComment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frameComment.getContentPane().setLayout(null);				
						comment(s,arrList,x);
					}
				}
			});
			btnNewButton_7_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			btnNewButton_7_1.setBounds(528, 443, 137, 29);
			frameComment.getContentPane().add(btnNewButton_7_1);
			
		}
			
		
		
	}
	public void search(Store s, String name) {
		int x = s.searchGetI(name);
		ArrayList<Application> arrList = s.temp;
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(true);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameSearch.getContentPane().add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel(s.appList.get(x).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 90, 85, 16);
		frameSearch.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel(s.appList.get(x).getDescription());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(110, 118, 395, 16);
		frameSearch.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, x);
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(485, 113, 117, 29);
		frameSearch.getContentPane().add(btnNewButton);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(35, 78, 580, 70);
		frameSearch.getContentPane().add(panel);
		

		JRadioButton rdbtnNewRadioButton = new JRadioButton("A to Z");
		rdbtnNewRadioButton.setBounds(184, 360, 97, 23);
		frameSearch.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Z to A");
		rdbtnNewRadioButton_1.setBounds(289, 360, 85, 23);
		frameSearch.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup sortSelect = new ButtonGroup();
		sortSelect.add(rdbtnNewRadioButton);
		sortSelect.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					sortSelect.clearSelection();
					sortAZ(s,arrList);
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					sortSelect.clearSelection();
					sortZA(s,arrList);
				}
			}
		});
		btnNewButton_5.setBounds(388, 359, 117, 29);
		frameSearch.getContentPane().add(btnNewButton_5);
		
		
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price (i.e. 0.00)");
		txtEnterPrice.setBounds(184, 410, 141, 26);
		frameSearch.getContentPane().add(txtEnterPrice);
		txtEnterPrice.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Filter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(txtEnterPrice.getText());
				filter(s, price);
			}
		});
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameSearch.getContentPane().add(btnNewButton_6);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(346, 16, 141, 26);
		frame.getContentPane().add(txtEnterName);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = (txtEnterName.getText());
				if(s.search(searchWord))
					search(s, searchWord);
				else
					txtEnterName.setText("No Results");
			}
		});
		btnNewButton_7.setBounds(485, 16, 117, 29);
		frame.getContentPane().add(btnNewButton_7);
		
		if(u.ID == 3) {
			JButton btnNewButton_8 = new JButton("Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,true);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frame.getContentPane().add(btnNewButton_8);
		}
			
		else {
			JButton btnNewButton_8 = new JButton("Make Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,false);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frame.getContentPane().add(btnNewButton_8);
			
			
		}
		
		JButton btnNewButton_9 = new JButton("LogOut");
		btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = new User();
				window.frame.setVisible(false);
				window.frameLog.setVisible(true);
				window.frameView.setVisible(false);
				window.frame.dispose();
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 700, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
			}
		});
		btnNewButton_9.setBounds(35, 410, 137, 29);
		frame.getContentPane().add(btnNewButton_9);
		
		
		
	}
	public void filter(Store s, double price) {
		s.filter(price);
		ArrayList<Application> arrList = s.temp;
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(true);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);
		
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameFilter.getContentPane().add(lblNewLabel);
		
		if(arrList.size() >= 3) {
			
			JLabel lblNewLabel_3 = new JLabel(s.appList.get(2).getName());
			lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(60, 270, 85, 16);
			frameFilter.getContentPane().add(lblNewLabel_3);

			
			JLabel lblNewLabel_6 = new JLabel(s.appList.get(2).getDescription());
			lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_6.setBounds(110, 298, 395, 16);
			frameFilter.getContentPane().add(lblNewLabel_6);
			

			JButton btnNewButton_2 = new JButton("View");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view(s,arrList, 2);
				}
			});
			btnNewButton_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			btnNewButton_2.setBounds(485, 293, 117, 29);
			frameFilter.getContentPane().add(btnNewButton_2);
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(35, 252, 580, 70);
			frameFilter.getContentPane().add(panel_2);
		}
		if(arrList.size() >= 2) {
			JLabel lblNewLabel_2 = new JLabel(s.appList.get(1).getName());
			lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(60, 180, 85, 16);
			frameFilter.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_5 = new JLabel(s.appList.get(1).getDescription());
			lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(110, 208, 395, 16);
			frameFilter.getContentPane().add(lblNewLabel_5);
			

			JButton btnNewButton_1 = new JButton("View");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view(s,arrList, 1);
				}
			});
			btnNewButton_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			btnNewButton_1.setBounds(485, 203, 117, 29);
			frameFilter.getContentPane().add(btnNewButton_1);
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(35, 162, 580, 70);
			frameFilter.getContentPane().add(panel_1);
			
		}
		if (arrList.size() >= 1) {
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(0).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 90, 85, 16);
		frameFilter.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel(s.appList.get(0).getDescription());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(110, 118, 395, 16);
		frameFilter.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 0);
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(485, 113, 117, 29);
		frameFilter.getContentPane().add(btnNewButton);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(35, 78, 580, 70);
		frameFilter.getContentPane().add(panel);
		
		
		}
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A to Z");
		rdbtnNewRadioButton.setBounds(184, 360, 97, 23);
		frameFilter.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Z to A");
		rdbtnNewRadioButton_1.setBounds(289, 360, 85, 23);
		frameFilter.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup sortSelect = new ButtonGroup();
		sortSelect.add(rdbtnNewRadioButton);
		sortSelect.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					sortSelect.clearSelection();
					sortAZ(s,arrList);
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					sortSelect.clearSelection();
					sortZA(s,arrList);
				}
			}
		});
		btnNewButton_5.setBounds(388, 359, 117, 29);
		frameFilter.getContentPane().add(btnNewButton_5);
		
		
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price (i.e. 0.00)");
		txtEnterPrice.setBounds(184, 410, 141, 26);
		frameFilter.getContentPane().add(txtEnterPrice);
		txtEnterPrice.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Filter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(txtEnterPrice.getText());
				filter(s, price);
			}
		});
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameFilter.getContentPane().add(btnNewButton_6);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(346, 16, 141, 26);
		frameFilter.getContentPane().add(txtEnterName);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = (txtEnterName.getText());
				if(s.search(searchWord))
					search(s, searchWord);
				else
					txtEnterName.setText("No Results");
			}
		});
		btnNewButton_7.setBounds(485, 16, 117, 29);
		frameFilter.getContentPane().add(btnNewButton_7);
		
		if(u.ID == 3) {
			JButton btnNewButton_8 = new JButton("Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,true);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameFilter.getContentPane().add(btnNewButton_8);
		}
			
		else {
			JButton btnNewButton_8 = new JButton("Make Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,false);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameFilter.getContentPane().add(btnNewButton_8);
			
			
		}
		
		JButton btnNewButton_9 = new JButton("LogOut");
		btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = new User();
				window.frame.setVisible(false);
				window.frameLog.setVisible(true);
				window.frameView.setVisible(false);
				window.frame.dispose();
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 700, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
			}
		});
		btnNewButton_9.setBounds(35, 410, 137, 29);
		frameFilter.getContentPane().add(btnNewButton_9);
		
	}
	public void sortAZ(Store s,ArrayList<Application> arrList) {
		s.sort(0);
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(true);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);
		

		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameSortAZ.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(0).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 90, 85, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(s.appList.get(1).getName());
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(60, 180, 85, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(s.appList.get(2).getName());
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(60, 270, 85, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(s.appList.get(0).getDescription());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(110, 118, 395, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(s.appList.get(1).getDescription());
		lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(110, 208, 395, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(s.appList.get(2).getDescription());
		lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(110, 298, 395, 16);
		frameSortAZ.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 0);
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(485, 113, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 1);
			}
		});
		btnNewButton_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_1.setBounds(485, 203, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 2);
			}
		});
		btnNewButton_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_2.setBounds(485, 293, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(35, 78, 580, 70);
		frameSortAZ.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 162, 580, 70);
		frameSortAZ.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(35, 252, 580, 70);
		frameSortAZ.getContentPane().add(panel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A to Z");
		rdbtnNewRadioButton.setBounds(184, 360, 97, 23);
		frameSortAZ.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Z to A");
		rdbtnNewRadioButton_1.setBounds(289, 360, 85, 23);
		frameSortAZ.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup sortSelect = new ButtonGroup();
		sortSelect.add(rdbtnNewRadioButton);
		sortSelect.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					sortSelect.clearSelection();
					sortAZ(s,arrList);
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					sortSelect.clearSelection();
					sortZA(s,arrList);
				}
			}
		});
		btnNewButton_5.setBounds(388, 359, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_5);
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price (i.e. 0.00)");
		txtEnterPrice.setBounds(184, 410, 141, 26);
		frameSortAZ.getContentPane().add(txtEnterPrice);
		txtEnterPrice.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Filter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(txtEnterPrice.getText());
				filter(s, price);
			}
		});
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_6);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(346, 16, 141, 26);
		frameSortAZ.getContentPane().add(txtEnterName);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = (txtEnterName.getText());
				if(s.search(searchWord))
					search(s, searchWord);
				else
					txtEnterName.setText("No Results");
			}
		});
		btnNewButton_7.setBounds(485, 16, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_7);
		
		if(u.ID == 3) {
			JButton btnNewButton_8 = new JButton("Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,true);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameSortAZ.getContentPane().add(btnNewButton_8);
		}
			
		else {
			JButton btnNewButton_8 = new JButton("Make Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,false);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameSortAZ.getContentPane().add(btnNewButton_8);
			
			
		}
		
		JButton btnNewButton_9 = new JButton("LogOut");
		btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = new User();
				window.frame.setVisible(false);
				window.frameLog.setVisible(true);
				window.frameView.setVisible(false);
				window.frame.dispose();
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 700, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
			}
		});
		btnNewButton_9.setBounds(35, 410, 137, 29);
		frameSortAZ.getContentPane().add(btnNewButton_9);
		
		
	}
	public void sortZA(Store s,ArrayList<Application> arrList) {
		s.sort(1);
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(true);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);
		

		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameSortZA.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(0).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 90, 85, 16);
		frameSortZA.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(s.appList.get(1).getName());
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(60, 180, 85, 16);
		frameSortZA.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(s.appList.get(2).getName());
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(60, 270, 85, 16);
		frameSortZA.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(s.appList.get(0).getDescription());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(110, 118, 395, 16);
		frameSortZA.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(s.appList.get(1).getDescription());
		lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(110, 208, 395, 16);
		frameSortZA.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(s.appList.get(2).getDescription());
		lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(110, 298, 395, 16);
		frameSortZA.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 0);
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(485, 113, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 1);
			}
		});
		btnNewButton_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_1.setBounds(485, 203, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 2);
			}
		});
		btnNewButton_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_2.setBounds(485, 293, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(35, 78, 580, 70);
		frameSortZA.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 162, 580, 70);
		frameSortZA.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(35, 252, 580, 70);
		frameSortZA.getContentPane().add(panel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A to Z");
		rdbtnNewRadioButton.setBounds(184, 360, 97, 23);
		frameSortZA.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Z to A");
		rdbtnNewRadioButton_1.setBounds(289, 360, 85, 23);
		frameSortZA.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup sortSelect = new ButtonGroup();
		sortSelect.add(rdbtnNewRadioButton);
		sortSelect.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					sortSelect.clearSelection();
					sortAZ(s,arrList);
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					sortSelect.clearSelection();
					sortZA(s,arrList);
				}
			}
		});
		btnNewButton_5.setBounds(388, 359, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_5);
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price (i.e. 0.00)");
		txtEnterPrice.setBounds(184, 410, 141, 26);
		frameSortZA.getContentPane().add(txtEnterPrice);
		txtEnterPrice.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Filter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(txtEnterPrice.getText());
				filter(s, price);
			}
		});
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_6);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(346, 16, 141, 26);
		frameSortZA.getContentPane().add(txtEnterName);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = (txtEnterName.getText());
				if(s.search(searchWord))
					search(s, searchWord);
				else
					txtEnterName.setText("No Results");
			}
		});
		btnNewButton_7.setBounds(485, 16, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_7);
		
		if(u.ID == 3) {
			JButton btnNewButton_8 = new JButton("Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,true);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameSortZA.getContentPane().add(btnNewButton_8);
		}
			
		else {
			JButton btnNewButton_8 = new JButton("Make Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,false);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frameSortZA.getContentPane().add(btnNewButton_8);
			
			
		}
		
		JButton btnNewButton_9 = new JButton("LogOut");
		btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = new User();
				window.frame.setVisible(false);
				window.frameLog.setVisible(true);
				window.frameView.setVisible(false);
				window.frame.dispose();
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 700, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
			}
		});
		btnNewButton_9.setBounds(35, 410, 137, 29);
		frameSortZA.getContentPane().add(btnNewButton_9);
		
	
	}
	public void view(Store s,ArrayList<Application> arrList, int x) {
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(true);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);

		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameView.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(x).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(39, 92, 243, 16);
		frameView.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(s.appList.get(x).getDescription());
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(63, 135, 274, 16);
		frameView.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(s.appList.get(x).getLink());
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(63, 191, 266, 16);
		frameView.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Developed by " + s.appList.get(x).getOrganization());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(63, 248, 266, 16);
		frameView.getContentPane().add(lblNewLabel_4);
	
		JLabel lblNewLabel_5 = new JLabel("For " + s.appList.get(x).getPlatform());
		lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(63, 363, 266, 16);
		frameView.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Version: " + s.appList.get(x).getVersion());
		lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(63, 309, 266, 16);
		frameView.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("$ " + String.valueOf(s.appList.get(x).getPrice()));
		lblNewLabel_7.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(63, 417, 266, 16);
		frameView.getContentPane().add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 80, 688, 370);
		frameView.getContentPane().add(panel);
		
		JButton btnNewButton_7 = new JButton("Back");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(true);
				window.frameLog.setVisible(false);
				window.frameView.setVisible(false);
				window.frameView.dispose();
				frameView = new JFrame();
				frameView.getContentPane().setBackground(Color.WHITE);
				frameView.setBounds(100, 100, 700, 500);
				frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameView.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
				
				home(s,arrList);
				//initialize(s, arrList);
				
			}
		});
		btnNewButton_7.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_7.setBounds(548, 16, 117, 29);
		frameView.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Comments");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comment(s,arrList,x);
			}
		});
		btnNewButton_8.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_8.setBounds(397, 16, 117, 29);
		frameView.getContentPane().add(btnNewButton_8);

	}
	public void login(Store s,ArrayList<Application> arrList){
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frameLog.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Create an Account, Login, Or Continue as Guest");
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(153, 65, 490, 16);
		frameLog.getContentPane().add(lblNewLabel_1);
		
		textUsername = new JTextField();
		textUsername.setBounds(389, 109, 130, 26);
		frameLog.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(389, 155, 130, 26);
		frameLog.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(229, 116, 72, 16);
		frameLog.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(229, 162, 72, 16);
		frameLog.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUsername.getText();
				String password = textPassword.getText();
				String temp = username + "?" + password; 
				if(s.userMap.containsKey(temp)) {
					u = s.userMap.get(temp);
					home(s,arrList);
				}
				else {
					textUsername.setText("Invaild");
					textPassword.setText("Invaild");
				}
					
					
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(326, 246, 117, 29);
		frameLog.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continue as Guest");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.setID(0);
				home(s,arrList);
			}
		});
		btnNewButton_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_1.setBounds(502, 246, 180, 29);
		frameLog.getContentPane().add(btnNewButton_1);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("User");
		rdbtnNewRadioButton.setBounds(131, 288, 141, 23);
		frameLog.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Moderator");
		rdbtnNewRadioButton_1.setBounds(131, 334, 141, 23);
		frameLog.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Admin");
		rdbtnNewRadioButton_2.setBounds(131, 377, 141, 23);
		frameLog.getContentPane().add(rdbtnNewRadioButton_2);
		
		ButtonGroup userSelect = new ButtonGroup();
		userSelect.add(rdbtnNewRadioButton);
		userSelect.add(rdbtnNewRadioButton_1);
		userSelect.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton.setSelected(true);

		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp =  textUsername.getText()+ "?" + textPassword.getText();
				if(!s.userMap.containsKey(temp)){
					if(rdbtnNewRadioButton.isSelected()) {
						userSelect.clearSelection();
						u = new User(textUsername.getText(), textPassword.getText(), 1);
						temp = u.username + "?" + u.password; 
						s.userMap.put(temp, u);
						home(s,arrList);
					}
					else if(rdbtnNewRadioButton_1.isSelected()) {
						userSelect.clearSelection();
						u = new User(textUsername.getText(), textPassword.getText(), 2);
						temp = u.username + "?" + u.password; 
						s.userMap.put(temp, u);
						home(s,arrList);
					}
					else if(rdbtnNewRadioButton_2.isSelected()) {
						userSelect.clearSelection();
						u = new User(textUsername.getText(), textPassword.getText(), 3);
						temp = u.username + "?" + u.password; 
						s.userMap.put(temp, u);
						home(s,arrList);
					}
				}
				else {
					textUsername.setText("Invaild");
					textPassword.setText("Invaild");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_2.setBounds(131, 246, 141, 29);
		frameLog.getContentPane().add(btnNewButton_2);
		
	}
	public void home(Store s,ArrayList<Application> arrList) {
		
		window.frame.setVisible(true);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		window.frameFilter.setVisible(false);
		window.frameSearch.setVisible(false);
		window.frameRequest.setVisible(false);
		window.frameComment.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(s.appList.get(0).getName());
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 90, 85, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(s.appList.get(1).getName());
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(60, 180, 85, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(s.appList.get(2).getName());
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(60, 270, 85, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(s.appList.get(0).getDescription());
		lblNewLabel_4.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(110, 118, 395, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(s.appList.get(1).getDescription());
		lblNewLabel_5.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(110, 208, 395, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(s.appList.get(2).getDescription());
		lblNewLabel_6.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(110, 298, 395, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 0);
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(485, 113, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 1);
			}
		});
		btnNewButton_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_1.setBounds(485, 203, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view(s,arrList, 2);
			}
		});
		btnNewButton_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_2.setBounds(485, 293, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(35, 78, 580, 70);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 162, 580, 70);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(35, 252, 580, 70);
		frame.getContentPane().add(panel_2);
		

		JRadioButton rdbtnNewRadioButton = new JRadioButton("A to Z");
		rdbtnNewRadioButton.setBounds(184, 360, 97, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Z to A");
		rdbtnNewRadioButton_1.setBounds(289, 360, 85, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup sortSelect = new ButtonGroup();
		sortSelect.add(rdbtnNewRadioButton);
		sortSelect.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_5 = new JButton("Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					sortSelect.clearSelection();
					sortAZ(s,arrList);
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					sortSelect.clearSelection();
					sortZA(s,arrList);
				}
			}
		});
		btnNewButton_5.setBounds(388, 359, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		
		
		txtEnterPrice = new JTextField();
		txtEnterPrice.setText("Enter Price (i.e. 0.00)");
		txtEnterPrice.setBounds(184, 410, 141, 26);
		frame.getContentPane().add(txtEnterPrice);
		txtEnterPrice.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Filter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(txtEnterPrice.getText());
				filter(s, price);
			}
		});
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(346, 16, 141, 26);
		frame.getContentPane().add(txtEnterName);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = (txtEnterName.getText());
				if(s.search(searchWord))
					search(s, searchWord);
				else
					txtEnterName.setText("No Results");
			}
		});
		btnNewButton_7.setBounds(485, 16, 117, 29);
		frame.getContentPane().add(btnNewButton_7);
		
		
		if(u.ID == 3) {
			JButton btnNewButton_8 = new JButton("Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,true);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frame.getContentPane().add(btnNewButton_8);
		}
			
		else {
			JButton btnNewButton_8 = new JButton("Make Requests");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requests(s,false);
				}
			});
			btnNewButton_8.setBounds(35, 359, 137, 29);
			frame.getContentPane().add(btnNewButton_8);
			
			
		}
		
		JButton btnNewButton_9 = new JButton("LogOut");
		btnNewButton_9.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = new User();
				window.frame.setVisible(false);
				window.frameLog.setVisible(true);
				window.frameView.setVisible(false);
				window.frame.dispose();
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 700, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				window.frameFilter.setVisible(false);
				window.frameRequest.setVisible(false);
				window.frameSearch.setVisible(false);
				window.frameComment.setVisible(false);
			}
		});
		btnNewButton_9.setBounds(35, 410, 137, 29);
		frame.getContentPane().add(btnNewButton_9);
	}
}