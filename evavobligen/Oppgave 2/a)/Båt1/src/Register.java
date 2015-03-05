import java.util.*;
import javax.swing.JTextArea;


public class Register {
    private Båteier kapteiner;
    private Båt joller;
    
    
    
    public void nyBåteier(Båteier ny){
        Båteier node = kapteiner;
            
        if (node == null){
            node = ny;
        }

        else {
            while (node.neste != null){
                node = node.neste;
            }
            node.neste = ny;
        }
    }
    
    private String nyBåt (Båt b){            
        Båt node = joller;
                       
        if (node == null){		
            node = b;            
        }
                        
        else {               
            while (node.neste != null){                  
                node = node.neste;               
            }               
            node.neste = b;
        }
        return null;
    }
    
    public Båt finnBåt(String regNr){
            Båt node = joller;
            
            if (node == null){
                    return null;
		}
            while (node.neste != null) {
                if (node.getRegNr().equals(regNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
        }
    
    public Båteier finnEier(String medlemsNr){
            Båteier node = kapteiner;
            
            if (node == null){
                    return null;
		}
            while (node.neste != null) {
                if (node.getMedlem().equals(medlemsNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
        }
    
    public String registerNyBåt (Båt b, String medlemsNr){
        
        Båteier be = finnEier(medlemsNr);
           
        if (be == null){
            return "Båten har ingen eier, dette må registreres først!";
        }
        
        if(finnEier(b.getRegNr()) != null){
                
            return b.getRegNr() + " Tidligere registrert båt.";
        }

            be.nyBåt(b);
            b.setEier(medlemsNr);//hush
            return "Da er Båten registrert :D";
	}
    

    
    public void skrivListe(JTextArea båter){
        if (joller == null ){
            båter.append("Ingen båter er registrert");
        }
        if (this.kapteiner == null){
            båter.append("Ingen Kapteiner er registrert");
        }
        else{
            båter.setText("");
            
            Båteier løper = kapteiner;
            while(løper != null){
                båter.append(løper.toString() +""+løper.getBåt().toString()+"+\n");
                løper = løper.neste;
            }
            //skrivTilFil();
        }
        
    }

    public String slettBåt(String regNr){
        Båt båt = (finnBåt(regNr)) ;
        if(båt == null)
            return "Denne båten finnes ikke i registere"; 
        if(båt != null)
            båt.setEier(null);
        
        Båt løper = joller;
        if(løper == null){
            return "Det er ikke registert noen båter";
        }// denne feilmeingen kommer aldri
        if(løper == båt) 
            joller = løper.neste;
        while(løper.neste != null){
            if (løper.neste == båt){
                løper.neste = løper.neste.neste;
                return "Denne båten er nå fjernet";
            }
            
        }return "Denne båten er ikke i registeret";
        }
    
    public String slettEier(String medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        if(eier == null) return "denne personen finnes ikke";
        Båteier forestGump = kapteiner;
        if(forestGump == eier){
            kapteiner = forestGump.neste;
            
        }
        while(forestGump.neste != null){
            if(forestGump.neste == eier){
                forestGump.neste = forestGump.neste.neste;
                return " "+eier.getNavn()+"Denne personen er fjernet";
                // ja vi vet at vi skal ha toString
            }
        }
        return "fant ikke denne personen";
    }
    public String eierData(String medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        return eier.toString();
    }
    
    public String skiftEier(String regNr, String medlemsNr){
        Båteier eier = finnEier(regNr);
        if (eier == null){
            return "Fant ikke eier av " + regNr;
        }
        
        Båteier nyEier = finnEier(medlemsNr);
        if (nyEier == null){
            return "Ny eier må registreres før omreg.!";
        }
        
        
    }
            
            
            
            
            
            public String skiftEier(String regNr, String c){
		Båteier eier = finnEier(regNr);
		if (eier == null) {
			return "Fant ikke eier av " + regNr;
		}
		Båteier nyEier = finn(regNr);
		if (nyEier == null) {
			return "Ny eier må registreres før omreg.";
		}
		nyEier.nyBåt(eier.slettBåt(regNr));
		return "Ny eier på båten er registrert!";
	
	}
    
    
      
}//End of class Register