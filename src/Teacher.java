import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Teacher extends JFrame {

	private JPanel contentPane;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_Mim;
	private JLabel lblNewLabel_close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JTextField textField;
	private JTextField txt_Name;
	private JTextField txt_Qual;
	private JTextField txt_Salary;
	private JTextField txt_Contact;
	private JTextField txt_Email;
	private JTextField txt_Address;
	private JTable table;
	private JButton btnSave;
	private JButton btnEdit;
	
	
	
	public void TeacherRefreshTable() {
	  	   try {
					String query = "select * from TeacherTable";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ps.close();
				
	  	   } catch (Exception e1) {
					e1.printStackTrace();
				}
	     }
	
	
	
	/**
	 * Create the frame.
	 */
	public Teacher() {
		
		initComponent();
		connection = ConnectionClass.dbConnector();
		
		
		
		
		
	}
	
      int newid;
	  String newutype;
	
	public Teacher(int id,  String txtutype) {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		TeacherRefreshTable();
		this.newid = id;
		this.newutype = txtutype;
		
		
		JOptionPane.showMessageDialog(this, newid);
		
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		panel_4.setBorder(panel_3_border);
		
	}
	

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 653, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 54, 653, 408);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(10, 11, 325, 304);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(45, 58, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(99, 11, 68, 29);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Qualification");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 98, 89, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Salary(GH\u00A2)");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 138, 89, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(45, 221, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(37, 178, 54, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(33, 263, 58, 14);
		panel_3.add(lblNewLabel_6);
		
		txt_Name = new JTextField();
		txt_Name.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Name.setColumns(10);
		txt_Name.setBounds(99, 51, 209, 29);
		panel_3.add(txt_Name);
		
		txt_Qual = new JTextField();
		txt_Qual.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Qual.setColumns(10);
		txt_Qual.setBounds(99, 91, 209, 29);
		panel_3.add(txt_Qual);
		
		txt_Salary = new JTextField();
		txt_Salary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txt_Salary.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Salary.setColumns(10);
		txt_Salary.setBounds(99, 131, 209, 29);
		panel_3.add(txt_Salary);
		
		txt_Contact = new JTextField();
		txt_Contact.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txt_Contact.setColumns(10);
		txt_Contact.setBounds(99, 171, 209, 29);
		panel_3.add(txt_Contact);
		
		txt_Email = new JTextField();
		
		txt_Email.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Email.setColumns(10);
		txt_Email.setBounds(99, 214, 209, 29);
		panel_3.add(txt_Email);
		
		txt_Address = new JTextField();
		txt_Address.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_Address.setColumns(10);
		txt_Address.setBounds(99, 256, 209, 29);
		panel_3.add(txt_Address);
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(67, 18, 24, 14);
		panel_3.add(lblNewLabel_7);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground( new Color(0, 84, 104));
			}
		});
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want Delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
				
						String query = "delete from TeacherTable where ID = '"+textField.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Teacher Data Deleted!");
						
					   btnSave.setEnabled(true);
					  
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				TeacherRefreshTable();	
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(224, 333, 94, 40);
		panel_1.add(btnDelete);
		
		btnSave = new JButton("Save");
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
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				String name = txt_Name.getText();
				String qual =txt_Qual.getText();
				String salary = txt_Salary.getText();
				String contact = txt_Contact.getText();
				String email = txt_Email.getText();
				String address = txt_Address.getText();
     
				try {
				    
					String query = "insert into TeacherTable (Name, Qualification, Salary, Contact, Email, Address, Login) values (?, ?, ?, ?, ?, ?, ?)";
				   ps = connection.prepareStatement(query);
					
					ps.setString(1, name);
					ps.setString(2, qual);
					ps.setString(3, salary);
					ps.setString(4, contact);
					ps.setString(5, email);
					ps.setString(6, address);
					ps.setInt(7, newid);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Teacher Added ");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TeacherRefreshTable();
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(20, 333, 94, 40);
		panel_1.add(btnSave);
		
		btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setBackground( new Color(0, 84, 104));
			}
		});
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnEdit.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update TeacherTable set ID = '"+textField.getText()+"',Name = '"+txt_Name.getText()+"' ,Qualification = '"+txt_Qual.getText()+"' , Salary = '"+txt_Salary.getText()+"' , Contact = '"+txt_Contact.getText()+"', Email = '"+txt_Email.getText()+"', Address = '"+txt_Address.getText()+"'  where ID = '"+textField.getText()+"' ";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TeacherRefreshTable();
				
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		btnEdit.setBackground(new Color(100, 149, 237));
		btnEdit.setBounds(124, 333, 90, 40);
		panel_1.add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 11, 298, 386);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from TeacherTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						textField.setText(rs.getString("ID"));
						txt_Name.setText(rs.getString("Name"));
						txt_Qual.setText(rs.getString("Qualification"));
						txt_Salary.setText(rs.getString("Salary"));
						txt_Contact.setText(rs.getString("Contact"));
						txt_Email.setText(rs.getString("Email"));
						txt_Address.setText(rs.getString("Address"));
						
							
						btnSave.setEnabled(false);
						
						
					}
					
					rs.close();
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(204, 0, 176, 40);
		panel.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Teacher");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(38, 11, 104, 29);
		panel_4.add(lblNewLabel);
		
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
		lblNewLabel_Mim.setBounds(589, 11, 22, 21);
		panel.add(lblNewLabel_Mim);
		
		lblNewLabel_close = new JLabel(" x");
		lblNewLabel_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
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
		});
		lblNewLabel_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_close.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_close.setBounds(621, 11, 22, 21);
		panel.add(lblNewLabel_close);
		
		
		
	}

}
