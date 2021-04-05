package GestionGraphe;
public class main {

	public boolean pileVide(int[] pilch) {
		return (pilch[0]==0);
	}

	public void empiler(int s,int[] pilch)
	{
		int[] pCopy = new int[pilch.length+1];
		for(int i = 0 ; i < pilch.length ; ++i) {
			pCopy[i] = pilch[i];
		}
		pCopy[pCopy.length-1] = s;
		pilch = pCopy.clone();
	}
	
	public int depiler(int[] pilch)
	{
		int[] pCopy = new int[pilch.length-1];
		for(int i = 0 ; i < pCopy.length ; ++i) {
			pCopy[i] = pilch[i];
		}
		int x = pilch.length-1;
		pilch = pCopy.clone();
		return x;
	}
}

