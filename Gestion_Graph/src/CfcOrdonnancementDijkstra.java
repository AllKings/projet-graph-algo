
public class CfcOrdonnancementDijkstra {
	private GrapheOrienter g;
	private int p=0;
	private int k=0;
	int[]num=new int[g.getAps()[0]];
	int []prem=new int[g.getAps()[0]];
	int []pilch=new int[g.getAps()[0]];
	int []CFCresult=new int[g.getAps()[0]];
	int []ro=new int[g.getAps()[0]];
	int []pile=new int[g.getAps()[0]];
	boolean []EstDansLaPile=new boolean[g.getAps()[0]];
	void CFC(int sommet)
	{
	    p++;

	    num[sommet]=p;
	    ro[sommet]=p;
	    Graphe.empiler(pile,sommet);
	    EstDansLaPile[sommet]=true;
	    int []Aps=g.getAps();
	    int []Fs=g.getFs();
	    int i=Aps[sommet];
	    while(Fs[i]!=0)
	    {
	        if(num[Fs[i]]==0)
	        {
	            CFC(Fs[i]);
	            if(ro[Fs[i]]<ro[sommet])
	            {
	                ro[sommet]=ro[Fs[i]];
	            }
	        }
	        else
	        {
	            if(num[Fs[i]]<ro[sommet] && EstDansLaPile[Fs[i]])
	            {
	                ro[sommet]=num[Fs[i]];
	            }
	        }
	        i++;
	    }
	    if(ro[sommet]==num[sommet])
	    {
	        k++;
	        int element=pile[0];
	        
	        while(num[element]>=num[sommet])
	        {
	          
	            element=Graphe.depiler(pile);
	            EstDansLaPile[element]=false;
	            Graphe.empiler(pilch,element);
	            CFCresult[element]=k;
	            element=pile[0];

	        }
	        
	        prem[k]=pilch[0];
	        pilch[0]=0;
	    }


	}
	void codage_prufer(int **a, int*& t) const
	{
    		int n=a[0][0];
    		t=new int[n-1];
    		t[0]=n-2;
    		for(int i=1; i<=n; i++)
    		{
        		for(int j=1; j<=n; j++) if(a[i][j]==1) a[i][0]++;
    		}

    		for(int i=1; i<=n-2; i++)
    		{
        		int j=1, k=1;
        		while(a[j][0]!=1) j++;
        		while(a[j][k]==0) ++k;
        		t[i]=k;
        		a[k][j]=0;
        		a[j][k]=0;
        		a[j][0]=0;
    		}
	}

	void decodage_prufer(int *t) const
	{
    		int n=t[0]+2;
    		bool* I= new bool[n+1];
    		for(int i=1; i<=n; i++) I[i]=true;

    		int* compteT= new int[n+1]; //cpt combien de fois le sommet est dans t
    		for(int i=1; i<=n; i++) compteT=0;
    		for(int i=1; i<=n-2; i++) compteT[t[i]]++;

    		for(int i=1; i<=n-2; i++)
    		{
        		for(int j=1; j<=n; j++)
        		{
            		if(I[j] && compteT[j]==0)
            		{
                		I[j]=false;
                		compteT[t[i]]--;
                		cout<<t[i];
                		break;
            		}
        		}
    		}


    		for(int i=1; i<=n; i++) if(I[i]) cout<<i<<" ";
		}
	
	}
