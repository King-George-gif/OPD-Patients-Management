package graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import staff_classes.NurseClass;

public class Nurse extends JFrame {

	private JPanel contentPane;
	private NurseClass nurse;


	/**
	 * Create the frame.
	 */
	public Nurse(NurseClass nurse) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.nurse = nurse;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 818, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Nurse "+this.nurse.getLastName());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 223, 31);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
					Login login = new Login();
					login.frmLoginToApplication.setVisible(true);
				}
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(719, 11, 89, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Profile");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangeLoginDetails frame = new ChangeLoginDetails();
				frame.setTitle("Existing/Old Details");
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(605, 11, 104, 31);
		panel.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(160, 87, 474, 400);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD VITALS INFORMATION TO PATIENTS FILE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddVitalsToPatientFile frame = new AddVitalsToPatientFile();
				frame.setTitle("Add Patients Vitals Here");
				frame.setVisible(true);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(43, 48, 376, 44);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT PATIENTS VITALS INFORMATION");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				EditPatientVitalsInfo frame = new EditPatientVitalsInfo();
				frame.setTitle("Edit Patient Vitals");
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(43, 115, 376, 44);
		panel_2.add(btnNewButton_1);
	}
}
