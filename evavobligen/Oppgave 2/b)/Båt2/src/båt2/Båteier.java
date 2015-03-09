package båt2;

import java.io.Serializable;

public class Båteier implements Serializable{
	
	private String navn;
	private String adresse;
	private int medlemsNr;
	public static int medlemsNrNeste = 1000;
        public Båteier neste = null;
        private Båt jolle;
     	
	public Båteier (String n, String a){
                jolle = null;
		navn = n;
		adresse = a;
		medlemsNr = medlemsNrNeste++;
	}
        public String getNavn(){
            return navn;
        }
        
        public int setStaticNR( int nyStaticNr){
            return medlemsNrNeste = nyStaticNr;
        }
	public int getMedlem(){
		return medlemsNr;
	}


        public String toString(){                 
            String s = "";
            s += "Navn: " + navn + " \tAdresse: " + adresse + "\tMedlemsnummer: "+medlemsNr;             
            s += "\nBåt: ";
            if(jolle != null){
                s += skrivUtJolle();
            }else s += "ingen";
            return s;
        }
		
       public void nyBåt( Båt ny )
   {
      if ( ny == null )
       return;

     if ( jolle == null )
       jolle = ny;
     else
     {
       Båt løper = jolle;
       while ( løper.neste != null )
         løper = løper.neste;
      løper.neste = ny;
     }
   }
    
    public Båt finnBåt(String regNr){
            Båt node = jolle;
            if (node == null)          
                    return null;
		
            while (node != null) {
                if (node.getRegNr().equals(regNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
        }
    
    public boolean slettBåt(String regNr){
        Båt fjernBåt = finnBåt(regNr);    
        System.out.println(regNr);
        Båt løper = jolle;
        if(løper == null){
            return false;
        }// denne feilmeingen kommer aldri
        if(løper == fjernBåt){
            jolle = løper.neste;
            return true;
        }
        while(løper.neste != null){
            if (løper.neste == fjernBåt){
                løper.neste = løper.neste.neste;
                return true;
            }
            løper = løper.neste;
        }return false;
        }
    
        public Båt getBåt()
        {
          return jolle;
         }
  
    public String skrivUtJolle(){
        String s = "";
        Båt løper = jolle;
        if(løper == null) return "Ingen Båter i registeret";
        if(løper.neste == null) return løper.toString();
        
        while(løper != null){
            s += løper.toString();
            løper = løper.neste;
        }
        return s;
    }

    }


	
