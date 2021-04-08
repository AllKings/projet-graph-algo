package GestionGraphe;
public class Grphe_Orienter_Non_Evalue extends Graphe{

	protected int  []pilch;
	protected int  []prem;
	protected int  []ro;
	protected int  []num;
	protected int  []cfc;
	protected boolean []EstDansLaPile;
	protected boolean []EstMarquer;
	protected int []pile;
	protected int p;
	protected int k;
	private void init()
	{
		int NombreSommet=Aps[0]+1;
		pilch=new int [NombreSommet+1];
		prem=new int [NombreSommet+1];
		ro=new int [NombreSommet+1];
		num=new int [NombreSommet+1];
		cfc=new int [NombreSommet+1];
		EstDansLaPile=new boolean [NombreSommet+1];
		pile=new int [NombreSommet+1];
		p=0;
		k=0;
		for(int i=0;i<=NombreSommet;i++)
		{
			pilch[i]=0;
			prem[i]=0;
			ro[i]=0;
			num[i]=0;
			cfc[i]=0;
			EstDansLaPile[i]=false;
			pile[i]=0;
			
		}
		pilch[0]=0;
		prem[0]=NombreSommet;
		ro[0]=NombreSommet;
		num[0]=NombreSommet;
		pile[0]=NombreSommet;
	}
	public Grphe_Orienter_Non_Evalue(int[] fs, int[] aps) {
		super(fs, aps);
		// TODO Auto-generated constructor stub
		init();
		
	}

	public Grphe_Orienter_Non_Evalue(Mat m) {
		super(m);
		// TODO Auto-generated constructor stub
		init();
	}

	public Grphe_Orienter_Non_Evalue(String nomFichier) {
		super(nomFichier);
		// TODO Auto-generated constructor stub
		init();
	}
	public int [] Distance(int sommet)
	{
		int []TablDist;
		int NombreSommet=Aps[0];
		TablDist=new int[NombreSommet+1];
	    TablDist[0]=Aps[0];
	    for(int i=1;i<=Aps[0];i++)
	    {
	        TablDist[i]=-1;

	    }
	    TablDist[sommet]=0;
	    int []file=new int [NombreSommet+1];
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
	public Mat Distance()
	{
		int NombreSommet=Aps[0];
	    Mat MatDist=new Mat(NombreSommet,Fs[0]-NombreSommet);
	    for(int i=1;i<=NombreSommet;i++)
	    {
	    	MatDist.m[i]= Distance(i);
	    }
		return MatDist;
		
	}
	public int [] NombreDePredecesseurs()
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
		int []ddi=this.NombreDePredecesseurs();
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
	            Graphe.empiler(pred,i);
	            result[i]=k;
	        }
	    }
	    int j;
	    while(pred[0]!=0)
	    {
	    	Graphe.empiler(prem,pred[0]);
	        
	        sommet=prem[0];
	        pred[0]=0;
	        while(sommet!=0)
	        {
	                j=Aps[sommet];

	                while(Fs[j]!=0)
	                {
	                    ddi[Fs[j]]-=1;
	                    if(ddi[Fs[j]]==0)
	                    {
	                    	Graphe.empiler(pred,Fs[j]);
	                        result[Fs[j]]=result[sommet]+1;
	                       
	                    }

	                    j+=1;
	                }

	                sommet=pred[sommet];

	            }

	    }
	}
	public Mat FortementConexGlobal()
	{
		FortementConex(1);
		int i=2;
		while(i<=Aps[0])
		{
			while(cfc[i]!=0 && i<=Aps[0])
			{i++;}
			if(i<=Aps[0]&& cfc[i]==0)
			{
				FortementConex(i);
			}
			if(cfc[i]!=0)
			{
				i++;
			}
		}
		System.out.println("k= "+cfc[0]);
		for(int j=1;j<=Aps[0];j++)
		{
			System.out.print(cfc[j]+" ");
		}
		Mat g=new Mat(cfc[0],cfc[0]);
		Mat m=Tomatrice();
		for(int s=1;s<=Aps[0];s++)
		{
			for(int j=s+1;j<=Aps[0];j++)
			{
				if(cfc[s]!=cfc[j])
				{
					if(m.m[s][j]==1)
					{
						g.m[cfc[s]][cfc[j]]=1;
					}
					else
					{
						if(m.m[j][s]==1)
						{
							g.m[cfc[j]][cfc[s]]=1;
						}
					}
				}
			}
		}
		return g;
	}
	
	void FortementConex(int sommet)
	{
	    p++;

	    num[sommet]=p;
	    ro[sommet]=p;
	    empiler(pile,sommet);
	    EstDansLaPile[sommet]=true;
	    int i=Aps[sommet];
	    while(Fs[i]!=0)
	    {
	        if(num[Fs[i]]==0)
	        {
	            FortementConex(Fs[i]);
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
	        //cout<<"le c"<<k<<"[";
	        while(num[element]>=num[sommet])
	        {
	          // cout<<element<<",";
	            element=depiler(pile);
	            EstDansLaPile[element]=false;
	            empiler(pilch,element);
	            cfc[element]=k;
	            element=pile[0];

	        }
	        //cout<<"]"<<endl;
	        prem[k]=pilch[0];
	        pilch[0]=0;
	    }

	    cfc[0]=k;
	}
}
