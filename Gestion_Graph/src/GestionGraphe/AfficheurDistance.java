package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AfficheurDistance extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mat m=null;
					AfficheurDistance frame = new AfficheurDistance(m);
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
	public AfficheurDistance(Mat m) {
		JTable g=DessinnerOrieterSommet.Data(Integer.valueOf(m.m[0][0]),m.m);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(225, 10, 436, 205);
		contentPane.add(table);
		table.setModel(g.getModel());
		
		JLabel lblNewLabel = new JLabel("Distance");
		lblNewLabel.setBounds(40, 21, 51, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRetour.setBounds(40, 225, 85, 21);
		contentPane.add(btnRetour);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  // save to file
				  StringBuilder data=new StringBuilder();
				  for(int i=0;i<=m.m[0][0];i++)
				  {
					  for(int j=0;j<m.m[0][0];j++)
					  {
					  data.append(m.m[i][j]+" ");
					  }
					  data.append(m.m[i][m.m[0][0]]+"\n");
				  }
				  
				  FileWriter fw;
				try {
					fw = new FileWriter(file.getAbsoluteFile());
					 BufferedWriter bw = new BufferedWriter(fw);
					   bw.write(data.toString());
					   bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				}
			}
		});
		btnEnregistrer.setBounds(535, 225, 126, 21);
		contentPane.add(btnEnregistrer);
	}
}
