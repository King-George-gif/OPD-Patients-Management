package graphical_interface;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database_management.SqliteStaffConnection;
import staff_classes.NurseClass;
import staff_classes.ReceptionistClass;
import staff_classes.Staff;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login {

	private JFrame frmLoginToApplication;
	public Connection conn = null;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel queryoutputlabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginToApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conn = SqliteStaffConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginToApplication = new JFrame();
		frmLoginToApplication.setUndecorated(true);
		
		frmLoginToApplication.getContentPane().setBackground(new Color(47, 79, 79));
		frmLoginToApplication.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(172, 181, 244, 39);
		panel.setBackground(Color.WHITE);
		frmLoginToApplication.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsername.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBounds(10, 11, 178, 28);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel userNameloginlabel = new JLabel("");
		userNameloginlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image usernameimage = new ImageIcon(this.getClass().getResource("/username.png")).getImage();
		userNameloginlabel.setIcon(new ImageIcon(usernameimage));
		userNameloginlabel.setBounds(198, 0, 46, 39);
		panel.add(userNameloginlabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(172, 231, 244, 39);
		panel_1.setBackground(Color.WHITE);
		frmLoginToApplication.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar((char)0);
		passwordField.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password")) {
					passwordField.setEchoChar('*');
					passwordField.setText("");
				}
				else {
					passwordField.selectAll();
				}
				
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals("")) {
					passwordField.setText("Password");
					passwordField.setEchoChar((char)0);
				}
			}
		});
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(10, 11, 178, 24);
		panel_1.add(passwordField);
		
		JLabel passwordloginlabel = new JLabel("");
		passwordloginlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image passloginimage = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		passwordloginlabel.setIcon(new ImageIcon(passloginimage));
		passwordloginlabel.setBounds(198, 0, 46, 35);
		panel_1.add(passwordloginlabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(txtUsername.getText().length() == 0 || passwordField.getText().length() == 0) {
					queryoutputlabel.setText("All Fields Are Required");
				}
				else {
					try {
						String query = "select * from staff where username=? and password=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, txtUsername.getText());
						pst.setString(2, passwordField.getText());
						ResultSet rst = pst.executeQuery();
						int count = 0;
						int designation = 0;
						String firstname = "";
						String lastname = "";
						
						while(rst.next()) {
							count++;
							designation = rst.getInt("designation");
							firstname = rst.getString("firstname");
							lastname = rst.getString("lastname");
						}
						
						if(count == 1) {
							
							frmLoginToApplication.dispose();//Closing the login page
							if(designation == 3) {
								//Receptionist page
								ReceptionistClass worker = new ReceptionistClass(firstname, lastname);
								Receptionist receptionist = new Receptionist(worker);
								receptionist.setVisible(true);
							}
							else if(designation == 4) {
								//Nurse page
								NurseClass worker = new NurseClass(firstname, lastname);
								Nurse nurse = new Nurse(worker);
								nurse.setVisible(true);
							}
							else if(designation == 5) {
								//Doctor page
							}
							else if(designation == 6) {
								//lab technician page
							}
							else if(designation == 7) {
								//pharmacist page
							}
							else if(designation == 8) {
								//accountant page
							}
							
							queryoutputlabel.setText("Valid username and password");
						}
						else {
							queryoutputlabel.setText("Invalid username or password");
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_2.setBackground(Color.DARK_GRAY);
			}
		});
		panel_2.setBounds(172, 316, 244, 39);
		panel_2.setBackground(Color.WHITE);
		frmLoginToApplication.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setBounds(65, 0, 115, 39);
		panel_2.add(lblNewLabel);
		
		JLabel loginlabel = new JLabel("");
		loginlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image loginimage = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
		loginlabel.setIcon(new ImageIcon(loginimage));
		loginlabel.setBounds(0, 0, 55, 39);
		panel_2.add(loginlabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(172, 11, 225, 116);
		Image hos_logo = new ImageIcon(this.getClass().getResource("/hos1.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(hos_logo));
		frmLoginToApplication.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the application?", "Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					frmLoginToApplication.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.WHITE);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(566, 0, 34, 22);
		frmLoginToApplication.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login with your username and password");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(156, 138, 265, 32);
		frmLoginToApplication.getContentPane().add(lblNewLabel_3);
		
		queryoutputlabel = new JLabel("");
		queryoutputlabel.setHorizontalAlignment(SwingConstants.CENTER);
		queryoutputlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		queryoutputlabel.setForeground(new Color(255, 0, 0));
		queryoutputlabel.setBounds(172, 274, 244, 39);
		frmLoginToApplication.getContentPane().add(queryoutputlabel);
		frmLoginToApplication.setTitle("Login to application");
		frmLoginToApplication.setBounds(100, 100, 600, 400);
		frmLoginToApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
