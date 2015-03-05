package Båt1;
public class Båteier extends Node{
	
	private String navn;
	private String adresse;
	private int medlemsNr;
	public static int medlemsNrNeste = 1000;
	private Båt båt = null;
        
    public Båteier neste = null; 	
	public Båteier (String n, String a){
		navn = n;
		adresse = a;
		medlemsNr = medlemsNrNeste++;
	}
        public String getNavn(){
            return navn;
        }
        public Båt getBåt(){
            return båt;
            
        }

	public int getMedlem(){
		return medlemsNr;
	}
	
	public void nyBåt(Båt b){
		båt = b;
	}

	public void fjernBåt (){
		båt = null ;
	}
        
        
        
        public String toString(){                 
            String s = "";
            s += "Navn: " + navn + " \tAdresse: " + adresse + "\tbåt: " ;    
            if(båt != null){
                s += båt.toString();
            }else s += "ingen";
            
            s+= "\tMedlemsnummer: "+medlemsNr;
            return s;
        }
		
	
}//End of class Båteier