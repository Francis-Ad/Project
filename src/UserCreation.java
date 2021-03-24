import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class UserCreation extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_close;
	private JLabel lblNewLabel_Mim;
	private JPanel panel_3;
	private JPanel panel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCreation frame = new UserCreation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection  connection = null;
	
	
	
	public boolean verifyField() {
		
		String fname = textField_1.getText();
		String contact = textField_2.getText();
		String address = textField_3.getText();
		String uname = textField_4.getText();
		String pass1 = String.valueOf(passwordField.getPassword());
		String pass2 = String.valueOf(passwordField_1.getPassword());
		 String txtutype = comboBox.getSelectedItem().toString(); 
		
		if (fname.trim().equals("") || contact.trim().equals("") || address.trim().equals("") || uname.trim().equals("")
				|| pass1.trim().equals("") || pass2.trim().equals("") || txtutype.trim().equals("") ) {
		
			JOptionPane.showMessageDialog(null, " One or More fields Are Empty", "Empty Field", 2);
			return false;
			
	  }else if (!pass1.equals(pass2) ){
			JOptionPane.showMessageDialog(null, " Password Doesn't Match", "Confirm Password", 2);
			return false;
			
		}else {
			return true;
		}
		
	}
	
	public boolean checkUsername(String Username) {
		
		boolean username_exixt = false;
		try {
            String query = "select * from UserTable where Username = ? ";
					PreparedStatement ps = connection.prepareStatement(query);
					
				    ps.setString(1, Username);
				   ResultSet rs =  ps.executeQuery();
				   
				   if (rs.next()) {
					   username_exixt = true;
					   JOptionPane.showMessageDialog(null, " This Username Is Already Taken, Choose Another One", "Username Failed", 2);
				   }
		
			        rs.close();
					ps.close();
			} catch (Exception e1) {
					e1.printStackTrace();
				}
		return username_exixt;
	}

	/**
	 * Create the frame.
	 */
	public UserCreation() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		
	
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 566, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 566, 438);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(80, 11, 398, 347);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setColumns(10);
		textField_1.setBounds(115, 11, 231, 26);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(59, 17, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(48, 66, 57, 14);
		panel_2.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(115, 60, 231, 26);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_3.setColumns(10);
		textField_3.setBounds(115, 109, 231, 26);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(48, 115, 54, 14);
		panel_2.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_4.setColumns(10);
		textField_4.setBounds(115, 162, 231, 26);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(38, 168, 67, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(38, 215, 67, 14);
		panel_2.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		passwordField.setBounds(116, 209, 230, 26);
		panel_2.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		passwordField_1.setBounds(116, 256, 230, 26);
		panel_2.add(passwordField_1);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Pass");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(20, 262, 86, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Usertype");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(59, 315, 60, 14);
		panel_2.add(lblNewLabel_7);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Teacher"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(130, 307, 152, 29);
		panel_2.add(comboBox);
		
		JButton btnSave = new JButton("Register");
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
 String pass1 = String.valueOf(passwordField.getPassword());
		       
			
				 
				 if (verifyField()) {
					
					if (!checkUsername( textField_4.getText())) {
						try {
			                   String query = "insert into UserTable (Name, Contact, Address, Username, Password, Usertype) values (?,?,?,?,?,?)";
									PreparedStatement ps = connection.prepareStatement(query);
									
								    ps.setString(1, textField_1.getText());
								    ps.setString(2, textField_2.getText());
								    ps.setString(3, textField_3.getText());
								    ps.setString(4, textField_4.getText());
								    
								   
									 ps.setString(5, pass1);
					                 ps.setString(6, comboBox.getSelectedItem().toString());
								    
									ps.execute();
									
							        JOptionPane.showMessageDialog(null, " Account Created");
							        
							        
									ps.close();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
					}
						
					}
				
				}
				
				
				
			
		});
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSave.setBackground( new Color(0, 84, 104));
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.setBackground(new Color(0, 0, 128));
		btnSave.setBounds(90, 369, 398, 46);
		panel_1.add(btnSave);
		
	    panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(152, 0, 268, 36);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Login Resgister");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(49, 0, 188, 30);
		panel_3.add(lblNewLabel_2);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_Mim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_Mim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_Mim.setBounds(502, 15, 22, 21);
		panel.add(lblNewLabel_Mim);
		
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
		lblNewLabel_close.setBounds(534, 15, 22, 21);
		panel.add(lblNewLabel_close);
	}
}
