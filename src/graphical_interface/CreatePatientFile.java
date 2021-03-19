package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

public class CreatePatientFile extends Search {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePatientFile frame = new CreatePatientFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	
	public String TodaysDate() {
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+ 1;
		int year = cal.get(Calendar.YEAR);
		return ""+day+"-"+month+"-"+year;
	}
	
	
	public CreatePatientFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(this.panel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement pst = null;
				ResultSet rst = null;
				int folder_id = -1;
				try {
				int row = table.getSelectedRow();
				int PID = (int)table.getModel().getValueAt(row, 0);
				String firstname = (String)table.getModel().getValueAt(row, 1);
				String lastname = (String)table.getModel().getValueAt(row, 2);
				if(JOptionPane.showConfirmDialog(null,"Create File For Patient with \n First Name = "+firstname+" \n and Last Name = "+lastname+" ","Confirm File Creation", JOptionPane.YES_NO_OPTION)== 0) {
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
				
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "File Creation Unsuccessfull. Please try Again Later");
					ee.printStackTrace();
				}
				
				
				try {
					connection = SqlitePatientConnection.dbConnector();
					String query1 = "insert into folder_files (file_id, date_created, vitals_information, Diagnosis_information, prescribed_drugs, labs_ordered, lab_results, folderID) values (NULL, ?,?,?,?,?,?,?) ";
					PreparedStatement pstm = connection.prepareStatement(query1);
					pstm.setString(1, TodaysDate());
					pstm.setString(2, "");
					pstm.setString(3, "");
					pstm.setString(4, "");
					pstm.setString(5, "");
					pstm.setString(6, "");
					pstm.setInt(7, folder_id);
					
					pstm.execute();
					JOptionPane.showMessageDialog(null, "File Was Successfully Created For Patient");
					pstm.close();
					
				}catch(Exception ef) {
					JOptionPane.showMessageDialog(null, "File Creation Unsuccessfull. Please try Again Later");
					ef.printStackTrace();
				}
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);  
				  win.dispose();    //dispose off this frame
			}
		});
	}

}
