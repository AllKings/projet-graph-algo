package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Dialogue_Dessinner_Graphe_Orienter_Evalue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogue_Dessinner_Graphe_Orienter_Evalue frame = new Dialogue_Dessinner_Graphe_Orienter_Evalue();
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
	public Dialogue_Dessinner_Graphe_Orienter_Evalue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("FsAps (importer Fichier)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				int reponse=file.showOpenDialog(null);
				if(reponse==JFileChooser.APPROVE_OPTION)
				{
					String nomFicher=file.getSelectedFile().getAbsolutePath();
					Grphe_Orienter_Non_Evalue g1=new Grphe_Orienter_Non_Evalue(nomFicher);
					Mat m= g1.Tomatrice();
					int NombreSommet=m.m[0][0];
					Dessinner_Graphe_Orienter_Evalue f=new Dessinner_Graphe_Orienter_Evalue(NombreSommet,m.m);
					f.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(55, 99, 421, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Matrice (importer Fichier)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				int reponse=file.showOpenDialog(null);
				if(reponse==JFileChooser.APPROVE_OPTION)
				{
					String nomFicher=file.getSelectedFile().getAbsolutePath();
					Mat m=Graphe.MatriceFromFichier(nomFicher);
					int NombreSommet=m.m[0][0];
					Dessinner_Graphe_Orienter_Evalue f=new Dessinner_Graphe_Orienter_Evalue(NombreSommet,m.m);
					f.setVisible(true);
					
				}
			}
		});
		btnNewButton_1.setBounds(55, 171, 421, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Matrice (saisir)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int g=Integer.valueOf(textField.getText());
				Dessinner_Graphe_Orienter_Evalue frame = new Dessinner_Graphe_Orienter_Evalue(g);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(296, 309, 187, 21);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(296, 245, 187, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Sommet");
		lblNewLabel.setBounds(60, 251, 95, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(55, 309, 85, 21);
		contentPane.add(btnNewButton_3);
	}
}
