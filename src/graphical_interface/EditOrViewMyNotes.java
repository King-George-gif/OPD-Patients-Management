package graphical_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EditOrViewMyNotes extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	Search search = new Search();

	/**
	 * Launch the application.
	 *
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditOrViewMyNotes frame = new EditOrViewMyNotes();
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
	
	
	public EditOrViewMyNotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = search.panel;
		panel.setBounds(10, 11, 613, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(635, 77, 89, 23);
		panel.add(btnNewButton);
	}

}
