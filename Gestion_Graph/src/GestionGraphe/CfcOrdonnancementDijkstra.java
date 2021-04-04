package GestionGraphe;
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
	
}
