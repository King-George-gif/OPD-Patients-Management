package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_management.SqliteStaffConnection;
import staff_classes.DoctorClass;
import staff_classes.NurseClass;
import staff_classes.ReceptionistClass;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangeLoginDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel usernameError;
	private JLabel passwordError;
	Connection conn = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ChangeLoginDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Your Existing/Old Username And Password");
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
					try {
						String query = "select staff_id from staff where username=? and password=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, textField.getText());
						pst.setString(2, passwordField.getText());
						ResultSet rst = pst.executeQuery();
						int count = 0;
						int staff_id = 0;
						
						while(rst.next()) {
							count++;
							staff_id = rst.getInt("staff_id");
						}
						
						if(count == 1) {
							NewUsernameAndPassword frame = new NewUsernameAndPassword(staff_id);
							frame.setTitle("Change Login Details");
							frame.setVisible(true);
							
							JComponent comp = (JComponent) e.getSource();
							  Window win = SwingUtilities.getWindowAncestor(comp);  
							  win.dispose();    //dispose off this frame
						}
						else {
							invalidusernameandpassword.setText("Invalid username or password");
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(164, 189, 84, 31);
		contentPane.add(btnNewButton);
	}
}
