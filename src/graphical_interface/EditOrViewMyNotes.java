package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;

public class EditOrViewMyNotes extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JEditorPane editorPane;
	JPanel panel;
	Search search = new Search();


	
	public void PopulateFirstAndLastName() {
		int row = search.table.getSelectedRow();
		search.setPatientID((int)search.table.getModel().getValueAt(row, 0));
		search.setFirstName((String)search.table.getModel().getValueAt(row, 1));
		search.setLastName((String)search.table.getModel().getValueAt(row, 2));
		lblNewLabel_4.setText(search.getFirstName()+" "+search.getLastName());
	}
	
	
	public void DoTheMainWork() {
			search.SetTheFolderID();
			showNotes();
		
		
	}
	
	public void showNotes() {
		String notes = "VITALS";
		try {
			search.connection = SqlitePatientConnection.dbConnector();
			String query1 = "select Diagnosis_information, labs_ordered, vitals_information, prescribed_drugs, lab_results from folder_files where folderID= "+search.getFolderID()+" and date_created='"+search.TodaysDate()+"'";
			PreparedStatement pstm = search.connection.prepareStatement(query1);
			ResultSet rstt = pstm.executeQuery();
			while(rstt.next()) {
				notes += rstt.getString("vitals_information");
				notes += "\n\n DIAGNOSIS INFORMATION \n ";
				notes += rstt.getString("Diagnosis_information");
				notes += "\n\n LABS ORDERED \n ";
				notes += rstt.getString("labs_ordered");
				notes += "\n\n LAB RESULTS \n ";
				notes += rstt.getString("lab_results");
				notes += "\n\n DRUGS PRESCRIBED \n ";
				notes += rstt.getString("prescribed_drugs");
			}
			editorPane.setText(notes);
			rstt.close();
			pstm.close();
			
		}catch(Exception ef) {
			JOptionPane.showMessageDialog(null, "There was a problem adding Diagnosis to Patient's File");
			ef.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	
	
	public EditOrViewMyNotes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = search.panel;
		panel.setBounds(10, 11, 613, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(623, 10, 6, 502);
		contentPane.add(separator);
		
		
		lblNewLabel = new JLabel("VIEW PATIENT FILE NOTES FOR THE DAY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(639, 54, 422, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("PATIENT FILE NOTES");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(710, 10, 285, 44);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Search And Select Name In The Left Pane To View Patient File For Today");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		scrollPane.setBounds(639, 169, 431, 380);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		search.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateFirstAndLastName();
				search.SetTheFolderID();
				search.getTheDateCreated();
				if(!search.getdate_created().equals(search.TodaysDate())) {
					JOptionPane.showMessageDialog(null, "File has not been created for the Patient Today.\nContact the Receptionist on duty.");
				}
				else {
					DoTheMainWork();
				}
				
			}
		});
	}

}
