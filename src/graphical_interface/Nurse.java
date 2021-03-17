package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import staff_classes.NurseClass;

import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Nurse extends JFrame {

	private JPanel contentPane;
	private NurseClass nurse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					Nurse frame = new Nurse();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nurse(NurseClass nurse) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_1 = new JLabel("Nurse "+this.nurse.getLastName());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 142, 31);
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
		});
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(605, 11, 104, 31);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 89, 223, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Set Availability");
		tglbtnNewToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnNewToggleButton.isSelected()) {
					tglbtnNewToggleButton.setBackground(new Color(0, 128, 128));
					tglbtnNewToggleButton.setText("Set Unavailability");
				}
				else {
					tglbtnNewToggleButton.setBackground(new Color(0, 206, 209));
					tglbtnNewToggleButton.setText("Set Availability");
				}
			}
		});

		tglbtnNewToggleButton.setForeground(Color.WHITE);
		tglbtnNewToggleButton.setBackground(new Color(0, 206, 209));
		tglbtnNewToggleButton.setBorder(null);
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(33, 23, 155, 32);
		panel_1.add(tglbtnNewToggleButton);
		
		JLabel lblNewLabel = new JLabel("Available Doctors");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 81, 155, 32);
		panel_1.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(33, 135, 155, 231);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(284, 89, 474, 400);
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
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(43, 115, 376, 44);
		panel_2.add(btnNewButton_1);
	}
}
