import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Subject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject frame = new Subject();
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
	private JLabel lblNewLabel_Mim;
	private JLabel lblNewLabel_close;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable table;
	private JButton btnSave;
	
	
	 public void SubjectRefreshTable() {
	  	   try {
					String query = "select * from SubjectTable";
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
	public Subject() {
		setUndecorated(true);
		initComponent();
		connection = ConnectionClass.dbConnector();
		SubjectRefreshTable() ;
		
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
		setBounds(100, 100, 668, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 645, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 645, 266);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 39, 312, 113);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 58, 60, 26);
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setColumns(10);
		textField.setBounds(80, 60, 206, 24);
		panel_4.add(textField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD, 14));
		lblId.setBounds(50, 21, 20, 26);
		panel_4.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(80, 23, 78, 24);
		panel_4.add(textField_1);
		
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
				
						String query = "delete from SubjectTable where ID = '"+textField_1.getText()+"' ";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, " Subject Data Deleted!");
						
						btnSave.setEnabled(true);
						
						ps.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				SubjectRefreshTable();
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(124, 178, 94, 40);
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
		btnBack.setBounds(228, 178, 90, 40);
		panel_1.add(btnBack);
		
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
				    
					String query = "insert into SubjectTable (SubjectName) values (?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
				    ps.setString(1, textField.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, " Subject Data Saved");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				SubjectRefreshTable();	
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(20, 178, 94, 40);
		panel_1.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 11, 275, 244);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from SubjectTable where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						textField_1.setText(rs.getString("ID"));
						textField.setText(rs.getString("SubjectName"));
							
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
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(212, 0, 178, 32);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Subject");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(33, 0, 108, 32);
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
		lblNewLabel_Mim.setBounds(581, 11, 22, 21);
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
		lblNewLabel_close.setBounds(613, 11, 22, 21);
		panel.add(lblNewLabel_close);
	}

}
