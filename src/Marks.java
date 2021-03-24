import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class Marks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JLabel lblNewLabel_Mim;
	private JLabel lblNewLabel_close;
	private JPanel panel_4;
	private JPanel panel_3;
	private JComboBox comboBoxSubject;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JTextField textField_3;
	
	
	 public void MarkfillComboboxSubject() {
	  	   try {
					String query = "select ID, SubjectName from SubjectTable";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						comboBoxSubject.addItem(rs.getString("SubjectName"));
						
					}
					rs.close();
					ps.close();
				
	  	   } catch (Exception e1) {
					e1.printStackTrace();
				}
	 }
	 
	 public void MarkRefreshTable() {
	  	   try {
					String query = "select * from MarksTable";
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
	public Marks() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		
		MarkfillComboboxSubject();
		MarkRefreshTable();
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_4.setBorder(panel_3_border);
		panel_3.setBorder(panel_3_border);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 0, 336, 50);
		panel_3.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground( new Color(0, 84, 104));
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(237, 11, 89, 30);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(66, 61, 23, 14);
		panel_3.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(95, 52, 87, 29);
		panel_3.add(textField_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try {
					
					String query = "select * from StudentTable where id = ?";
					
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textField.getText());
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next() == false) {
						
						JOptionPane.showMessageDialog(null, "Student Not Found");
						textField_1.setText("");
						
					}else {
						String name = rs.getString("Stname");
						textField_1.setText(name.trim());
						
						String classes = rs.getString("class");
						comboBox.addItem(classes.trim());
					}
					
					rs.close();
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				MarkRefreshTable();	
			}
				
			
		});
		
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 705, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 705, 430);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(10, 11, 340, 357);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Student No.");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 19, 71, 14);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setColumns(10);
		textField.setBounds(85, 12, 147, 29);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(99, 92, 225, 29);
		panel_3.add(textField_1);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(99, 144, 156, 30);
		panel_3.add(comboBox);
		
		comboBoxSubject = new JComboBox();
		comboBoxSubject.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBoxSubject.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxSubject.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxSubject.setBounds(99, 202, 156, 30);
		panel_3.add(comboBoxSubject);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setColumns(10);
		textField_2.setBounds(99, 263, 133, 29);
		panel_3.add(textField_2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select ", "1st Term", "2nd Term", "3rd Term"}));
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_2.setBounds(99, 316, 156, 30);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Term");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(35, 324, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Marks");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(35, 270, 46, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Class");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(35, 152, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Subjects");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(24, 210, 56, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Student Name");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 99, 87, 14);
		panel_3.add(lblNewLabel_6);
		
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
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  
				try {
				    
					String query = "insert into MarksTable (Sid, Class, Subject, Marks, Terms) values (?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, textField.getText());
					ps.setString(2, comboBox.getSelectedItem().toString());
					ps.setString(3, comboBoxSubject.getSelectedItem().toString());
					ps.setString(4, textField_2.getText());
					ps.setString(5, comboBox_2.getSelectedItem().toString());
					ps.execute();
					
					JOptionPane.showMessageDialog(null, " Marks Added ");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				MarkRefreshTable();	
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnSave.setBackground(new Color(30, 144, 255));
		btnSave.setBounds(20, 379, 94, 40);
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
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want Delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
				
					String query = "delete from MarksTable where ID = '"+textField_3.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Marks Data Deleted!");
						
						btnSave.setEnabled(true);
						
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				MarkRefreshTable();	
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnDelete.setBackground(new Color(30, 144, 255));
		btnDelete.setBounds(137, 379, 94, 40);
		panel_1.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 11, 335, 375);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from MarksTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						textField_3.setText(rs.getString("ID"));
						textField.setText(rs.getString("Sid"));
						comboBox.setSelectedItem(rs.getString("Class"));
						comboBoxSubject.setSelectedItem(rs.getString("Subject"));
						textField_2.setText(rs.getString("Marks"));
						comboBox_2.setSelectedItem(rs.getString("Terms"));
						
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
		
		JButton btnPrint = new JButton("Print");
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
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnPrint.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnPrint.setBackground(new Color(30, 144, 255));
		btnPrint.setBounds(256, 379, 94, 40);
		panel_1.add(btnPrint);
		
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
		lblNewLabel_Mim.setBounds(641, 11, 22, 21);
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
		lblNewLabel_close.setBounds(673, 11, 22, 21);
		panel.add(lblNewLabel_close);
		
	    panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(268, 0, 127, 45);
		panel.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Marks");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(33, 11, 73, 30);
		panel_4.add(lblNewLabel);
	}
}
