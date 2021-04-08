package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Dessinner_Graphe_Nom_Orienter_Nom_Evalue extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dessinner_Graphe_Nom_Orienter_Nom_Evalue frame = new Dessinner_Graphe_Nom_Orienter_Nom_Evalue(5);
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
	public Dessinner_Graphe_Nom_Orienter_Nom_Evalue(int NommbreSommet) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		table = new JTable();
		table.setBounds(237, 10, 396, 221);
		contentPane.add(table);
		JTable g=new JTable(NommbreSommet+1,NommbreSommet+1);
		for(int i=1;i<=NommbreSommet;i++)
		{
			
			for(int j=1;j<=NommbreSommet;j++)
			{
				g.setValueAt(0, i, j);
			}
		}
		for(int j=1;j<=NommbreSommet;j++)
		{
			g.setValueAt(j, 0, j);
			g.setValueAt(j, j, 0);
		}
		table.setModel(g.getModel());
		
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 26, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Distance");
		btnNewButton_1_1.setBounds(120, 66, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("FsAps");
		btnNewButton_1_1_1.setBounds(10, 66, 85, 21);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnKruskal = new JButton("Kruskal");
		btnKruskal.setBounds(120, 107, 85, 21);
		contentPane.add(btnKruskal);
		
		JButton btnDantzig = new JButton("Tarjan");
		btnDantzig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDantzig.setBounds(10, 107, 85, 21);
		contentPane.add(btnDantzig);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NommbreSommet,NommbreSommet);
				for(int i=1;i<=NommbreSommet;i++)
				{
					for(int j=1;j<=NommbreSommet;j++)
					{
						m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
						if(m.m[i][j]>0)
						{
							nb+=1;
						}
					}
				}
				for(int i=0;i<=NommbreSommet;i++)
				{
					m.m[0][i]=0;
					m.m[i][0]=0;
				}
				m.m[0][0]=NommbreSommet;
				m.m[0][1]=nb;
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
		btnEnregistrer.setBounds(120, 26, 85, 21);
		contentPane.add(btnEnregistrer);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 413, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
