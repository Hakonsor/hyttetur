package båt2;

import java.io.Serializable;

public class Båteier implements Serializable{
	
	private String navn;
	private String adresse;
	private int medlemsNr;
	public static int medlemsNrNeste = 1000;
	private Båtliste båtListe = new Båtliste();
        public Båteier neste = null;
     	
	public Båteier (String n, String a){
		navn = n;
		adresse = a;
		medlemsNr = medlemsNrNeste++;
	}
        public String getNavn(){
            return navn;
        }
        public boolean sjekkFlåte(){
         if(båtListe.sjekkFlåte()) return true;
         return false;
           
        }
        public Båt getBåt(String regNr){
            return båtListe.finnBåt(regNr);    
        }
        public void nyBåt(Båt b){
            båtListe.nyBåt(b);
	}
       /* public String skrivUtBåtListe(){
            return båtListe.skrivUtBåtListe();
        }*/
        
        public int setStaticNR( int nyStaticNr){
            return medlemsNrNeste = nyStaticNr;
        }
	public int getMedlem(){
		return medlemsNr;
	}
	public boolean fjernBåt (String regNr){
		return båtListe.slettBåt(regNr) ;
	}

        public String toString(){                 
            String s = "";
            s += "Navn: " + navn + " \tAdresse: " + adresse + "\tMedlemsnummer: "+medlemsNr;             
            s += "\nBåt: ";
            if(båtListe.sjekkFlåte()){
                s += båtListe.toString();
            }else s += "ingen";
            return s;
        }
		
	
}//End of class Båteier