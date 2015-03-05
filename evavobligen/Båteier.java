
public class Båteier{
	
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
		båter = new Båtliste();
	}

	public String getMedlem(){
		return medlemsNr;
	}
	
	public void nyBåt(Båt b){
		Båter.settInn(b);
	}
	
	public Båt fjernBåt (String regNr){
		return Båter.fjern(regNr);
	}
	
	public boolean eierBåt(){
		return !Båter.tom();
	}
	public boolean slettBåt(){
		
	}
		
	
}//End of class Båteier