package GestionGraphe;

public class Mat
{
	int[][] m;

	public Mat(int NombreSomment,int NombreArc) {
		super();
		this.m=new int [NombreSomment+1][NombreSomment+1];
		for (int i = 0; i < NombreSomment+1; i++) {
			for (int j = 0; j < NombreSomment+1; j++) {
				this.m[i][j]=0;
			}
		}
		this.m[0][0]=NombreSomment;
		this.m[0][1]=NombreArc;			
		
	}
	
	/*
	 * Fonction qui rempli la matrice d'adjacence avec les tableaux Fs et Aps 
	 */
	public void fromFsAps(int[] fs, int[] aps) {
		int nbSommet = aps[0];
		int l = fs[0] - nbSommet;
		
		for(int i=1 ; i<=nbSommet ; i++) {
			for(int j=1;j<=nbSommet;j++) {
				m[i][j]=0;
			}
		}
		
		//m[0]=new int[2];
		m[0][0]=nbSommet;
		m[0][1]=l;
		
		int j;
		for(int i=1;i<=nbSommet;i++) {
			for(int k=aps[i];(j=fs[k])<=0;k++) {
				m[i][j]=1;
			}
		}
		
	}
	
	/*
	 * Fonction qui créé le Graphe en remplissant Fs et Aps à partir de la matrice
	 */
	public Graphe toFsAps() {
		Graphe G = new Graphe();
		int nbSommet = m[0][0];
		int nbArc = m[0][1];
		
		G.Fs = new int[nbSommet+nbArc+1];
		G.Aps=new int[nbSommet+1];
		G.Fs[0] = nbSommet+nbArc;
		G.Aps[0] = nbSommet;
		
		int iFs = 1;
		int iAps = iFs;
		
		for(int i=1;i<=nbSommet;i++) {
			G.Aps[iAps] = iFs;
			for (int j=1;j<=nbSommet;j++) {
				if(m[i][j]==1)
	            {
	                G.Fs[iFs]=j;
	                iFs++;
	            }
			}
			G.Fs[iFs]=0;
	        iFs++;
	        iAps++;
		}
		
		return G;
	}
	
	
}
