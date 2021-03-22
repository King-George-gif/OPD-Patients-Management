package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderLabForPatient extends Search {

	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4;
	private JEditorPane editorPane;
	private int folder_id = -1;
	private int PID = -1;

	/**
	 * Launch the application.
	 */

	
	public void PopulateFirstNameandLastNameField() {
		try {
			connection = SqlitePatientConnection.dbConnector();
			int row = table.getSelectedRow();
			PID = (int)table.getModel().getValueAt(row, 0);
			String query = "select firstname,lastname from patients where patient_id = "+PID;
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				lblNewLabel_4.setText(rst.getString("firstname") + " "+ rst.getString("lastname"));
			}
			rst.close();
			pst.close();
			
		}catch(Exception et) {
			et.printStackTrace();
		}
	}
	
	public String TodaysDate() {
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+ 1;
		int year = cal.get(Calendar.YEAR);
		return ""+day+"-"+month+"-"+year;
	}
	
	public int getFolderID() {
		PreparedStatement pst = null;
		ResultSet rst = null;
		int folder_id = -1;
		try {
		int row = table.getSelectedRow();
		int PID = (int)table.getModel().getValueAt(row, 0);
		String firstname = (String)table.getModel().getValueAt(row, 1);
		String lastname = (String)table.getModel().getValueAt(row, 2);
		if(JOptionPane.showConfirmDialog(null,"Add Labs To Patient With \n First Name = "+firstname+" \n and Last Name = "+lastname+" ","Vitals Information Edit Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
			connection = SqlitePatientConnection.dbConnector();
			String query = "select folder_id from patients_folder where patient="+PID;
			pst = connection.prepareStatement(query);
			rst = pst.executeQuery();
			while(rst.next()) {
				folder_id = rst.getInt("folder_id");	
			}
			pst.close();
			rst.close();			
		}
		return folder_id;
		
		}catch(Exception ee) {
			JOptionPane.showMessageDialog(null, "There is a Problem. Please try Again Later");
			ee.printStackTrace();
			return -1;
		}
	}
	
	public void addLabToPatientFile() {
		try {
			connection = SqlitePatientConnection.dbConnector();
			String query1 = "update folder_files set prescribed_drugs='"+editorPane.getText()+"' where folderID= "+folder_id +" and date_created='"+TodaysDate()+"'";
			PreparedStatement pstm = connection.prepareStatement(query1);
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Labs has been successfully added to Patient File");
			pstm.close();
			
		}catch(Exception ef) {
			JOptionPane.showMessageDialog(null, "There was a problem adding Labs to Patient's File.\n Please Try Again Or Contact Adminstrator for help");
			ef.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public OrderLabForPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(this.panel);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(623, 10, 6, 502);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("ORDER LAB(S) FOR PATIENT IN THE TEXT EDITOR BELOW");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(639, 54, 422, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ORDER LABS SECTION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(710, 10, 285, 44);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Search For Patient Name In The Left Pane Before Ordering The Labs");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(639, 84, 422, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Patient Name ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(639, 120, 111, 25);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(780, 120, 229, 25);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(639, 172, 435, 278);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JButton btnNewButton = new JButton("ADD LAB(S) TO PATIENT FILE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblNewLabel_4.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Search And Select For Patient In The Left Pane First.");
				}else {
					folder_id = getFolderID();
					addLabToPatientFile();
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);  
					  win.dispose();    //dispose off this frame
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(744, 474, 212, 38);
		contentPane.add(btnNewButton);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateFirstNameandLastNameField();
			}
		});
		
		
	}
}
