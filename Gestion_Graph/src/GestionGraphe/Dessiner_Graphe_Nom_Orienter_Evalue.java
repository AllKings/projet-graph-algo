package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dessiner_Graphe_Nom_Orienter_Evalue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dessiner_Graphe_Nom_Orienter_Evalue frame = new Dessiner_Graphe_Nom_Orienter_Evalue();
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
	public Dessiner_Graphe_Nom_Orienter_Evalue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(317, 160, 187, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Nombre Sommet");
		lblNewLabel.setBounds(81, 166, 95, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.setBounds(76, 224, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Matrice (saisir)");
		btnNewButton_2.setBounds(317, 224, 187, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Matrice (importer Fichier)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(76, 86, 421, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("FsAps (importer Fichier)");
		btnNewButton.setBounds(76, 39, 421, 21);
		contentPane.add(btnNewButton);
	}
}
