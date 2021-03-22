package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

  abstract class Search2 extends JFrame {

	private JPanel contentPane;
	public JTextField firstnamefiltertext;
	private JTextField lastnamefiltertext;
	private JTextField dateofbirthfiltertext;
	private JTextField phonenumberfiltertext;
	JTable table;
	JLabel lblNewLabel;
	JCheckBox firstnamefilter;
	JCheckBox lastnamefilter;
	JCheckBox dateofbirthfilter;
	JCheckBox genderfilter;
	JCheckBox phonenumberfilter;
	JComboBox genderfiltertext;
	JSeparator separator;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JScrollPane scrollPane;
	JPanel panel;
	private JButton btnNewButton;
	Connection connection = null;
	private int folder_id = -1;
	private int PID = -1;
	private String firstname;
	private String lastname;
	private JButton btnNewButton_1;


	
	public ResultSet SearchResults(String field, String value) {
		try {
		String query = "select patient_id as 'Patient ID', firstname as 'First Name', lastname as 'Surname', Residence, date_of_birth as 'Date Of Birth', sex as 'Gender' from patients where "+field+" =?";
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, value);
		ResultSet rst = pst.executeQuery();
		return rst;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}
	
	public void setFolderID(int folder_id) {
		this.folder_id = folder_id;
	}
	
	public int getFolderID() {
		return this.folder_id;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public void setPatientID(int patient_id) {
		this.PID = patient_id;
	}
	
	public int getPatientID() {
		return this.PID;
	}
	
	abstract void DoTheMainWork();
	
	public String TodaysDate() {
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+ 1;
		int year = cal.get(Calendar.YEAR);
		return ""+day+"-"+month+"-"+year;
	}
	

	/**
	 * Create the frame.
	 */
	public Search2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 613, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Search For Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(183, 11, 144, 30);
		panel.add(lblNewLabel);
		
		firstnamefilter = new JCheckBox("FirstName:");
		firstnamefilter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnamefilter.setBounds(10, 78, 114, 23);
		panel.add(firstnamefilter);
		
		lastnamefilter = new JCheckBox("LastName");
		lastnamefilter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastnamefilter.setBounds(10, 104, 114, 23);
		panel.add(lastnamefilter);
		
		dateofbirthfilter = new JCheckBox("Date Of Birth:");
		dateofbirthfilter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateofbirthfilter.setBounds(10, 130, 114, 23);
		panel.add(dateofbirthfilter);
		
		genderfilter = new JCheckBox("Gender:");
		genderfilter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		genderfilter.setBounds(10, 156, 97, 23);
		panel.add(genderfilter);
		
		phonenumberfilter = new JCheckBox("Phone Number:");
		phonenumberfilter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phonenumberfilter.setBounds(10, 182, 114, 23);
		panel.add(phonenumberfilter);
		
		lblNewLabel_1 = new JLabel("Filter Search By: Check any one of the fields and provide the value accordingly");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 52, 518, 19);
		panel.add(lblNewLabel_1);
		
		firstnamefiltertext = new JTextField();
		firstnamefiltertext.setBounds(145, 80, 134, 20);
		panel.add(firstnamefiltertext);
		firstnamefiltertext.setColumns(10);
		
		lastnamefiltertext = new JTextField();
		lastnamefiltertext.setBounds(145, 106, 134, 20);
		panel.add(lastnamefiltertext);
		lastnamefiltertext.setColumns(10);
		
		dateofbirthfiltertext = new JTextField();
		dateofbirthfiltertext.setBounds(145, 132, 134, 20);
		panel.add(dateofbirthfiltertext);
		dateofbirthfiltertext.setColumns(10);
		
		genderfiltertext = new JComboBox();
		genderfiltertext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		genderfiltertext.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Prefer not to say"}));
		genderfiltertext.setBounds(145, 157, 134, 22);
		panel.add(genderfiltertext);
		
		phonenumberfiltertext = new JTextField();
		phonenumberfiltertext.setBounds(145, 184, 134, 20);
		panel.add(phonenumberfiltertext);
		phonenumberfiltertext.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 246, 593, 9);
		panel.add(separator);
		
		lblNewLabel_2 = new JLabel("Search Results:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 266, 97, 30);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Select The Patient You are Searching For By Clicking on Patient Row in the table below");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 307, 511, 23);
		panel.add(lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 341, 557, 167);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connection = SqlitePatientConnection.dbConnector();
				if(!firstnamefilter.isSelected() && !lastnamefilter.isSelected() && !dateofbirthfilter.isSelected() && !genderfilter.isSelected() && !phonenumberfilter.isSelected() ) {
					JOptionPane.showMessageDialog(null, "	!!!ERROR \nOne Of The Select Boxes Must Be Selected");
				}
				else if(firstnamefilter.isSelected()) {
					table.setModel(DbUtils.resultSetToTableModel(SearchResults("firstname", firstnamefiltertext.getText())));
					
				}
				else if(lastnamefilter.isSelected()) {
					table.setModel(DbUtils.resultSetToTableModel(SearchResults("lastname", lastnamefiltertext.getText())));
				}
				else if(dateofbirthfilter.isSelected()) {
					table.setModel(DbUtils.resultSetToTableModel(SearchResults("date_of_birth", dateofbirthfiltertext.getText())));
				}
				else if(genderfilter.isSelected()) {
					if((String)genderfiltertext.getSelectedItem() == "Select Gender") {
						JOptionPane.showMessageDialog(null, "!!!ERROR \n Please Select Gender Of Patient");
					}
					else {							
					table.setModel(DbUtils.resultSetToTableModel(SearchResults("sex", (String)genderfiltertext.getSelectedItem())));
					}
				}
				else if(phonenumberfilter.isSelected()) {
					table.setModel(DbUtils.resultSetToTableModel(SearchResults("phone_number", phonenumberfiltertext.getText())));
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 212, 89, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);  
				  win.dispose();    //dispose off this frame
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(10, 12, 79, 30);
		panel.add(btnNewButton_1);
		
		
	}
}
