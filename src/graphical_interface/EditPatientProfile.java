package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class EditPatientProfile extends JFrame {

	private JPanel contentPane;
	private JTextField firstnamefield;
	private JTextField lastnamefield;
	private JTextField residencefield;
	private JTextField dateofbirthfield;
	private JTextField phonenumberfield;
	private JTextField emergencynumberfield;
	private JTextField emergencynamefield;
	private JTextField emergencyrelationshipfield;
	JPanel panel;
	Search search = new Search();

	public EditPatientProfile() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = search.panel;
		panel.setBounds(10, 11, 613, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(647, 40, 406, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Patient Details Here");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(51, 11, 283, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 79, 185, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 114, 185, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Residence");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 149, 194, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date Of Birth");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 184, 194, 24);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 219, 194, 24);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 254, 194, 24);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Emergency Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 289, 194, 24);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Emergency Name");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 324, 194, 24);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Relationship With Emergency");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(10, 359, 194, 24);
		panel.add(lblNewLabel_9);
		
		firstnamefield = new JTextField();
		firstnamefield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnamefield.setBounds(236, 81, 160, 24);
		panel.add(firstnamefield);
		firstnamefield.setColumns(10);
		
		lastnamefield = new JTextField();
		lastnamefield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastnamefield.setBounds(236, 114, 160, 24);
		panel.add(lastnamefield);
		lastnamefield.setColumns(10);
		
		residencefield = new JTextField();
		residencefield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		residencefield.setBounds(236, 149, 160, 24);
		panel.add(residencefield);
		residencefield.setColumns(10);
		
		dateofbirthfield = new JTextField();
		dateofbirthfield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateofbirthfield.setBounds(236, 184, 160, 24);
		panel.add(dateofbirthfield);
		dateofbirthfield.setColumns(10);
		
		JComboBox genderfield = new JComboBox();
		genderfield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		genderfield.setBounds(236, 222, 160, 22);
		panel.add(genderfield);
		
		phonenumberfield = new JTextField();
		phonenumberfield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phonenumberfield.setBounds(236, 254, 160, 24);
		panel.add(phonenumberfield);
		phonenumberfield.setColumns(10);
		
		emergencynumberfield = new JTextField();
		emergencynumberfield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencynumberfield.setBounds(236, 290, 160, 24);
		panel.add(emergencynumberfield);
		emergencynumberfield.setColumns(10);
		
		emergencynamefield = new JTextField();
		emergencynamefield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencynamefield.setBounds(236, 324, 160, 24);
		panel.add(emergencynamefield);
		emergencynamefield.setColumns(10);
		
		emergencyrelationshipfield = new JTextField();
		emergencyrelationshipfield.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emergencyrelationshipfield.setBounds(236, 359, 160, 23);
		panel.add(emergencyrelationshipfield);
		emergencyrelationshipfield.setColumns(10);
		
		JButton btnNewButton = new JButton("Update Patient Details");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Do you want to update Patient Details with these details \n First Name ="+firstnamefield.getText()+" \n Last Name = "+lastnamefield.getText()+" \n Date Of Birth = "+dateofbirthfield.getText()+" \n Gender = "+(String)genderfield.getSelectedItem()+" \n Phone Number ="+phonenumberfield.getText()+" \n Emergency Contact Number = "+emergencynumberfield.getText()+" \n Emergency Contact Name = "+emergencynamefield.getText()+" \n Relationship With Emergency = "+emergencyrelationshipfield.getText()+"", "Confirmation Of Update", JOptionPane.YES_NO_OPTION)== 0) {
					try {
						search.connection = SqlitePatientConnection.dbConnector();
						String query = "update patients set firstname='"+firstnamefield.getText()+"',lastname='"+lastnamefield.getText()+"',Residence='"+residencefield.getText()+"',date_of_birth='"+dateofbirthfield.getText()+"',sex='"+(String)genderfield.getSelectedItem()+"',phone_number='"+phonenumberfield.getText()+"',Emergency_contact='"+emergencynumberfield.getText()+"',Emergency_contact_name='"+emergencynamefield.getText()+"',Relation_with_emergency_contact='"+emergencyrelationshipfield.getText()+"' where patient_id= "+search.getPatientID();
						PreparedStatement pst = search.connection.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Patient Data Updated Successfully");
						pst.close();
					}catch(Exception ec) {
						ec.printStackTrace();
					}
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);  
					  win.dispose();    //dispose off this frame
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(128, 409, 206, 35);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(623, 10, 6, 502);
		contentPane.add(separator);
		
		search.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					search.connection = SqlitePatientConnection.dbConnector();
					int row = search.table.getSelectedRow();
					search.setPatientID((int)search.table.getModel().getValueAt(row, 0));
					String query = "select firstname, lastname, Residence, date_of_birth, sex, phone_number, Emergency_contact, Emergency_contact_name, Relation_with_emergency_contact from patients where patient_id = "+search.getPatientID();
					PreparedStatement pst = search.connection.prepareStatement(query);
					ResultSet rst = pst.executeQuery();
					
					while(rst.next()) {
						firstnamefield.setText(rst.getString("firstname"));
						lastnamefield.setText(rst.getString("lastname"));
						residencefield.setText(rst.getString("Residence"));
						dateofbirthfield.setText(rst.getString("date_of_birth"));
						String gender = rst.getString("sex");
						genderfield.setModel(new DefaultComboBoxModel(new String[] {gender, "Male", "Female", "Prefer not to say"}));
						phonenumberfield.setText(rst.getString("phone_number"));
						emergencynumberfield.setText(rst.getString("Emergency_contact"));
						emergencynamefield.setText(rst.getString("Emergency_contact_name"));
						emergencyrelationshipfield.setText(rst.getString("Relation_with_emergency_contact"));
					}
					rst.close();
					pst.close();
					
				}catch(Exception et) {
					et.printStackTrace();
				}
			}
		});
		
	}
}
