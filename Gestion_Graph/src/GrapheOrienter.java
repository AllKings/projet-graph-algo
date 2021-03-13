
public class GrapheOrienter extends Graphe{

	public GrapheOrienter(int[] fs, int[] aps) {
		super(fs, aps);
		// TODO Auto-generated constructor stub
	}

	public GrapheOrienter(Graphe.Mat m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	public GrapheOrienter(String nomFichier) {
		super(nomFichier);
		// TODO Auto-generated constructor stub
	}
	public int [] Distance(int sommet,int []TablDist)
	{
		int NombreSommet=Aps[0];
	    TablDist[0]=Aps[0];
	    for(int i=1;i<=Aps[0];i++)
	    {
	        TablDist[i]=-1;

	    }
	    TablDist[sommet]=0;
	    int []file=new int [NombreSommet];
	    int distance=1;
	    int indexFs;
	    int debut=1,courant=0,fin=1;
	    file[debut]=sommet;
	    while(courant<fin)
	    {
	        for(int i=courant+1;i<=debut;i++)
	        {
	            indexFs=Aps[file[i]];
	            while(Fs[indexFs]!=0)
	            {
	                if(TablDist[Fs[indexFs]]==-1)
	                {
	                   TablDist[Fs[indexFs]]=distance;
	                    fin++;
	                   file[fin]=Fs[indexFs];

	                }
	                indexFs++;
	            }

	        }
	        courant=debut;
	        debut=fin;

	        distance++;
	    }

		return TablDist;
	}
	public Mat Distance(Mat distance)
	{
		int NombreSommet=Aps[0];
	    Mat MatDist=new Mat(NombreSommet,Fs[0]-NombreSommet);
	    for(int i=1;i<=NombreSommet;i++)
	    {
	        Distance(i,MatDist.m[i]);
	    }
		return MatDist;
		
	}
	int [] NombreDePredecesseurs()
	{
	    int NombreSommet=Aps[0];
	    int []TabNombreDePredecesseurs=new int [NombreSommet+1];
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
	    return TabNombreDePredecesseurs;
	}
	public void Rang(int [] result, int [] prem,int []pred)
	{
		int []ddi=NombreDePredecesseurs();
	    int NombreSommet=Aps[0];
	    int k=0;
	    int sommet=1;
	    for(int i=0;i<=NombreSommet;i++)
	    {
	    	prem[i]=0;
	    	pred[i]=0;
	        result[i]=-1;
	    }
	    result[0]=NombreSommet;
	    for(int i=1;i<=NombreSommet;i++)
	    {
	        if(ddi[i]==0)
	        {
	            empiler(pred,i);
	            result[i]=k;
	        }
	    }
	    int j;
	    while(pred[0]!=0)
	    {
	        empiler(prem,pred[0]);
	        pred[0]=0;
	        sommet=prem[0];
	        while(sommet!=0)
	        {
	                j=Aps[sommet];

	                while(Fs[j]!=0)
	                {
	                    ddi[Fs[j]]--;
	                    if(ddi[Fs[j]]==0)
	                    {
	                        empiler(pred,Fs[j]);
	                        result[Fs[j]]=result[sommet]+1;
	                       
	                    }

	                    j++;
	                }

	                sommet=pred[sommet];

	            }

	    }
	}
	

}
