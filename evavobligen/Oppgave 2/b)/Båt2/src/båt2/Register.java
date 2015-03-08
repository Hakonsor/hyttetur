package båt2;


import java.io.*;
import java.util.*;
import javax.swing.JTextArea;


public class Register {
    
    private Båteier kapteiner;
    private Båt joller;
    
    public Register()   {
        kapteiner = null;
        joller = null;
        
        lesOppfil();
        if( kapteiner != null)
            kapteiner.setStaticNR(sisteKaptein());
    }
    
    public void nyBåt (Båt b){   
        if ( b == null ) return;              
        if (joller == null){		
            joller = b;            
        }
                        
        else {               
            Båt node = joller;
            while (node.neste != null){                  
                node = node.neste;               
            }               
            node.neste = b;
        }
        
    }

    public int sisteKaptein(){
    
        Båteier løper = kapteiner;
       
        
        if( kapteiner == null)
            return 999;
        else{
            while(løper.neste != null)
                løper = løper.neste;
                return løper.getMedlem()+1;
        }
        
                
          
        
        
    }
    
    public Båt finnBåt(String regNr){
            Båt node = joller;
            if (node == null){           
                    return null;
		}
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
    
    public void nyBåteier(Båteier ny){
        if ( ny == null ) return;
        
       
            
        if (kapteiner == null){
            kapteiner = ny;
        }
         

        else {
                Båteier node = kapteiner;
            while (node.neste != null){
                node = node.neste;
            }
            node.neste = ny;
        }
        
        
    }
    
    public Båteier finnEier(int medlemsNr){
            Båteier node = kapteiner;
            
            if (node == null){
                System.out.println("noden finnes ikke");
                    return null;
		}
            if(node.getMedlem() == medlemsNr){
                return node;
            }
            
            while (node.neste != null) {
                if (node.getMedlem() == medlemsNr){
                    return node;
                }
                else{
                    node = node.neste;
                    if(node.getMedlem() == medlemsNr)
                        return node;
                }
            }
            
            return null;
        }
    
    public String registerNyBåt (Båt b, int medlemsNr){
        
        Båteier eier = finnEier(medlemsNr);
        String regNr = b.getRegNr();
        Båt ulovligBåt = finnBåt(regNr);
        
           
        if (eier == null)
            return "Båten har ingen eier, dette må registreres først!";
        
        if(ulovligBåt != null)
            return "Denne båten har allerede en eier! FY";
        
            eier.nyBåt(b);
            b.setEier(medlemsNr);//hush
            nyBåt(b);
            return "Da er Båten registrert :D";
	}
    
    public void skrivListe(JTextArea utSkrift){
        utSkrift.setText("");
        if (joller == null ){
            utSkrift.append("Ingen båter er registrert\n");
        } 
        if (kapteiner == null){
            utSkrift.append("Ingen Kapteiner er registrert\n");
        }
        else{

            Båteier løper = kapteiner;

            String s = "";
            if(løper.neste == null)
                s = løper.toString();
            
            while(løper.neste != null){
                 s += (løper.toString());
                 løper = løper.neste;
            }
                utSkrift.append(s+"\n");  
            //skrivTilFil();
        }
    }
    
    public String slettBåt(String regNr){
          
        Båt båt = (finnBåt(regNr)) ;
        if(båt == null)
            return "Denne båten finnes ikke i registere"; 
        
        Båteier eier = finnEier(båt.getEier());
        eier.fjernBåt(regNr);
       
        båt.setEier(0);
           
        Båt løper = joller;
        if(løper == null){
            return "Det er ikke registert noen båter";
        }// denne feilmeingen kommer aldri
        
        if(løper == båt){
            joller = løper.neste;
            return "Denne båten er nå fjernet";
    }
        
        while(løper.neste != null){
            if (løper.neste == båt){
                løper.neste = løper.neste.neste;
                return "Denne båten er nå fjernet";
            }
        }
        return "Denne båten er ikke i registeret";
        }
    
    public String slettEier(int medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        if(eier == null) 
            return "Denne personen finnes ikke";
        
        if(eier.sjekkFlåte() == false)
            return "Båt må fjernes før eier kan fjernes";
        
        Båteier forestGump = kapteiner;
        if(forestGump == eier){
            
            kapteiner = forestGump.neste;
            return eier.getNavn()+" er nå slettet.";
        }
        while(forestGump.neste != null){
            if(forestGump.neste.equals(eier)){
                forestGump.neste = forestGump.neste.neste;
                return " "+eier.getNavn()+" er nå slettet.";
                // ja vi vet at vi skal ha toString
            }
            forestGump = forestGump.neste;
        }
        
        return "fant ikke denne personen";
    }
    
    public String eierData(int medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        return eier.toString();
    }
    
    public String skiftEier(String regNr, int medlemsNr){
        
        Båt båt = finnBåt(regNr);
        if(båt == null)
            return "Finner ikke båt";
        
        Båteier eier = finnEier(båt.getEier());
        Båteier nyEier = finnEier(medlemsNr);
                
        if (nyEier == null)
            return "Finner ikke den nye eieren!";
      
        nyEier.nyBåt(båt);
        eier.fjernBåt(båt.getRegNr());
        båt.setEier(nyEier.getMedlem());
           
        return nyEier.getNavn()+" Har nå båten "+båt.getRegNr();

	}
    
    public void skrivTilFil(){
        try(ObjectOutputStream utfil = new ObjectOutputStream(
                               new FileOutputStream( "Båt.dta" ) ))
        {
         utfil.writeObject( kapteiner );
         utfil.writeObject( joller );
        }
        catch( IOException ex){
            System.out.println("nor dette funker");
        }  
    }
    
    public void lesOppfil(){
      try( ObjectInputStream innfil = new ObjectInputStream(
                               new FileInputStream( "Båt.dta" ) )){
          
      Båteier båteier = (Båteier) innfil.readObject();
      Båt båt = (Båt) innfil.readObject();
      kapteiner = båteier;
      joller = båt;
      
      }
      catch(ClassNotFoundException e){
          System.out.println("nope");
      }
      catch(IOException ex){
          System.out.println("");
      }
    
    
    }
}//End of class Registe