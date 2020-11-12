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

public class PearWindow {

	private JFrame frame;
	private JFrame frameView;
	private JFrame frameSortZA;
	private JFrame frameLog;
	private JFrame frameSortAZ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEnterPrice;
	private JTextField textField_2;
	private static PearWindow window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Store pear = new Store();
		
		pear.appList.add(new Application("Twitter", "A social media app for messages" , "twitter.co", "iphone", "2.0", "twittee.com", 0.99));
		pear.appList.add(new Application("Reddit", "A formum site" , "reddit", "windows", "1.6", "reddit.com", 1.95));
		pear.appList.add(new Application("Instagram", "A social media app for photos" , "facebook", "iphone", "1.0", "instagram.com", 2.99)); 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PearWindow(pear, pear.appList);
					window.frame.setVisible(true);
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
		
		home(s,arrList);
		//login();
		//view(s,arrList,0);
		//filter();
		
		
	}
	public void filter() {
		
	}
	public void sortAZ(Store s,ArrayList<Application> arrList) {
		s.sort(0);
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(true);
		

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
		
		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_3.setBounds(485, 18, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("Create Account");
		btnNewButton_4.setBounds(343, 16, 130, 29);
		frameSortAZ.getContentPane().add(btnNewButton_4);
		

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
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameSortAZ.getContentPane().add(btnNewButton_6);
		
		
	}
	
	public void sortZA(Store s,ArrayList<Application> arrList) {
		s.sort(1);
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(false);
		window.frameSortZA.setVisible(true);
		window.frameSortAZ.setVisible(false);
		

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
		
		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_3.setBounds(485, 18, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("Create Account");
		btnNewButton_4.setBounds(343, 16, 130, 29);
		frameSortZA.getContentPane().add(btnNewButton_4);
		

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
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frameSortZA.getContentPane().add(btnNewButton_6);
		
	
	}

	public void view(Store s,ArrayList<Application> arrList, int x) {
		window.frame.setVisible(false);
		window.frameLog.setVisible(false);
		window.frameView.setVisible(true);
		window.frameSortZA.setVisible(false);
		window.frameSortAZ.setVisible(false);
		
		
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
				window.frameSortZA.setVisible(false);
				window.frameSortAZ.setVisible(false);
				initialize(s, arrList);
			}
		});
		btnNewButton_7.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_7.setBounds(548, 16, 117, 29);
		frameView.getContentPane().add(btnNewButton_7);

	}
	
	public void createAcc() {

		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create Account");
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(288, 65, 130, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(372, 109, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(372, 155, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(212, 116, 72, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(212, 162, 72, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Create account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = lblNewLabel_2.getText();
				String password = lblNewLabel_3.getText();
				
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(276, 289, 152, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("E-mail");
		lblNewLabel_3_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(212, 214, 72, 16);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(372, 207, 130, 26);
		frame.getContentPane().add(textField_2);

	}

	public void login(){
		
		JLabel lblNewLabel = new JLabel("Pear Store");
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 21));
		//lblNewLabel.setFont(new Font());
		lblNewLabel.setBounds(6, 6, 186, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(322, 65, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(389, 109, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(389, 155, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(229, 116, 72, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(229, 162, 72, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = lblNewLabel_2.getText();
				String password = lblNewLabel_3.getText();
				
			}
		});
		btnNewButton.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton.setBounds(283, 236, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void home(Store s,ArrayList<Application> arrList) {
		
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
		
		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.setFont(new Font("Apple Braille", Font.PLAIN, 13));
		btnNewButton_3.setBounds(485, 18, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("Create Account");
		btnNewButton_4.setBounds(343, 16, 130, 29);
		frame.getContentPane().add(btnNewButton_4);
		

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
		btnNewButton_6.setBounds(388, 410, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
	}
}
