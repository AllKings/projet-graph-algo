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

public class AfficheurFsAps extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int []fs=new int[1];
					int []aps=new int[1];
					AfficheurFsAps frame = new AfficheurFsAps(fs,aps);
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
	public AfficheurFsAps(int []fs,int []aps) {
		int NombreSommet=aps[0];
		int TailleFs=fs[0];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTable g=new JTable(1,TailleFs+1);
		for(int i=0;i<=TailleFs;i++)
		{
			g.setValueAt(fs[i], 0, i);
		}
		JTable g1=new JTable(1,NombreSommet+1);
		for(int i=0;i<=NombreSommet;i++)
		{
			g1.setValueAt(aps[i], 0, i);
		}
		table = new JTable();
		table.setBounds(38, 62, 602, 37);
		contentPane.add(table);
		table.setModel(g.getModel());
		JLabel lblNewLabel = new JLabel("File des successeurs");
		lblNewLabel.setBounds(263, 39, 128, 13);
		contentPane.add(lblNewLabel);
		
		table_1 = new JTable();
		table_1.setBounds(38, 159, 602, 24);
		contentPane.add(table_1);
		table_1.setModel(g1.getModel());
		JLabel lblNewLabel_1 = new JLabel("APS");
		lblNewLabel_1.setBounds(288, 136, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  // save to file
				  StringBuilder data=new StringBuilder();
				  for(int i=0;i<fs[0];i++)
				  {
					  data.append(fs[i]+" ");
				  }
				  data.append(fs[fs[0]]+"\n");
				  for(int i=0;i<aps[0];i++)
				  {
					  data.append(aps[i]+" ");
				  }
				  data.append(aps[aps[0]]);
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
		btnNewButton.setBounds(518, 236, 122, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(38, 236, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
