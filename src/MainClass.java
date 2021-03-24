import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class MainClass extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_close;
	private JLabel lblNewLabel_Mim;
	private JPanel panel_3;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_4;
	private JButton btnClass;
	private JButton btnSubject;
	private JButton btnExams;
	private JButton btnStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
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
	public MainClass() {
		setUndecorated(true);
		initComponent();
		
		
		
		
	}

	int iiid;
	String usname;
	String usertype;
	private JLabel lblNewLabel_5;

	public MainClass(int id, String txtusername, String txtutype) {
		setUndecorated(true);
		initComponent();
		
		this.usname = txtusername;
		lblNewLabel.setText(usname);
		
		this.usertype = txtutype;
		lblNewLabel_1.setText(usertype);
		
		this.iiid = id;
		
		
		
		Border lblNewLabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel_Mim.setBorder(lblNewLabel_border);
		lblNewLabel_close.setBorder(lblNewLabel_border);
		
		Border panel_3_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(panel_3_border);
		panel_4.setBorder(panel_3_border);
		panel_2.setBorder(panel_3_border);
		
	}
	
	
	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 630, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 59, 630, 392);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(411, 11, 209, 109);
		panel_1.add(panel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(100, 17, 84, 29);
		panel_2.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(100, 59, 84, 29);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 23, 66, 14);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("UserType");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 62, 66, 20);
		panel_2.add(lblNewLabel_4);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(33, 58, 274, 309);
		panel_1.add(panel_4);
		
		btnClass = new JButton("Class");
		btnClass.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Classes cs = new Classes();
				cs.setVisible(true);
				cs.setLocationRelativeTo(null);
			}
		});
		
		btnClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClass.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClass.setBackground( new Color(0, 84, 104));
			}
		});
		btnClass.setForeground(Color.WHITE);
		btnClass.setFont(new Font("Arial", Font.PLAIN, 20));
		btnClass.setBackground(SystemColor.textHighlight);
		btnClass.setBounds(56, 28, 160, 51);
		panel_4.add(btnClass);
		
		btnSubject = new JButton("Subject");
		btnSubject.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Subject sub = new Subject();
				sub.setVisible(true);
				sub.setLocationRelativeTo(null);
			}
		});
		btnSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubject.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubject.setBackground( new Color(0, 84, 104));
			}
		});
		btnSubject.setForeground(Color.WHITE);
		btnSubject.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSubject.setBackground(SystemColor.textHighlight);
		btnSubject.setBounds(56, 90, 160, 51);
		panel_4.add(btnSubject);
		
		btnExams = new JButton("Exams");
		btnExams.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Exams ex = new Exams();
				ex.setVisible(true);
				ex.setLocationRelativeTo(null);
				
			}
		});
		btnExams.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExams.setBackground( new Color(0, 101, 183));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExams.setBackground( new Color(0, 84, 104));
			}
		});
		btnExams.setForeground(Color.WHITE);
		btnExams.setFont(new Font("Arial", Font.PLAIN, 20));
		btnExams.setBackground(SystemColor.textHighlight);
		btnExams.setBounds(56, 152, 160, 51);
		panel_4.add(btnExams);
		
		btnStudent = new JButton("Student");
		btnStudent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentClass ckk = new StudentClass();
				ckk.setVisible(true);
				ckk.setLocationRelativeTo(null);
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
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		btnStudent.setBackground(SystemColor.textHighlight);
		btnStudent.setBounds(56, 222, 160, 51);
		panel_4.add(btnStudent);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(250, 0, 131, 44);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Main");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(35, 11, 61, 32);
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
		});
		lblNewLabel_Mim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_Mim.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_Mim.setBounds(566, 11, 22, 21);
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
		lblNewLabel_close.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_close.setBounds(598, 11, 22, 21);
		panel.add(lblNewLabel_close);
		
		lblNewLabel_5 = new JLabel("School Management System");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(33, 11, 297, 40);
		panel_1.add(lblNewLabel_5);
		
	}
}
