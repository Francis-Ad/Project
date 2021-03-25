import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Font;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class StudentClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox comboBoxClass;
	private JComboBox comboBoxSection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentClass frame = new StudentClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JPanel panel_3;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblNewLabel_Mim;
	private JLabel lblNewLabel_close;
	
	
	public void StudentfillCombobox() {
	  	   try {
					String query = "select ID, ClassName, Section from ClassTable";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						comboBoxClass.addItem(rs.getString("ClassName"));
						comboBoxSection.addItem(rs.getString("Section"));
					}
					rs.close();
					ps.close();
				
	  	   } catch (Exception e1) {
					e1.printStackTrace();
				}
	 }
	 
	 public void StudentRefreshTable() {
	  	   try {
					String query = "select * from StudentTable";
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
	public StudentClass() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		StudentfillCombobox();
		StudentRefreshTable();
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_4.setBorder(panel_3_border);
		panel_2.setBorder(panel_3_border);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 835, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 54, 835, 478);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 11, 312, 405);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 75, 98, 14);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(131, 68, 168, 30);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.BLACK, 2, true));
		textField_1.setBounds(129, 24, 86, 30);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_2.setBounds(131, 109, 168, 30);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Parent Name");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(23, 116, 98, 14);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Date of Birth");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(23, 166, 98, 14);
		panel_2.add(lblNewLabel_2_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 150, 173, 37);
		panel_2.add(dateChooser);
		
		JLabel lblNewLabel_2_3 = new JLabel("Gender");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(60, 202, 61, 14);
		panel_2.add(lblNewLabel_2_3);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnMale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		rdbtnMale.setBounds(134, 198, 86, 23);
		panel_2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnFemale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		rdbtnFemale.setBounds(227, 198, 109, 23);
		panel_2.add(rdbtnFemale);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Contact");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(60, 233, 61, 14);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_3.setBounds(131, 226, 168, 30);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Address");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(60, 275, 61, 14);
		panel_2.add(lblNewLabel_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_4.setBounds(131, 268, 168, 30);
		panel_2.add(textField_4);
		
		comboBoxClass = new JComboBox();
		comboBoxClass.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxClass.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxClass.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxClass.setBounds(131, 309, 168, 33);
		panel_2.add(comboBoxClass);
		
		comboBoxSection = new JComboBox();
		comboBoxSection.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxSection.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxSection.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxSection.setBounds(131, 353, 168, 33);
		panel_2.add(comboBoxSection);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Class");
		lblNewLabel_2_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_2_1.setBounds(73, 318, 48, 14);
		panel_2.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Section");
		lblNewLabel_2_1_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_2_2.setBounds(66, 362, 55, 14);
		panel_2.add(lblNewLabel_2_1_2_2);
		
		JLabel lblNewLabel_2_1_2_3 = new JLabel("ID");
		lblNewLabel_2_1_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_2_3.setBounds(96, 31, 25, 14);
		panel_2.add(lblNewLabel_2_1_2_3);
		
		JButton btnSave = new JButton("Save");
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dfi = new SimpleDateFormat("yyyy-MM-dd");
				String date =dfi.format(dateChooser.getDate());
				try {
					String query = "insert into StudentTable (Stname, Pname, DOB, Gender, Contact, Address, Class, Section) values (?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, textField_2.getText());
		     	    ps.setString(3, date);
		     	    
		     	    String gender = "Male";
		     	    if (rdbtnFemale.isSelected()) {
		     	    	gender = "Female";
		     	    }
		     	    ps.setString(4, gender);
		     	    ps.setString(5, textField_3.getText());
		     	    ps.setString(6, textField_4.getText());
					ps.setString(7, comboBoxClass.getSelectedItem().toString());
					ps.setString(8, comboBoxSection.getSelectedItem().toString());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Student Data Saved");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				StudentRefreshTable();
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(10, 427, 85, 40);
		panel_1.add(btnSave);
		
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
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want Delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
				
					String query = "delete from StudentTable where ID = '"+textField_1.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Student Data Deleted!");
						
						btnSave.setEnabled(true);
						
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				StudentRefreshTable();
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(105, 427, 96, 40);
		panel_1.add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in Progress");
				MessageFormat footer = new MessageFormat("Page {0, number, interger}");
				
				try {
				table.print(JTable.PrintMode.NORMAL, header, footer);
					
				}catch (java.awt.print.PrinterException e4){
					System.err.format("No Printer Found", e4.getMessage());
				}
			}
		});
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrint.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrint.setBackground( new Color(0, 84, 104));
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnPrint.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnPrint.setBackground(new Color(100, 149, 237));
		btnPrint.setBounds(211, 427, 85, 40);
		panel_1.add(btnPrint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 11, 493, 405);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from StudentTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						textField_1.setText(rs.getString("ID"));
						textField.setText(rs.getString("Stname"));
						textField_2.setText(rs.getString("Pname"));
			
						String date =rs.getString("DOB");
						((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(date);
						
				         String gender = rs.getString("Gender");
				         if (gender.equals("Male")) {
				        	 rdbtnMale.setSelected(true);
				         }else if(gender.equals("Female")) {
				        	 rdbtnFemale.setSelected(true);
				        	 
				         }
						
				         textField_3.setText(rs.getString("Contact"));
						textField_4.setText(rs.getString("Address"));
                        comboBoxClass.setSelectedItem(rs.getString("Class"));
						comboBoxSection.setSelectedItem(rs.getString("Section"));
						
							
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
		panel_4.setBounds(312, 2, 161, 41);
		panel.add(panel_4);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setForeground(new Color(230, 230, 250));
		lblStudents.setFont(new Font("Arial", Font.BOLD, 23));
		lblStudents.setBackground(Color.BLACK);
		lblStudents.setBounds(32, 11, 119, 30);
		panel_4.add(lblStudents);
		
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
		lblNewLabel_Mim.setBounds(771, 11, 22, 21);
		panel.add(lblNewLabel_Mim);
		
		lblNewLabel_close = new JLabel(" x");
		lblNewLabel_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblNewLabel_close.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_close.setBounds(803, 11, 22, 21);
		panel.add(lblNewLabel_close);
	}
}
