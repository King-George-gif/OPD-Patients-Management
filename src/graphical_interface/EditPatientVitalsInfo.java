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

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import database_management.SqlitePatientConnection;

public class EditPatientVitalsInfo extends JFrame {

	private JPanel contentPane;
	private JLabel firstnamefield;
	private JLabel lastnamefield;
	private JEditorPane editorPane;
	JPanel panel;
	Search search = new Search();


	
	public void DoTheMainWork() {
		if(JOptionPane.showConfirmDialog(null,"Edit Vitals For Patient with \n First Name = "+search.getFirstName()+" \n and Last Name = "+search.getLastName()+" ","Vitals Information Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
			PreparedStatement pstm = null;
			try {
				search.connection = SqlitePatientConnection.dbConnector();
				String query1 = "update folder_files set vitals_information='"+editorPane.getText()+"' where folderID="+search.getFolderID()+" and date_created ='"+search.TodaysDate()+"'";
				pstm = search.connection.prepareStatement(query1);
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Patient's Vitals has successfully been edited");
				
				pstm.close();
			}catch(Exception ef) {
				JOptionPane.showMessageDialog(null, "There was a problem editing Patient'st vitals.");
				ef.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public String getVitalsInfo() {
		PreparedStatement pstm = null;
		ResultSet rstt = null;
		String vitals_information = "";
		try {
			search.connection = SqlitePatientConnection.dbConnector();
			String query1 = "select vitals_information from folder_files where folderID= "+search.getFolderID() +" and date_created='"+search.TodaysDate()+"'";
			pstm = search.connection.prepareStatement(query1);
			rstt = pstm.executeQuery();
			while(rstt.next()) {
				vitals_information = rstt.getString("vitals_information");
			}
			
			pstm.close();
			rstt.close();
			return vitals_information;
		}catch(Exception ef) {
			JOptionPane.showMessageDialog(null, "There was a problem adding vitals to Patient's File");
			ef.printStackTrace();
			return null;
		}
	}

	
	public void PopulateFirstAndLastName() {	
		int row = search.table.getSelectedRow();
		search.setPatientID((int)search.table.getModel().getValueAt(row, 0));
		this.firstnamefield.setText((String)search.table.getModel().getValueAt(row, 1));
		this.lastnamefield.setText((String)search.table.getModel().getValueAt(row, 2));
		search.setFirstName((String)search.table.getModel().getValueAt(row, 1));
		search.setLastName((String)search.table.getModel().getValueAt(row, 2));
	}
	

	/**
	 * Create the frame.
	 */
	public EditPatientVitalsInfo() {
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
		
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		editorPane.setBounds(639, 158, 422, 297);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel = new JLabel("Before Making Any Edit To The Patient File ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(639, 51, 422, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Search and Select The Patient in the Left Pane");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(639, 10, 422, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Edit Patient Vitals Info");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(firstnamefield.getText().isBlank() && lastnamefield.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Search And Select Patient in the Left Pane Before You Can Edit Vitals");
				}else {
					DoTheMainWork();
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);  
					  win.dispose();    //dispose off this frame
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(723, 466, 216, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Patient First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(639, 92, 131, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patient Last Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(639, 124, 131, 23);
		contentPane.add(lblNewLabel_3);
		
		firstnamefield = new JLabel("");
		firstnamefield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstnamefield.setBounds(800, 92, 123, 19);
		contentPane.add(firstnamefield);
		
		lastnamefield = new JLabel("");
		lastnamefield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastnamefield.setBounds(780, 124, 143, 20);
		contentPane.add(lastnamefield);
		
		search.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopulateFirstAndLastName();
				search.SetTheFolderID();
				editorPane.setText(getVitalsInfo());
			}
		});

	}

}
