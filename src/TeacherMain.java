import java.awt.BorderLayout;
import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class TeacherMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_close;
	private JLabel lblNewLabel_Mim;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2;
	private JButton btnMarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMain frame = new TeacherMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public TeacherMain() {
		setUndecorated(true);
		initComponent();
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		panel_4.setBorder(panel_3_border);
		panel_5.setBorder(panel_3_border);
		
	}

	
	int iiid;
	String usname;
	String usertype;

	public TeacherMain(int id, String txtusername, String txtutype) {
		setUndecorated(true);
		initComponent();
		this.usname = txtusername;
		lblNewLabel_2.setText(usname);
		
		this.usertype = txtutype;
		lblNewLabel_4.setText(usertype);
		
		this.iiid = id;
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		panel_4.setBorder(panel_3_border);
		panel_5.setBorder(panel_3_border);
		
	}
	
	
	
	
	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 625, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 52, 625, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(401, 11, 214, 96);
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 18, 66, 14);
		panel_4.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(102, 12, 78, 29);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UserType");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 57, 66, 20);
		panel_4.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(102, 54, 78, 29);
		panel_4.add(lblNewLabel_4);
		
		panel_5 = new JPanel();
		panel_5.setBounds(36, 51, 266, 319);
		panel_5.setLayout(null);
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(panel_5);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnStudent.setForeground(Color.WHITE);
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentClass vv = new StudentClass();
				vv.setVisible(true);
				vv.setLocationRelativeTo(null);
				
			}
		});
		btnStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStudent.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnStudent.setBackground( new Color(0, 84, 104));
			}
		});
		btnStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		btnStudent.setBackground(SystemColor.textHighlight);
		btnStudent.setBounds(70, 31, 125, 63);
		panel_5.add(btnStudent);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnTeacher.setForeground(Color.WHITE);
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usertype.equals("Teacher")) {
					setVisible(false);
				Teacher dd = new Teacher(iiid, usertype);
				   dd.setVisible(true);
				   dd.setLocationRelativeTo(null);
				  
				 
			
				  
				}
			}
		});
		btnTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTeacher.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTeacher.setBackground( new Color(0, 84, 104));
			}
		});
		btnTeacher.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTeacher.setBackground(SystemColor.textHighlight);
		btnTeacher.setBounds(70, 129, 125, 63);
		panel_5.add(btnTeacher);
		
		btnMarks = new JButton("Marks");
		btnMarks.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnMarks.setForeground(Color.WHITE);
		btnMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Marks mk = new Marks();
				mk.setVisible(true);
				mk.setLocationRelativeTo(null);
				
			}
		});
		btnMarks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMarks.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMarks.setBackground( new Color(0, 84, 104));
			}
		});
		btnMarks.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMarks.setBackground(SystemColor.textHighlight);
		btnMarks.setBounds(70, 229, 125, 63);
		panel_5.add(btnMarks);
		
		JLabel lblNewLabel_5 = new JLabel("School Management System");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(24, 0, 297, 40);
		panel_1.add(lblNewLabel_5);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(198, 1, 160, 40);
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Main");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(52, 11, 73, 30);
		panel_3.add(lblNewLabel);
		
		lblNewLabel_close = new JLabel(" x");
		lblNewLabel_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_close.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_close.setBackground( new Color(0, 84, 104));
			}
		});
		lblNewLabel_close.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_close.setBounds(593, 11, 22, 21);
		panel.add(lblNewLabel_close);
		
		lblNewLabel_Mim = new JLabel(" -");
		lblNewLabel_Mim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_Mim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_Mim.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_Mim.setBackground( new Color(0, 84, 104));
			}
		});
		lblNewLabel_Mim.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_Mim.setBounds(561, 11, 22, 21);
		panel.add(lblNewLabel_Mim);
	}
}
