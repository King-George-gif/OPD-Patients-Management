package graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receptionist extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist frame = new Receptionist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Receptionist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 814, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello Receptionist");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 9, 145, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Log Out");
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setBounds(730, 12, 74, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit My Profile");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(0, 128, 128));
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(0, 128, 128));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(603, 12, 117, 23);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 69, 245, 461);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Set Availability");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnNewToggleButton.isSelected()) {
					tglbtnNewToggleButton.setText("Set Unavailability");
				}
				else {
					tglbtnNewToggleButton.setText("Set Availability");
				}
			}
		});
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(31, 11, 157, 29);
		panel_1.add(tglbtnNewToggleButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nurses Available");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 74, 167, 29);
		panel_1.add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(31, 114, 167, 295);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(309, 69, 441, 461);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("EDIT PATIENTS PROFILE");
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
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(44, 144, 344, 42);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER NEW PATIENTS");
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
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(44, 38, 344, 42);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CREATE NEW FILE FOR PATIENTS");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(0, 206, 209));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(0, 128, 128));
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(44, 91, 344, 42);
		panel_2.add(btnNewButton_2);
	}
}
