package graphical_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqliteStaffConnection;

public class NewUsernameAndPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel usernameError;
	private JLabel passwordError;
	Connection conn = null;
	private int SID;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public void changeDetails() {
		if(this.SID > 0) {
			try {
				
				String query = "update staff set username='"+textField.getText()+"',password='"+passwordField.getText()+"' where staff_id = "+this.SID;
				PreparedStatement pst = conn.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Login Details Successfully Changed");
				pst.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Something is not right, please try again later");
		}
	}
	
	public NewUsernameAndPassword(int SID) {
		this.SID = SID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Enter Your New Username And Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 11, 428, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(52, 74, 109, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(52, 125, 109, 26);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().isBlank()) {
					usernameError.setText("Field Is Required");
				}else {
					usernameError.setText("");
				}
			}
		});
		textField.setBounds(171, 76, 143, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().isBlank()) {
					passwordError.setText("Field Is Required");
				}else {
					passwordError.setText("");
				}
			}
		});
		passwordField.setBounds(171, 127, 143, 26);
		contentPane.add(passwordField);
		
		usernameError = new JLabel("");
		usernameError.setForeground(Color.RED);
		usernameError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		usernameError.setBounds(324, 74, 137, 26);
		contentPane.add(usernameError);
		
		passwordError = new JLabel("");
		passwordError.setForeground(Color.RED);
		passwordError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		passwordError.setBounds(324, 125, 137, 22);
		contentPane.add(passwordError);
		
		JLabel invalidusernameandpassword = new JLabel("");
		invalidusernameandpassword.setForeground(Color.RED);
		invalidusernameandpassword.setHorizontalAlignment(SwingConstants.CENTER);
		invalidusernameandpassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		invalidusernameandpassword.setBounds(169, 164, 216, 14);
		contentPane.add(invalidusernameandpassword);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conn = SqliteStaffConnection.dbConnector();
				if(textField.getText().isBlank() || passwordField.getText().isBlank()) {
					invalidusernameandpassword.setText("All Fields Are Required");
				}
				else {
					changeDetails();
					
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);  
					  win.dispose();    //dispose off this frame
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(164, 189, 84, 31);
		contentPane.add(btnNewButton);
	}

}
