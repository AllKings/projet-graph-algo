package GestionGraphe;
public class CfcOrdonnancementDijkstra {
	private Grphe_Orienter_Non_Evalue g;
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
<<<<<<< HEAD
=======
	
	public boolean dantzig(Mat matrice) {
		int x;
		int n = matrice.m[0][0];
		
		for(int k=2 ; k<n ;k++) {
			for(int i=1;i<=k;k++) {
				for(int j=1;j<=k;j++) {
					if( (x=matrice.m[i][j] + matrice.m[j][k+1]) < matrice.m[i][k+1]) 
						matrice.m[i][k+1]=x;

					if( (x=matrice.m[k+1][j] + matrice.m[j][i]) < matrice.m[k+1][i])
						matrice.m[k+1][i]=x;

				}
				if(matrice.m[i][k+1] + matrice.m[k+1][i]<0)
				{
					System.out.println("Circuit absornbant" + i + " et " + k+1);
					return false;
				}
			}
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=k;j++) {
					if( (x=matrice.m[i][k+1] + matrice.m[k+1][j]) < matrice.m[i][j])
						matrice.m[i][j] = x;
				}
			}

		}
		return true;
	}
	
	/*void codage_prufer(GrapheOrienter a, GrapheOrienter t) 
    		int n=a.getAps()[0];
    		t=new int[n-1];
    		t[0]=n-2;
    		for(int i=1; i<=n; i++)
    		{
        		for(int j=1; j<=n; j++) {
				if(a[i][j]==1) 
				{
					a[i][0]++;
				}
			}
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

	void decodage_prufer(GrapheOrienter t) 
	{
    		int n=t.getAps()[0]+2;
    		bool I= new bool[n+1];
    		for(int i=1; i<=n; i++) I[i]=true;

    		int compteT= new int[n+1]; //cpt combien de fois le sommet est dans t
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
                			System.out.println(t[i]);
                		
            			}
        		}
    		}
    		for(int i=1; i<=n; i++) {
			if(I[i]) {
				System.out.println(i+" ");
			}
		}
	}*/
>>>>>>> c4bfa3cbeb8dbb7afe87e78a17defc3bb2127739
	
}
