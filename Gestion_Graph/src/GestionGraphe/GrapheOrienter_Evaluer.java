package GestionGraphe;

import java.io.BufferedReader;
import java.io.FileReader;

public class GrapheOrienter_Evaluer extends Grphe_Orienter_Non_Evalue{
	int []D;
	public GrapheOrienter_Evaluer(int[] fs, int[] aps,int []d) {
		super(fs, aps);
		D=d;
		// TODO Auto-generated constructor stub
	}

	public GrapheOrienter_Evaluer(Mat m) {
		super(m);
		int NombreSommet=m.m[0][0];
	    int NombreArc=m.m[0][1];
	    D=new int [NombreSommet+NombreArc+1];
	    D[0]=NombreSommet+NombreArc;
	    int indexFs=1;
	    
	    for(int i=1;i<=NombreSommet;i++)
	    {
	        for(int j=1;j<=NombreSommet;j++)
	        {
	            if(m.m[i][j]!=0)
	            {
	                D[indexFs]=m.m[i][j];
	                indexFs++;
	                
	            }
	        }
	        D[indexFs]=0;
	        indexFs++;
	    }
	}

	public GrapheOrienter_Evaluer(String nomFichier) {
		super(nomFichier);
		try
		{
			FileReader file=new FileReader(nomFichier);
			BufferedReader in = new BufferedReader(file);
			String line;
			line = in.readLine();
			line = in.readLine();
			if ((line = in.readLine()) != null)
				{
				String []tabelEment=line.split(" ");
				int tailleFs=Integer.parseInt(tabelEment[0]);
				D=new int[tailleFs+1];
			    D[0]=tailleFs;
			    for(int j=1;j<=tailleFs;j++)
		        {
		         D[j]=Integer.parseInt(tabelEment[j]);
		        }	
				}
			in.close();
		}
		catch(Exception e)
		{
			 System.out.println ("probleme fichier");
		}
	}

	public Mat Tomatrice()
	{Mat m=super.Tomatrice();
		int NombreSommet=Aps[0];
	    int NombreArc=Fs[0]-NombreSommet;
	    int indexFs;
	    for(int i=1;i<=Aps[0];i++)
	    {
	        indexFs=Aps[i];
	        while(Fs[indexFs]!=0)
	        {
	            m.m[i][Fs[indexFs]]=D[indexFs];
	            indexFs++;
	        }

	    }

			return m;
			
		}
	public int [] djikstra()
	{
		int []p;
		return null;
	}
}
