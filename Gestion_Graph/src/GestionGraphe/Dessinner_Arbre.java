package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dessinner_Arbre extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dessinner_Arbre frame = new Dessinner_Arbre();
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
	public Dessinner_Arbre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(237, 10, 396, 221);
		contentPane.add(table);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(120, 26, 85, 21);
		contentPane.add(btnEnregistrer);
		
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.setBounds(10, 26, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnPrrufer = new JButton("Prrufer");
		btnPrrufer.setBounds(10, 68, 85, 21);
		contentPane.add(btnPrrufer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRetour.setBounds(10, 275, 85, 21);
		contentPane.add(btnRetour);
	}
}
