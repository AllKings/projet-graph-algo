import java.util.Iterator;

public class Graphe {
	class Mat
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
		
		
	}
	class FpApp
	{
		 int []Fp;
		 int []App;
		public FpApp(int[] fs, int[] aps) {
			super();
			Fp = null;
			App = null;
			/*transformer de Fs Aps a Fp App*/
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
	{
		return null;
		
	}
public FpApp ToFpApp()
{
	return new FpApp(Fs, Aps);
}
public Graphe(Mat m) {
	super();
	Fs = null;
	Aps = null;
}
public Graphe(String nomFichier) {
	super();
	Fs = null;
	Aps = null;
}
public void ToFichier(String nomFichier)
{
	/*enregistrer dans un fichier*/
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
}
