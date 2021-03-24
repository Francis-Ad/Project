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

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Classes extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_Mim;
	private JLabel lblNewLabel_close;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnSave ;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classes frame = new Classes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JTextField textField;
	private JTable table;
	
	
	 public void classRefreshTable() {
	  	   try {
					String query = "select * from ClassTable";
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
	public Classes() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		classRefreshTable();
		
		
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
		setBounds(100, 100, 668, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 648, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 648, 242);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 21, 271, 151);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Class Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 62, 82, 14);
		panel_4.add(lblNewLabel);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Arial", Font.BOLD, 14));
		lblSection.setBounds(57, 104, 54, 14);
		panel_4.add(lblSection);
		
		JComboBox comboBoxClass = new JComboBox();
		comboBoxClass.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxClass.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxClass.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxClass.setBounds(121, 53, 112, 31);
		panel_4.add(comboBoxClass);
		
		JComboBox comboBoxSection = new JComboBox();
		comboBoxSection.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBoxSection.setModel(new DefaultComboBoxModel(new String[] {"Select", "A", "B", "C", "D", "E", "F", "G", "H"}));
		comboBoxSection.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxSection.setBounds(121, 95, 112, 31);
		panel_4.add(comboBoxSection);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(87, 18, 24, 14);
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(124, 11, 63, 31);
		panel_4.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(307, 11, 331, 220);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from ClassTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						textField.setText(rs.getString("ID"));
						comboBoxClass.setSelectedItem(rs.getString("ClassName"));
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
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
				try {
				    
					String query = "insert into ClassTable (ClassName, Section) values (?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					

					ps.setString(1, comboBoxClass.getSelectedItem().toString());
					ps.setString(2, comboBoxSection.getSelectedItem().toString());
					ps.execute();
					
					JOptionPane.showMessageDialog(null, " Class Data Saved");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				classRefreshTable();
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(20, 183, 84, 40);
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
				
						String query = "delete from ClassTable where ID = '"+textField.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Class Data Deleted!");
						
						btnSave.setEnabled(true);
						
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				classRefreshTable();
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(114, 183, 91, 40);
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
		btnBack.setBounds(218, 183, 84, 40);
		panel_1.add(btnBack);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(252, 0, 131, 35);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(35, 11, 68, 19);
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
		lblNewLabel_Mim.setBounds(584, 14, 22, 21);
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
		lblNewLabel_close.setBounds(616, 14, 22, 21);
		panel.add(lblNewLabel_close);
	}

}
