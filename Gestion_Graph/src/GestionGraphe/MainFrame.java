package GestionGraphe;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	public void name() {
		
	} JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Graphe Orienter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialogue_Dessinner_Graphe_Orienter_Evalue frame1 = new Dialogue_Dessinner_Graphe_Orienter_Evalue();
				frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(128, 135, 445, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGrapheNonOrienter = new JButton("Graphe non Orienter");
		btnGrapheNonOrienter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialogue_Graphe_Nom_Orienter_Evalue frame1 = new Dialogue_Graphe_Nom_Orienter_Evalue();
				frame1.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnGrapheNonOrienter.setBounds(128, 186, 445, 21);
		frame.getContentPane().add(btnGrapheNonOrienter);
		
		JButton btnNewButton_1_1 = new JButton("Taches");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TachesGeation frame1 = new TachesGeation();
				frame1.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(128, 249, 445, 21);
		frame.getContentPane().add(btnNewButton_1_1);
		
	}
	
}
