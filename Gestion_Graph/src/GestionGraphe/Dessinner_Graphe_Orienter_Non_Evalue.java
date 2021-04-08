package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import GestionGraphe.Dessinner_Graphe_Orienter_Evalue.JGraphXAdapterDemo;

import javax.swing.JTable;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Dessinner_Graphe_Orienter_Non_Evalue extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dessinner_Graphe_Orienter_Non_Evalue frame = new Dessinner_Graphe_Orienter_Non_Evalue(5);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static JTable Data(int NombreSommet)
	{
		JTable g=new JTable(NombreSommet+1,NombreSommet+1);
		for(int i=1;i<=NombreSommet;i++)
		{
			
			for(int j=1;j<=NombreSommet;j++)
			{
				g.setValueAt(0, i, j);
			}
		}
		g.setValueAt(NombreSommet, 0, 0);
		for(int j=1;j<=NombreSommet;j++)
		{
			g.setValueAt(j, 0, j);
			g.setValueAt(j, j, 0);
		}
		return g;
	}
	public static JTable Data(int NombreSommet,int[][]m)
	{
		JTable g=new JTable(NombreSommet+1,NombreSommet+1);
		for(int i=1;i<=NombreSommet;i++)
		{
			
			for(int j=1;j<=NombreSommet;j++)
			{
				g.setValueAt(m[i][j], i, j);
			}
		}
		g.setValueAt(NombreSommet, 0, 0);
		for(int j=1;j<=NombreSommet;j++)
		{
			g.setValueAt(j, 0, j);
			g.setValueAt(j, j, 0);
		}
		return g;
	}
	/**
	 * Create the frame.
	 */
	public Dessinner_Graphe_Orienter_Non_Evalue(int NombreSommet,int [][] m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTable g=Dessinner_Graphe_Orienter_Evalue.Data(NombreSommet,m);
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 10, 614, 352);
		contentPane.add(contentPane_1);
		
		table = new JTable();
		table.setBounds(284, 10, 277, 247);
		table.setModel(g.getModel());
		contentPane_1.add(table);
		
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
		        applet.init(g);
		        JFrame frame1 = new JFrame();
		        JButton btnNewButton23 = new JButton("retour");
		        btnNewButton23.setBounds(10, 27, 85, 21);
		        btnNewButton23.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame1.setVisible(false);
				        setVisible(true);
					}
				});
		        frame1.getContentPane().add(btnNewButton23);
		        frame1.getContentPane().add(applet);
		        frame1.setTitle("JGraphT Adapter to JGraphX Demo");
		        frame1.pack();
		        frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 27, 85, 21);
		contentPane_1.add(btnNewButton);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
					for(int j=1;j<=NombreSommet;j++)
					{
						m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
						if(m.m[i][j]>0)
						{
							nb+=1;
						}
					}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
					m.m[0][i]=0;
					m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
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
		btnEnregistrer.setBounds(114, 27, 107, 21);
		contentPane_1.add(btnEnregistrer);
		
		JButton btnRang = new JButton("Rang");
		btnRang.setBounds(114, 69, 107, 21);
		contentPane_1.add(btnRang);
		
		JButton btnFsaps = new JButton("FsAps");
		btnFsaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
					for(int j=1;j<=NombreSommet;j++)
					{
						m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
						if(m.m[i][j]>0)
						{
							nb+=1;
						}
					}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
					m.m[0][i]=0;
					m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
				m.m[0][1]=nb;
				Grphe_Orienter_Non_Evalue graphe=new Grphe_Orienter_Non_Evalue(m);
				int []aps=graphe.getAps();
				int []fs=graphe.getFs();
				AfficheurFsAps frame = new AfficheurFsAps(fs,aps);
				frame.setVisible(true);
			}
		});
		btnFsaps.setBounds(10, 69, 85, 21);
		contentPane_1.add(btnFsaps);
		
		JButton btnTarjan = new JButton("Tarjan");
		btnTarjan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
				for(int j=1;j<=NombreSommet;j++)
				{
				    m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
				    if(m.m[i][j]>0)
				    {
				        nb+=1;
				    }
				}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
				m.m[0][i]=0;
				m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
				m.m[0][1]=nb;
				Grphe_Orienter_Non_Evalue graphe=new Grphe_Orienter_Non_Evalue(m);
				Mat matreduite=graphe.FortementConexGlobal();
				JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
				JTable k=Data(matreduite.m[0][0],matreduite.m);
				applet.init(k);
				JFrame frame1 = new JFrame();
				JButton btnNewButton23 = new JButton("retour");
				btnNewButton23.setBounds(10, 27, 85, 21);
				btnNewButton23.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				    // TODO Auto-generated method stub
				    frame1.setVisible(false);
				    setVisible(true);
				}
				});
				frame1.getContentPane().add(btnNewButton23);
				frame1.getContentPane().add(applet);
				frame1.setTitle("JGraphT Adapter to JGraphX Demo");
				frame1.pack();
				frame1.setVisible(true);
			}
		});
		btnTarjan.setBounds(10, 113, 85, 21);
		contentPane_1.add(btnTarjan);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(10, 321, 85, 21);
		contentPane_1.add(btnRetour);
		
		JButton btnDistance = new JButton("Distance");
		btnDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDistance.setBounds(114, 113, 107, 21);
		contentPane_1.add(btnDistance);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Dessinner_Graphe_Orienter_Non_Evalue(int NombreSommet) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTable g=Dessinner_Graphe_Orienter_Evalue.Data(NombreSommet);
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 10, 614, 352);
		contentPane.add(contentPane_1);
		
		table = new JTable();
		table.setBounds(284, 10, 277, 247);
		table.setModel(g.getModel());
		contentPane_1.add(table);
		
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
		        applet.init(g);
		        JFrame frame1 = new JFrame();
		        JButton btnNewButton23 = new JButton("retour");
		        btnNewButton23.setBounds(10, 27, 85, 21);
		        btnNewButton23.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame1.setVisible(false);
				        setVisible(true);
					}
				});
		        frame1.getContentPane().add(btnNewButton23);
		        frame1.getContentPane().add(applet);
		        frame1.setTitle("JGraphT Adapter to JGraphX Demo");
		        frame1.pack();
		        frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 27, 85, 21);
		contentPane_1.add(btnNewButton);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
					for(int j=1;j<=NombreSommet;j++)
					{
						m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
						if(m.m[i][j]>0)
						{
							nb+=1;
						}
					}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
					m.m[0][i]=0;
					m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
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
		btnEnregistrer.setBounds(114, 27, 107, 21);
		contentPane_1.add(btnEnregistrer);
		
		JButton btnRang = new JButton("Rang");
		btnRang.setBounds(114, 69, 107, 21);
		contentPane_1.add(btnRang);
		
		JButton btnFsaps = new JButton("FsAps");
		btnFsaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
					for(int j=1;j<=NombreSommet;j++)
					{
						m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
						if(m.m[i][j]>0)
						{
							nb+=1;
						}
					}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
					m.m[0][i]=0;
					m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
				m.m[0][1]=nb;
				Grphe_Orienter_Non_Evalue graphe=new Grphe_Orienter_Non_Evalue(m);
				int []aps=graphe.getAps();
				int []fs=graphe.getFs();
				AfficheurFsAps frame = new AfficheurFsAps(fs,aps);
				frame.setVisible(true);
			}
		});
		btnFsaps.setBounds(10, 69, 85, 21);
		contentPane_1.add(btnFsaps);
		
		JButton btnTarjan = new JButton("Tarjan");
		btnTarjan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nb=0;
				Mat m=new Mat(NombreSommet,NombreSommet);
				for(int i=1;i<=NombreSommet;i++)
				{
				for(int j=1;j<=NombreSommet;j++)
				{
				    m.m[i][j]= Integer.valueOf(g.getValueAt(i, j).toString());
				    if(m.m[i][j]>0)
				    {
				        nb+=1;
				    }
				}
				}
				for(int i=0;i<=NombreSommet;i++)
				{
				m.m[0][i]=0;
				m.m[i][0]=0;
				}
				m.m[0][0]=NombreSommet;
				m.m[0][1]=nb;
				Grphe_Orienter_Non_Evalue graphe=new Grphe_Orienter_Non_Evalue(m);
				Mat matreduite=graphe.FortementConexGlobal();
				JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
				JTable k=Data(matreduite.m[0][0],matreduite.m);
				applet.init(k);
				JFrame frame1 = new JFrame();
				JButton btnNewButton23 = new JButton("retour");
				btnNewButton23.setBounds(10, 27, 85, 21);
				btnNewButton23.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				    // TODO Auto-generated method stub
				    frame1.setVisible(false);
				    setVisible(true);
				}
				});
				frame1.getContentPane().add(btnNewButton23);
				frame1.getContentPane().add(applet);
				frame1.setTitle("JGraphT Adapter to JGraphX Demo");
				frame1.pack();
				frame1.setVisible(true);
			}
		});
		btnTarjan.setBounds(10, 113, 85, 21);
		contentPane_1.add(btnTarjan);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(10, 321, 85, 21);
		contentPane_1.add(btnRetour);
		
		JButton btnDistance = new JButton("Distance");
		btnDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDistance.setBounds(114, 113, 107, 21);
		contentPane_1.add(btnDistance);
	}
	public class JGraphXAdapterDemo
    extends
    JApplet
{
    private static final long serialVersionUID = 2202072534703043194L;

    private final Dimension DEFAULT_SIZE = new Dimension(530, 320);


    /**
     * An alternative starting point for this demo, to also allow running this applet as an
     * application.
     *
     * @param args command line arguments
     */
 

    public void init(JTable m)
    {
        mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
        int n=Integer.valueOf(m.getValueAt(0, 0).toString());
        ArrayList<Object>h = new ArrayList<Object>();
        for(int i=1;i<=n;i++ )
        {
        	h.add(graph.insertVertex(parent, null, m.getValueAt(0, i).toString(), 20, 20, 30,30));
        }
        for(int i=1;i<=n;i++ )
        {
        	for(int j=1;j<=n;j++ )
            {
            
        		if(!m.getValueAt(i, j).toString().equals("0"))
        		{
        			graph.insertEdge(parent, null, "", h.get(Integer.valueOf(m.getValueAt(0, i).toString())-1), h.get(Integer.valueOf(m.getValueAt(0, j).toString())-1));
        		}
            }
        }
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		mxCircleLayout layout = new mxCircleLayout(graph);
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);
        layout.execute(graph.getDefaultParent());
        new mxParallelEdgeLayout(graph).execute(graph.getDefaultParent());
    }
}
}
