package graphical_interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JEditorPane;
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

public class PrescribeDrugsForPatient extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JEditorPane editorPane;
	JPanel panel;
	Search search = new Search();
	

	public void DoTheMainWork() {
		if(JOptionPane.showConfirmDialog(null,"Add Drugs to Patient with \n First Name = "+search.getFirstName()+" \n and Last Name = "+search.getLastName()+" ","Vitals Information Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
			search.SetTheFolderID();
			addDrugsToPatientFile();
		}
		
	}
	
	public void PopulateFirstAndLastName() {
		int row = search.table.getSelectedRow();
		search.setPatientID((int)search.table.getModel().getValueAt(row, 0));
		search.setFirstName((String)search.table.getModel().getValueAt(row, 1));
		search.setLastName((String)search.table.getModel().getValueAt(row, 2));
		lblNewLabel_4.setText(search.getFirstName()+" "+search.getLastName());
	}
	
	
	
	public void addDrugsToPatientFile() {
		try {
			search.connection = SqlitePatientConnection.dbConnector();
			String query1 = "update folder_files set prescribed_drugs='"+editorPane.getText()+"' where folderID= "+search.getFolderID()+" and date_created='"+search.TodaysDate()+"'";
			PreparedStatement pstm = search.connection.prepareStatement(query1);
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Drugs has been successfully added to Patient File");
			pstm.close();
			
		}catch(Exception ef) {
			JOptionPane.showMessageDialog(null, "There was a problem adding Diagnosis to Patient's File");
			ef.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PrescribeDrugsForPatient() {
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
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(623, 10, 6, 502);
		contentPane.add(separator);
		
		
		lblNewLabel = new JLabel("ADD DRUG PRESCRIPTION NOTES IN THE EDITOR TEXT BELOW");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(639, 54, 422, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("DRUGS PRESCRIPTION SECTION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(710, 10, 285, 44);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Search For Patient Name In The Left Pane Before Adding The Drugs");
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
		scrollPane.setBounds(639, 169, 431, 329);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		btnNewButton = new JButton("ADD DRUGS TO PATIENT FILE");
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(762, 509, 214, 41);
		contentPane.add(btnNewButton);
		
		search.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateFirstAndLastName();
			}
		});
	}
}
