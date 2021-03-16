package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterNewPatients extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel firstNameError;
	private JLabel secondNameError;
	private JLabel residenceError;
	private JLabel dateOfBirthError;
	private JLabel phoneNumberError;
	private JLabel emergencyContactError;
	private JLabel emergencyContactRelationError;
	private JLabel emergencyContactNameError;
	private JLabel lblNewLabel_12;
	private JComboBox comboBox;
	private boolean istextFieldClean = false;
	private boolean istextField_1Clean = false;
	private boolean istextField_2Clean = false;
	private boolean istextField_3Clean = false;
	private boolean iscomboBoxClean = false;
	private boolean istextField_5Clean = true;
	private boolean istextField_6Clean = true;
	private boolean istextField_7Clean = true;
	private boolean test = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterNewPatients frame = new RegisterNewPatients();
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
	public RegisterNewPatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER NEW PATIENTS HERE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(279, 11, 300, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(108, 96, 218, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Second Name *");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(108, 137, 218, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Place Of Residence *");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(108, 178, 218, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date Of Birth (YYYY-MM-DD) *");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(108, 219, 218, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender*");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 260, 218, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number (0XXXXXXXXX)");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(108, 301, 218, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Emergency Contact Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(108, 342, 218, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Emergency Contact Relationship");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(108, 383, 218, 30);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Emergency Contact Name");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(108, 424, 218, 30);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().isBlank()) {
					istextFieldClean = false;
					firstNameError.setText("First Name is Required");
				}
				else {
					firstNameError.setText("");
					istextFieldClean = true;
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(352, 96, 227, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().isBlank()) {
					secondNameError.setText("Second Name Is A Required Field");
					istextField_1Clean = false;
				}
				else {
					secondNameError.setText("");
					istextField_1Clean = true;
				}
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(352, 137, 227, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_2.getText().isBlank() ) {
					residenceError.setText("Place of Residence Is Required");
					istextField_2Clean = false;
				}
				else {
					residenceError.setText("");
					istextField_2Clean = true;
				}
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(352, 178, 227, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_3.getText().isBlank()) {
					dateOfBirthError.setText("Date Of Birth Is A Required Field");
					istextField_3Clean = false;
				}
				else {
					dateOfBirthError.setText("");
					istextField_3Clean = true;
				}
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(352, 219, 227, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_5.getText().length() > 0 && textField_5.getText().length() < 10) {
					phoneNumberError.setText("Contact must be 10 in number");
					istextField_5Clean = false;					
				}
				else if(textField_5.getText().length() > 10) {
					phoneNumberError.setText("Contact must be 10 in number");
					istextField_5Clean = false;
				}
				else {
					if(textField_5.getText().length() == 10) {
						try {
							Integer.parseInt(textField_5.getText());
							phoneNumberError.setText("");
							istextField_5Clean = true;
						}catch(Exception ess) {
							phoneNumberError.setText("");
							phoneNumberError.setText("Your input contain invalid character(s)");
							istextField_5Clean = false;
							ess.printStackTrace();
						}
					}
					else {
						textField_5.setText("");
						istextField_5Clean = true;
					}
					
				}
			}
		});
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(352, 301, 227, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_6.getText().length() > 0 && textField_6.getText().length() < 10) {
					emergencyContactError.setText("Contact Must be 10 in number");
					istextField_6Clean = false;
				}
				else if(textField_6.getText().length() > 10){
					emergencyContactError.setText("Contact Must be 10 in number");
					istextField_6Clean = false;
				}
				else {
					if(textField_6.getText().length() != 0) {
						try {
							Integer.parseInt(textField_6.getText());
							emergencyContactError.setText("");
							lblNewLabel_8.setText("Emergency Contact Relationship*");
							textField_7.setEditable(true);
							textField_8.setEditable(true);
							istextField_6Clean = true;
							istextField_7Clean = false;
							
						}catch(Exception ess) {
							emergencyContactError.setText("");
							emergencyContactError.setText("Your input contain invalid character(s)");
							lblNewLabel_8.setText("Emergency Contact Relationship");
							istextField_6Clean = false;
							istextField_7Clean = false;
							ess.printStackTrace();
						}
					}
					else {
						emergencyContactError.setText("");
						istextField_6Clean = true;
						istextField_7Clean = true;
						textField_7.setText("");
						textField_8.setText("");
						lblNewLabel_8.setText("Emergency Contact Relationship");
						textField_7.setEditable(false);
						textField_8.setEditable(false);
						
					}
				}
			}
		});
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(352, 342, 227, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(emergencyContactError.getText().equals("") && !textField_6.getText().equals("")) {
					if(textField_7.getText().isBlank()) {
						istextField_7Clean = false;
						emergencyContactRelationError.setText("This field has been made Required");
					}
					else {
						emergencyContactRelationError.setText("");
						istextField_7Clean = true;
						
					}
					
				}
				else {
					emergencyContactRelationError.setText("");
					lblNewLabel_8.setText("Emergency Contact Relationship");
					istextField_7Clean = true;
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				emergencyContactRelationError.setText("");
			}
		});
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(352, 383, 227, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setBounds(352, 424, 227, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Register Patient");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				test = istextFieldClean && istextField_1Clean && istextField_2Clean && istextField_3Clean && 
						istextField_5Clean && istextField_6Clean && istextField_7Clean && iscomboBoxClean ;
				if(!test) {
					//there is an error
				}
				else {
					//Everything is good
				}
				
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(238, 500, 184, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(352, 462, 227, 27);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("All Fields marked * Are Required Fields");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setForeground(Color.DARK_GRAY);
		lblNewLabel_11.setBounds(352, 64, 242, 21);
		contentPane.add(lblNewLabel_11);
		
		firstNameError = new JLabel("");
		firstNameError.setForeground(Color.RED);
		firstNameError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstNameError.setBounds(601, 96, 248, 24);
		contentPane.add(firstNameError);
		
		secondNameError = new JLabel("");
		secondNameError.setForeground(Color.RED);
		secondNameError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		secondNameError.setBounds(601, 140, 248, 21);
		contentPane.add(secondNameError);
		
		residenceError = new JLabel("");
		residenceError.setForeground(Color.RED);
		residenceError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		residenceError.setBounds(601, 178, 248, 24);
		contentPane.add(residenceError);
		
		dateOfBirthError = new JLabel("");
		dateOfBirthError.setForeground(Color.RED);
		dateOfBirthError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateOfBirthError.setBounds(601, 219, 248, 30);
		contentPane.add(dateOfBirthError);
		
		phoneNumberError = new JLabel("");
		phoneNumberError.setForeground(Color.RED);
		phoneNumberError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phoneNumberError.setBounds(601, 301, 248, 24);
		contentPane.add(phoneNumberError);
		
		emergencyContactError = new JLabel("");
		emergencyContactError.setForeground(Color.RED);
		emergencyContactError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencyContactError.setBounds(601, 342, 248, 24);
		contentPane.add(emergencyContactError);
		
		emergencyContactRelationError = new JLabel("");
		emergencyContactRelationError.setForeground(Color.RED);
		emergencyContactRelationError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencyContactRelationError.setBounds(601, 383, 248, 24);
		contentPane.add(emergencyContactRelationError);
		
		emergencyContactNameError = new JLabel("");
		emergencyContactNameError.setForeground(Color.RED);
		emergencyContactNameError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencyContactNameError.setBounds(601, 424, 248, 24);
		contentPane.add(emergencyContactNameError);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((String)comboBox.getSelectedItem()).equals("Select Your Gender")) {
					lblNewLabel_12.setText("Please Select one of the options");
					iscomboBoxClean = false;
				}
				else {
					lblNewLabel_12.setText("");
					iscomboBoxClean = true;
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Your Gender", "Male", "Female", "I prefer not to say"}));
		comboBox.setBounds(352, 261, 227, 27);
		contentPane.add(comboBox);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(601, 260, 248, 24);
		contentPane.add(lblNewLabel_12);
	}
}
