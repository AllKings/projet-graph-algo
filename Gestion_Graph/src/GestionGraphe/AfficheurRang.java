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

public class AfficheurRang extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int []rang=new int [1];
					
					AfficheurRang frame = new AfficheurRang(rang);
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
	public AfficheurRang(int []rang) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int t=rang[0];
		JTable g=new JTable(1,t+1);
		for(int i=0;i<=t;i++)
		{
			g.setValueAt(rang[i], 0, i);
		}
		
		table = new JTable();
		table.setBounds(52, 106, 661, 21);
		contentPane.add(table);
		table.setModel(g.getModel());
		JLabel lblNewLabel = new JLabel("Rang");
		lblNewLabel.setBounds(315, 59, 78, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(52, 249, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  // save to file
				  StringBuilder data=new StringBuilder();
				  for(int i=0;i<=rang[0];i++)
				  {
					  data.append(rang[i]+" ");
				  }
				  data.append(rang[rang[0]]);
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
		btnNewButton_1.setBounds(594, 249, 119, 21);
		contentPane.add(btnNewButton_1);
	}

}
