package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialogue_Graphe_Nom_Orienter_Evalue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogue_Graphe_Nom_Orienter_Evalue frame = new Dialogue_Graphe_Nom_Orienter_Evalue();
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
	public Dialogue_Graphe_Nom_Orienter_Evalue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(91, 33, 146, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Graphe \u00E9valu\u00E9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dessinner_Graphe_Nom_Orienter_Nom_Evalue frame1 = new Dessinner_Graphe_Nom_Orienter_Nom_Evalue(5);
				frame1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(91, 74, 146, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Arbre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dessinner_Arbre frame1 = new Dessinner_Arbre();
				frame1.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(91, 118, 146, 21);
		contentPane.add(btnNewButton_2);
	}
	
}
