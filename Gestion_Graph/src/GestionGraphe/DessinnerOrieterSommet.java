package GestionGraphe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jgrapht.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.ExportException;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.traverse.DepthFirstIterator;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;


import test.JGraphXAdapterDemo;

import javax.swing.JTable;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class DessinnerOrieterSommet extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DessinnerOrieterSommet frame = new DessinnerOrieterSommet(5);
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
	public DessinnerOrieterSommet(int NombreSommet,int[][]m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(284, 10, 196, 196);
		contentPane.add(table);
		JTable g=Data(NombreSommet,m);
		table.setModel(g.getModel());
		JButton btnNewButton = new JButton("valider");
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
		contentPane.add(btnNewButton);
		
		JButton btnMatrice = new JButton("Enregistrer");
		btnMatrice.addActionListener(new ActionListener() {
			
			@Override
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
		btnMatrice.setBounds(114, 27, 85, 21);
		contentPane.add(btnMatrice);
		
		JButton btnNewButton_1_1 = new JButton("Rang");
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
				GrapheOrienter graphe=new GrapheOrienter(m);
				int[]rang=new int[NombreSommet+1];
				rang[0]=NombreSommet;
				int[]prem=new int[NombreSommet+1];
				prem[0]=NombreSommet;
				int[]pred=new int[NombreSommet+1];
				pred[0]=NombreSommet;
				graphe.Rang(rang, prem, pred);
				AfficheurRang frame = new AfficheurRang(rang);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setBounds(114, 69, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnFsaps = new JButton("FsAps");
		btnFsaps.setBounds(10, 69, 85, 21);
		contentPane.add(btnFsaps);
		
		JButton btnDistance = new JButton("Distance");
		btnDistance.addActionListener(new ActionListener() {
			
			@Override
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
				GrapheOrienter graphe=new GrapheOrienter(m);
				Mat matDist=graphe.Distance();
				AfficheurDistance frame = new AfficheurDistance(matDist);
				frame.setVisible(true);
				
			}
		});
		btnDistance.setBounds(10, 100, 85, 21);
		contentPane.add(btnDistance);
		
		JButton btnDjikstra = new JButton("Djikstra");
		btnDjikstra.setBounds(114, 100, 85, 21);
		contentPane.add(btnDjikstra);
		
		JButton btnDantzig = new JButton("Dantzig");
		btnDantzig.setBounds(10, 142, 85, 21);
		contentPane.add(btnDantzig);
		
		JButton btnKruskal = new JButton("Kruskal");
		btnKruskal.setBounds(114, 142, 85, 21);
		contentPane.add(btnKruskal);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public DessinnerOrieterSommet(int NombreSommet) {
	

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(284, 10, 196, 196);
		contentPane.add(table);
		JTable g=Data(NombreSommet);
		table.setModel(g.getModel());
		JButton btnNewButton = new JButton("valider");
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
		contentPane.add(btnNewButton);
		
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
		btnEnregistrer.setBounds(114, 27, 85, 21);
		contentPane.add(btnEnregistrer);
		
		JButton btnRang = new JButton("Rang");
		btnRang.addActionListener(new ActionListener() {
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
				GrapheOrienter graphe=new GrapheOrienter(m);
				int[]rang=new int[NombreSommet+1];
				rang[0]=NombreSommet;
				int[]prem=new int[NombreSommet+1];
				prem[0]=NombreSommet;
				int[]pred=new int[NombreSommet+1];
				pred[0]=NombreSommet;
				graphe.Rang(rang, prem, pred);
				AfficheurRang frame = new AfficheurRang(rang);
				frame.setVisible(true);
				
			}
		});
		btnRang.setBounds(114, 69, 85, 21);
		contentPane.add(btnRang);
		
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
				GrapheOrienter graphe=new GrapheOrienter(m);
				int []aps=graphe.getAps();
				int []fs=graphe.getFs();
				AfficheurFsAps frame = new AfficheurFsAps(fs,aps);
				frame.setVisible(true);
			}
		});
		btnFsaps.setBounds(10, 69, 85, 21);
		contentPane.add(btnFsaps);
		
		JButton btnDistance = new JButton("Distance");
		btnDistance.addActionListener(new ActionListener() {
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
				GrapheOrienter graphe=new GrapheOrienter(m);
				Mat matDist=graphe.Distance();
				AfficheurDistance frame = new AfficheurDistance(matDist);
				frame.setVisible(true);
				
				
			}
		});
		btnDistance.setBounds(10, 100, 85, 21);
		contentPane.add(btnDistance);
		
		JButton btnDjikstra = new JButton("Djikstra");
		btnDjikstra.setBounds(114, 100, 85, 21);
		contentPane.add(btnDjikstra);
		
		JButton btnDantzig = new JButton("Dantzig");
		btnDantzig.setBounds(10, 142, 85, 21);
		contentPane.add(btnDantzig);
		
		JButton btnKruskal = new JButton("Kruskal");
		btnKruskal.setBounds(114, 142, 85, 21);
		contentPane.add(btnKruskal);
	}
	
	public class JGraphXAdapterDemo
    extends
    JApplet
{
    private static final long serialVersionUID = 2202072534703043194L;

    private final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;

    /**
     * An alternative starting point for this demo, to also allow running this applet as an
     * application.
     *
     * @param args command line arguments
     */
 

    public void init(JTable m)
    {
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g =
            new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));

        // create a visualization using JGraph, via an adapter
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);

        
        int n=Integer.valueOf(m.getValueAt(0, 0).toString());
        // add some sample data (graph manipulated via JGraphX)
        for(int i=1;i<=n;i++ )
        {
        	g.addVertex(m.getValueAt(0, i).toString());
        }
        for(int i=1;i<=n;i++ )
        {
        	for(int j=1;j<=n;j++ )
            {
            
        		if(m.getValueAt(i, j).toString().equals("1"))
        		{
        			g.addEdge(m.getValueAt(0, i).toString(),m.getValueAt(0, j).toString());
        			
        		}
            }
        }
        // positioning via jgraphx layouts
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);
        
        layout.execute(jgxAdapter.getDefaultParent());
        // that's all there is to it!...
    }
}

	
}
