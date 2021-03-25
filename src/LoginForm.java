import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm {

	private JFrame frame;
	private JLabel lblNewLabel_close;
	private JLabel lblNewLabel_Mim;
	private JPanel panel_3;
	private JTextField username;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JComboBox utype;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection  connection = null;
	private JLabel lbl_create;
	
	
	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		frame.setLocationRelativeTo(null);
		connection = ConnectionClass.dbConnector();
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		utype.setBorder(lblNewLabel_border);
		
		
		Border lblNewLabelCreate_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray);
		lbl_create.setBorder(lblNewLabelCreate_border);
		
		
		
		Border fields_border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.white);
		username.setBorder(fields_border);
		passwordField.setBorder(fields_border);
		
		Border label_icons_border = BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(153,153,153));
		lblNewLabel.setBorder(label_icons_border);
		lblNewLabel_1.setBorder(label_icons_border);
		lblNewLabel_1_1.setBorder(label_icons_border);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 435, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 434, 344);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 11, 414, 322);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 57, 414, 276);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		 ImageIcon nn = new ImageIcon("img/username1.png");
		 lblNewLabel.setIcon(nn);
	
		lblNewLabel.setBounds(10, 25, 48, 40);
		panel_2.add(lblNewLabel);
		
		username = new JTextField();
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (username.getText().toLowerCase().equals("username")) {
					username.setText("");
					username.setForeground(Color.black);
				}
				Border label_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
				lblNewLabel.setBorder(label_icon);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (username.getText().trim().equals("") || username.getText().toLowerCase().trim().equals("username")) {
					username.setText("username");
					username.setForeground(new Color(153,153,153));
				}   
				Border label_icons_border = BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(153,153,153));
				lblNewLabel.setBorder(label_icons_border);
			}
		});
		username.setColumns(10);
		username.setBackground(Color.WHITE);
		username.setBounds(62, 25, 326, 40);
		panel_2.add(username);
		
	    lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
	    ImageIcon ggg = new ImageIcon("img/password1.png");
		lblNewLabel_1.setIcon(ggg);
		lblNewLabel_1.setBounds(10, 76, 48, 40);
		panel_2.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String pass = String.valueOf(passwordField.getPassword());
				if (pass.toLowerCase().equals("password")) {
					passwordField.setText("");
					passwordField.setForeground(Color.black);
				}
				Border label_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
				lblNewLabel_1.setBorder(label_icon);
			}
			@Override
			public void focusLost(FocusEvent e) {
				 String pass = String.valueOf(passwordField.getPassword());
					
					if (pass.trim().equals("") || pass.toLowerCase().trim().equals("username")) {
						passwordField.setText("password");
						passwordField.setForeground(new Color(153,153,153));
					}
					Border label_icons_border = BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(153,153,153));
					lblNewLabel_1.setBorder(label_icons_border);
				
			}
		});
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(62, 76, 326, 40);
		panel_2.add(passwordField);
		
		lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBackground(Color.WHITE);
		 ImageIcon dd = new ImageIcon("img/username2.png");
		 lblNewLabel_1_1.setIcon(dd);
		lblNewLabel_1_1.setBounds(10, 124, 48, 53);
		panel_2.add(lblNewLabel_1_1);
		
	   utype = new JComboBox();
	   utype.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Teacher"}));
	   utype.addFocusListener(new FocusAdapter() {
	   	@Override
	   	public void focusGained(FocusEvent e) {Border label_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
	   	lblNewLabel_1_1.setBorder(label_icon);
	   		
	   	}
	   	@Override
	   	public void focusLost(FocusEvent e) {
	   		Border label_icons_border = BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(153,153,153));
	   		lblNewLabel_1_1.setBorder(label_icons_border);
	   	}
	   });
		utype.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		utype.setBounds(62, 127, 117, 50);
		panel_2.add(utype);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		chckbxNewCheckBox.setBounds(268, 123, 129, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String txtusername = username.getText();
					String pass = passwordField.getText();
					String txtutype = utype.getSelectedItem().toString();
					
						String query = "Select * from userTable where username = ? and password = ?  and UserType = ?";
						PreparedStatement ps = connection.prepareStatement(query);
						ps.setString(1, txtusername);
						ps.setString(2, pass);
						ps.setString(3, txtutype);
		
						ResultSet rs = ps.executeQuery();
				
						if (rs.next()) {
						
					    int id = rs.getInt("id");
					   
					    if (txtutype.equals("Admin")) {
					    	
					    	
					    	
					    	MainClass main = new MainClass(id, txtusername, txtutype);
					    	main.setVisible(true);
					    	
					    	main.setLocationRelativeTo(null);
					    	main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.dispose();
					    	
						   
					    }else {
					    	
					    	
					    	TeacherMain bb = new TeacherMain(id, txtusername, txtutype);
					    	bb.setVisible(true);
					    	bb.setLocationRelativeTo(null);
					    	bb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.dispose();
					  
					   
					    }
					    
					
					
				    }
						else {
							JOptionPane.showMessageDialog(frame, "Invalid Username, password and UserType", "Login Error",3);
							
							
						}
						rs.close();
						ps.close();
						  }catch(Exception e1) {
							  JOptionPane.showMessageDialog(null, e1);
							  
						  }

				
				
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground( new Color(0, 84, 104));}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setBounds(62, 188, 326, 40);
		panel_2.add(btnLogin);
		
		lbl_create = new JLabel(">>>No Account? Create One!");
		lbl_create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border lblNewLabel_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
				lbl_create.setBorder(lblNewLabel_border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border lblNewLabelCreate_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray);
				lbl_create.setBorder(lblNewLabelCreate_border);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UserCreation user = new UserCreation();
				user.setVisible(true);
				user.setLocationRelativeTo(null);
				user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		lbl_create.setForeground(Color.RED);
		lbl_create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_create.setBounds(116, 239, 191, 14);
		panel_2.add(lbl_create);
		
		lblNewLabel_close = new JLabel(" x");
		lblNewLabel_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblNewLabel_close.setBorder(lblNewLabel_border);
				lblNewLabel_close.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblNewLabel_close.setBorder(lblNewLabel_border);
				lblNewLabel_close.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_close.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_close.setBounds(378, 11, 22, 21);
		panel_1.add(lblNewLabel_close);
		
		lblNewLabel_Mim = new JLabel(" -");
		lblNewLabel_Mim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblNewLabel_Mim.setBorder(lblNewLabel_border);
				lblNewLabel_Mim.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblNewLabel_Mim.setBorder(lblNewLabel_border);
				lblNewLabel_Mim.setForeground(Color.black);
			}
		});
		lblNewLabel_Mim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_Mim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_Mim.setBounds(346, 11, 22, 21);
		panel_1.add(lblNewLabel_Mim);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(142, 0, 131, 44);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(26, 11, 83, 32);
		panel_3.add(lblNewLabel_2);
	}
}
