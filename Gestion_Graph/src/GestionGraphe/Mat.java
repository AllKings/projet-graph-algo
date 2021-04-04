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
	
	
}
