package graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import staff_classes.DoctorClass;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Doctor extends JFrame {

	private JPanel contentPane;
	private DoctorClass doctor;


	public Doctor(DoctorClass doctor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		this.doctor = doctor;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 814, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Doctor "+doctor.getFirstName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 239, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log Out");
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
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
					Login login = new Login();
					login.frmLoginToApplication.setVisible(true);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(715, 11, 89, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit Profile");
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
				ChangeLoginDetails frame = new ChangeLoginDetails();
				frame.setTitle("Existing/Old Details");
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(601, 12, 108, 30);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(157, 93, 510, 423);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("ADD DIAGNOSIS NOTE TO PATIENT FILE");
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
				AddDiagnosisToPatientFile frame = new AddDiagnosisToPatientFile();
				frame.setTitle("Patients Diagnosis");
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(41, 23, 387, 42);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ORDER/REQUEST LAB(S) FOR PATIENT");
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
				OrderLabForPatient frame = new OrderLabForPatient();
				frame.setTitle("Order Labs For Patients");
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(41, 90, 387, 42);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PRESCRIBE DRUGS FOR PATIENT");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PrescribeDrugsForPatient frame = new PrescribeDrugsForPatient();
				frame.setTitle("Prescribe Drugs For Patients");
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(0, 128, 128));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(41, 155, 387, 42);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("VIEW PATIENT FILE FOR TODAY");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_6.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setBackground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				EditOrViewMyNotes frame = new EditOrViewMyNotes();
				frame.setTitle("Patient File Summary");
				frame.setVisible(true);
			}
		});
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(0, 128, 128));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_6.setBounds(41, 224, 387, 41);
		panel_2.add(btnNewButton_6);
	}
}
