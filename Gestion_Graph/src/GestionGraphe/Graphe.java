package GestionGraphe;
import java.io.FileReader;
import java.io.BufferedReader;
public class Graphe {
	
	class FpApp
	{
		 int []Fp;
		 int []App;
		public FpApp(int[] fs, int[] aps) {
			super();
			int NombreSommet=Aps[0];
		    int []TabNombreDePredecesseurs=new int[NombreSommet+1];
		    TabNombreDePredecesseurs[0]=NombreSommet;
		    int indexFs;
		    for(int i=1;i<=Aps[0];i++)
		    {TabNombreDePredecesseurs[i]=0;}
		    for(int i=1;i<=Aps[0];i++)
		    {
		        indexFs=Aps[i];
		        while(Fs[indexFs]!=0)
		        {
		            TabNombreDePredecesseurs[Fs[indexFs]]+=1;
		            indexFs++;
		        }

		    }
		    App=new int[NombreSommet+1];
		    App[0]=NombreSommet;
		    App[1]=1;
		    for(int i=2;i<=NombreSommet;i++)
		    {int j=i-1;
		       App[i]=App[j]+ TabNombreDePredecesseurs[j]+1;
		    }
		    int taillFs=Fs[0];
		    Fp=new int[taillFs+1];
		    Fp[0]=taillFs;
		    int indexFp;
		   for(int i=1;i<=Aps[0];i++)
		    {
		        indexFs=Aps[i];
		        while(Fs[indexFs]!=0)
		        {
		            indexFp=App[Fs[indexFs]];
		          Fp[indexFp]=i;
		          App[Fs[indexFs]]+=1;
		          indexFs++;
		        }

		    }
		    for(int i=1;i<=Aps[0];i++)
		    {
		    Fp[App[i]]=0;
		    }
		}
		 
	}
protected int []Fs;
protected int []Aps;
public Graphe(int[] fs, int[] aps) {
	super();
	Fs = fs;
	Aps = aps;
}
public Mat Tomatrice()
{Mat m;
	int NombreSommet=Aps[0];
    int NombreArc=Fs[0]-NombreSommet;
    m=new Mat(NombreSommet,NombreArc);

    int indexFs;
    for(int i=1;i<=Aps[0];i++)
    {
        indexFs=Aps[i];
        while(Fs[indexFs]!=0)
        {
            m.m[i][Fs[indexFs]]=1;
            indexFs++;
        }

    }

		return m;
		
	}
public FpApp ToFpApp()
{
	return new FpApp(Fs, Aps);
}
public Graphe() {}
public Graphe(Mat m) {
	super();
	int NombreSommet=m.m[0][0];
    int NombreArc=m.m[0][1];
    Fs=new int [NombreSommet+NombreArc+1];
    Aps=new int[NombreSommet+1];
    Fs[0]=NombreSommet+NombreArc;
    Aps=new int[NombreSommet+1];
    Aps[0]=NombreSommet;
    int indexFs=1;
    int indexAps=indexFs;
    for(int i=1;i<=NombreSommet;i++)
    {
        Aps[indexAps]=indexFs;
        for(int j=1;j<=NombreSommet;j++)
        {
            if(m.m[i][j]==1)
            {
                Fs[indexFs]=j;
                indexFs++;
            }
        }
        Fs[indexFs]=0;
        indexFs++;
        indexAps++;
    }
}
public Graphe(String nomFichier) {
	try
	{
		FileReader file=new FileReader(nomFichier);
		BufferedReader in = new BufferedReader(file);
		String line;
		if ((line = in.readLine()) != null)
			{
			String []tabelEment=line.split(" ");
			int tailleFs=Integer.parseInt(tabelEment[0]);
			Fs=new int[tailleFs+1];
		    Fs[0]=tailleFs;
		    for(int j=1;j<=tailleFs;j++)
	        {
	         Fs[j]=Integer.parseInt(tabelEment[j]);
	        }
		    if ((line = in.readLine()) != null)
		    {
		    	String []tabelEment1=line.split(" ");
		    	int NombreSommet=Integer.parseInt(tabelEment1[0]);
		    	
		    	Aps=new int [NombreSommet+1];
		        Aps[0]=NombreSommet;
		        for(int j=1;j<=NombreSommet;j++)
		        {
		         Aps[j]=Integer.parseInt(tabelEment1[j]);
		        }
		    }
			}
		in.close();
	}
	catch(Exception e)
	{
		 System.out.println ("probleme fichier");
	}
	
}
public void ToFichier(String nomFichier)
{
	/*
	 * 
	 * enregistrer dans un fichier
	 * 
	 */
}
static void empiler(int [] pile,int valeur)
{
    pile[valeur]=pile[0];
    pile[0]=valeur;
}
public int[] getFs() {
	return Fs;
}
public void setFs(int[] fs) {
	Fs = fs;
}
public int[] getAps() {
	return Aps;
}
public void setAps(int[] aps) {
	Aps = aps;
}
static int depiler(int [] pile)
{
    int sommet=pile[0];
    pile[0]=pile[sommet];
    return sommet;
}
public static Mat MatriceFromFichier(String nomFichier)
{
	try
	{
		FileReader file=new FileReader(nomFichier);
		BufferedReader in = new BufferedReader(file);
		String line;
		line = in.readLine();
		String []tabelEment=line.split(" ");
		int tailleFs=Integer.parseInt(tabelEment[1]);
		int NombreSommet=Integer.parseInt(tabelEment[0]);
		Mat m=new Mat(NombreSommet,tailleFs);
	    for(int i=2;i<=NombreSommet;i++)
	    {
	    	m.m[0][i]=0;
	    }
	    for(int i=1;i<=NombreSommet;i++)
	    {
	    	line = in.readLine();
	    	String []tabelEment1=line.split(" ");
	    	for(int j=0;j<=NombreSommet;j++)
		    {
	    		m.m[i][j]=Integer.parseInt(tabelEment1[j]);
		    }
	    }	
		in.close();
		return m;
			
	}
	catch(Exception e)
	{
		 System.out.println ("probleme fichier");
	}
	return null;
	
}
}
