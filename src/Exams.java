import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Exams extends JFrame {

	private JPanel contentPane;
	private JPanel panel_3;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exams frame = new Exams();
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
	private JTable table;
	private JComboBox comboBoxClass;
	private JComboBox comboBoxSection;
	private JComboBox comboBoxSubject;
	private JLabel lblNewLabel_close;
	private JLabel lblNewLabel_Mim;
	
	
	 public void ExamRefreshTable() {
	  	   try {
					String query = "select * from ExamTable";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ps.close();
				
	  	   } catch (Exception e1) {
					e1.printStackTrace();
				}
	     }
	
	
	
	
	 public void ExamfillCombobox() {
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
	 
	 
	 public void ExamfillComboboxSubject() {
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
	
	
	
	
	
	

	/**
	 * Create the frame.
	 */
	public Exams() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		ExamfillCombobox();
		ExamfillComboboxSubject();
		ExamRefreshTable();
		
		
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
		setBounds(100, 100, 789, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 769, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 57, 769, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 21, 268, 290);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Exam Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 68, 68, 14);
		panel_4.add(lblNewLabel);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setFont(new Font("Arial", Font.BOLD, 12));
		lblTerm.setBounds(48, 101, 30, 14);
		panel_4.add(lblTerm);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblDate.setBounds(58, 126, 30, 14);
		panel_4.add(lblDate);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Arial", Font.BOLD, 12));
		lblClass.setBounds(48, 172, 36, 14);
		panel_4.add(lblClass);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Arial", Font.BOLD, 12));
		lblSection.setBounds(35, 212, 43, 14);
		panel_4.add(lblSection);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Arial", Font.BOLD, 12));
		lblSubject.setBounds(35, 251, 52, 14);
		panel_4.add(lblSubject);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(96, 60, 153, 28);
		panel_4.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "1st Term", "2nd Term", "3rd Term"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(98, 93, 101, 28);
		panel_4.add(comboBox);
		
		comboBoxClass = new JComboBox();
		comboBoxClass.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxClass.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxClass.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxClass.setBounds(98, 164, 101, 28);
		panel_4.add(comboBoxClass);
		
		comboBoxSection = new JComboBox();
		comboBoxSection.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxSection.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxSection.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxSection.setBounds(98, 204, 101, 28);
		panel_4.add(comboBoxSection);
		
		comboBoxSubject = new JComboBox();
		comboBoxSubject.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxSubject.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBoxSubject.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxSubject.setBounds(97, 243, 101, 28);
		panel_4.add(comboBoxSubject);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(98, 126, 153, 28);
		panel_4.add(dateChooser);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(67, 35, 11, 14);
		panel_4.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setFont(new Font("Arial", Font.BOLD, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(96, 27, 74, 28);
		panel_4.add(textField_1);
		
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
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSave.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dfi = new SimpleDateFormat("yyyy-MM-dd");
				String date =dfi.format(dateChooser.getDate());
				try {
					String query = "insert into ExamTable (ExamName, Term, Date, Class, Section, Subject) values (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, comboBox.getSelectedItem().toString());
		     	    ps.setString(3, date);
					ps.setString(4, comboBoxClass.getSelectedItem().toString());
					ps.setString(5, comboBoxSection.getSelectedItem().toString());
					ps.setString(6, comboBoxSubject.getSelectedItem().toString());
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Exam Data Saved");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				ExamRefreshTable();
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(20, 329, 94, 40);
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
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want Delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
				
					String query = "delete from ExamTable where ID = '"+textField_1.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Exam Data Deleted!");
						
						btnSave.setEnabled(true);
						
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				ExamRefreshTable();
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(124, 329, 94, 40);
		panel_1.add(btnDelete);
		
		JButton btnBack = new JButton("Print");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground( new Color(0, 84, 104));
			}
		});
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnBack.setBackground(new Color(100, 149, 237));
		btnBack.setBounds(228, 329, 90, 40);
		panel_1.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 11, 471, 312);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from ExamTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						textField_1.setText(rs.getString("ID"));
						textField.setText(rs.getString("ExamName"));
						comboBox.setSelectedItem(rs.getString("Term"));
					
						String date =rs.getString("Date");
						((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(date);
				
			           comboBoxClass.setSelectedItem(rs.getString("Class"));
						comboBoxSection.setSelectedItem(rs.getString("Section"));
						comboBoxSubject.setSelectedItem(rs.getString("Subject"));
							
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
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
		lblNewLabel_Mim.setBounds(689, 11, 22, 21);
		panel.add(lblNewLabel_Mim);
		
		lblNewLabel_close = new JLabel(" x");
		lblNewLabel_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MainClass dd = new MainClass();
				dd.setVisible(true);
				dd.setLocationRelativeTo(null);
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
		lblNewLabel_close.setBounds(721, 11, 22, 21);
		panel.add(lblNewLabel_close);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(262, 0, 178, 48);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Exams");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(49, 11, 79, 30);
		panel_3.add(lblNewLabel_2);
	}
}
