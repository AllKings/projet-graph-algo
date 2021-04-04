package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DessinnerNonOrieterSommet extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DessinnerNonOrieterSommet frame = new DessinnerNonOrieterSommet(5);
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
	public DessinnerNonOrieterSommet(int NommbreSommet) {
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
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 26, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rand");
		btnNewButton_1.setBounds(120, 26, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Distance");
		btnNewButton_1_1.setBounds(10, 68, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("FsAps");
		btnNewButton_1_1_1.setBounds(120, 68, 85, 21);
		contentPane.add(btnNewButton_1_1_1);
	}
}
