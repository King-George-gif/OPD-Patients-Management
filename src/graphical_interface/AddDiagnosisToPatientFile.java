package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;

public class AddDiagnosisToPatientFile extends Search2 {

	private JPanel contentPane;
	private JEditorPane editorPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */

	public void DoTheMainWork() {
		SetTheFolderID();
		addDiagnosisNoteToPatientFile();
	}

	
	
	public void addDiagnosisNoteToPatientFile() {
		try {
			connection = SqlitePatientConnection.dbConnector();
			String query1 = "update folder_files set Diagnosis_information='"+editorPane.getText()+"' where folderID= "+this.getFolderID() +" and date_created='"+this.TodaysDate()+"'";
			PreparedStatement pstm = connection.prepareStatement(query1);
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Diagnosis has been successfully added to Patient File");
			pstm.close();
			
		}catch(Exception ef) {
			JOptionPane.showMessageDialog(null, "There was a problem adding Diagnosis to Patient's File");
			ef.printStackTrace();
		}
	}
	
	public void PopulateFirstAndLastName() {
		
		int row = table.getSelectedRow();
		this.setPatientID((int)table.getModel().getValueAt(row, 0));
		this.setFirstName((String)table.getModel().getValueAt(row, 1));
		this.setLastName((String)table.getModel().getValueAt(row, 2));
		lblNewLabel_4.setText(this.getFirstName()+" "+this.getLastName());		
	}

	/**
	 * Create the frame.
	 */
	public AddDiagnosisToPatientFile() {
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(639, 158, 422, 324);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNewLabel = new JLabel("ADD PATIENT DIAGNOSIS NOTES IN THE EDITOR TEXT BELOW");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(639, 54, 422, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("DIAGNOSIS NOTES SECTION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(710, 10, 285, 44);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("ADD NOTES TO PATIENT'S FILE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblNewLabel_4.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Search And Select For Patient In The Left Pane.");
				}else {
					DoTheMainWork();
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);  
					  win.dispose();    //dispose off this frame
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(757, 493, 238, 44);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Search For Patient Name In The Left Pane Before Adding The Notes");
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
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateFirstAndLastName();
			}
		});
		
		
	}

}
