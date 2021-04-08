package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialogue_Graphe_Orienter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogue_Graphe_Orienter frame = new Dialogue_Graphe_Orienter();
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
	public Dialogue_Graphe_Orienter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(89, 45, 146, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Graphe \u00E9valu\u00E9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialogue_Dessinner_Graphe_Orienter_Evalue frame1 = new Dialogue_Dessinner_Graphe_Orienter_Evalue();
				frame1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(89, 86, 146, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Graphe non \u00E9valu\u00E9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dialogue_Dessinner_Graphe_Orienter_Nom_Evalue frame1 = new Dialogue_Dessinner_Graphe_Orienter_Nom_Evalue();
				frame1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(89, 130, 146, 21);
		contentPane.add(btnNewButton_2);
	}

}
