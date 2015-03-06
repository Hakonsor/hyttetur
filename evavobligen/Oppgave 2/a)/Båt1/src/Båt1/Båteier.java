package Båt1;

import java.io.Serializable;

public class Båteier implements Serializable{
	
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
        public int getStaticNR(){
            return medlemsNrNeste;
        }
        
        public int setStaticNR( int nyStaticNr){
            return medlemsNrNeste = nyStaticNr;
        }

	public int getMedlem(){
		return medlemsNr;
	}
	
	public void setBåt(Båt b){
		båt = b;
	}

	public void fjernBåt (){
		båt = null ;
	}
        
        
        
        public String toString(){                 
            String s = "";
            s += "Navn: " + navn + " \tAdresse: " + adresse + "\tMedlemsnummer: "+medlemsNr;             
            s += "\nBåt: ";
            if(båt != null){
                s += båt.toString();
            }else s += "ingen";
            return s;
        }
		
	
}//End of class Båteier