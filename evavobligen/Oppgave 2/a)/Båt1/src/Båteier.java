
public class Båteier extends Node{
	
	private String navn;
	private String adresse;
	private int medlemsNr;
	public static int medlemsNrNeste;
	private Båt båt = null;
    public Båteier neste = null; 	
	public Båteier (String n, String a, int mnr){
		navn = n;
		adresse = a;
		medlemsNr = medlemsNrNeste++;
	}

	public String getMedlem(){
		return medlemsNr;
	}
	
	public void nyBåt(Båt b){
		båt = b;
	}
	
	public void fjernBåt (){
		båt = null ;
	}
	
	public boolean eierBåt(){
		return !Båter.tom();
	}
	public boolean slettBåt(){
		
	}
		
	
}//End of class Båteier