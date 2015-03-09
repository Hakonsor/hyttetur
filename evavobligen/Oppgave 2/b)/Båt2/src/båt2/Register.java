package båt2;


import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Register {
    private Båteier kapteiner;
    private String fil = "Båt2.txt";
    
    public Register()   {
        kapteiner = null;

        
        lesOppfil();
        if( kapteiner != null)
            kapteiner.setStaticNR(sisteKaptein());
    }
    
    public int sisteKaptein(){
    
        Båteier løper = kapteiner;
        if( kapteiner == null)
            return 9999;
        else{
            while(løper.neste != null)
                løper = løper.neste;
                return løper.getMedlem()+1;
        }  
    }
    
    public Båt finnBåt(String regNr){
        if(kapteiner == null) return null;
        Båteier løper = kapteiner;
        if(løper.neste == null)
            if(løper.finnBåt(regNr) != null)
                return løper.finnBåt(regNr);//sender en båt
        
        while(løper.neste != null){
            if(løper.finnBåt(regNr) != null)
                return løper.finnBåt(regNr);
            løper = løper.neste;
        }
        if(løper.finnBåt(regNr) != null)
                return løper.finnBåt(regNr);
        else return null;
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
    
    public Båteier finnEier(String regNr){
            if(kapteiner == null) return null;
        Båteier løper = kapteiner;
        if(løper.neste == null)
            if(løper.finnBåt(regNr) != null)
                return løper;//sender en båt
        
        while(løper.neste != null){
            if(løper.finnBåt(regNr) != null)
                return løper;
            løper = løper.neste;
        }
        if(løper.finnBåt(regNr) != null)
                return løper;
        else return null;
    
    
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
        
        //finner båteier
        Båteier eier = finnEier(medlemsNr);
        if(eier == null)
               return "Skriv inn gyldig eier";
        
        //leter etter bår i lista
        Båt finnBåt = finnBåt(b.getRegNr());
        
        if(finnBåt != null)
            return "Denne båter har alerede en eier";
        
        eier.nyBåt(b);

        return eier.getNavn()+" har nå blitt tildelt"+b;
	}
    
    public void skrivListe(JTextArea utSkrift){
        utSkrift.setText("");
        
        if (kapteiner == null){
            utSkrift.append("Ingen Kapteiner er registrert\n");
        }
        else{

            Båteier løper = kapteiner;

            if(løper.neste == null)
                utSkrift.append( løper.toString()+"\n");;
            
            while(løper.neste != null){
                  utSkrift.append(løper.toString()+"\n");
                 løper = løper.neste;
                 if(løper.neste == null){
                      utSkrift.append(løper.toString()+"\n");
                      
                 }
            }
        }
    }
    
    public String slettBåt(String regNr){
        
        Båt båt = finnBåt(regNr);
        if(båt == null)
            return "båten finnes ikke i systemet";
        Båteier eier  = finnEier(regNr);
        if(eier == null)
            return "Fant ikke eiern";
        eier.slettBåt(regNr);
        return "Båten er nå slettet";
        }
    
    public String slettEier(int medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        if(eier == null) 
            return "Denne personen finnes ikke";
        
        if(eier.getBåt() != null)
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
    
    public String skiftEier(String regNr, int medlemsNr){
        
        Båt båt = finnBåt(regNr);
        if(båt == null)
            return "Finner ikke båt";
        
        Båteier eier = finnEier(båt.getRegNr());
        if(eier == null)
            return "Finner ikke orginal eier";
        
        Båteier nyEier = finnEier(medlemsNr);
        if (nyEier == null)
            return "Finner ikke den nye eieren!";
      
        nyEier.nyBåt(båt);
        eier.slettBåt(båt.getRegNr());
 
        return nyEier.getNavn()+" Har nå båten "+båt.getRegNr();

       
	}
    
    public void skrivTilFil(){
        try(ObjectOutputStream utfil = new ObjectOutputStream(
                               new FileOutputStream( fil ) ))
        {
         utfil.writeObject( kapteiner );
 
        }
        catch( IOException ex){
            JOptionPane.showMessageDialog(null, "Misslykket lagreing \n"+ ex);
        }  
    }
    
    public void lesOppfil(){
      try( ObjectInputStream innfil = new ObjectInputStream(
                               new FileInputStream( fil ) )){
          
      Båteier båteier = (Båteier) innfil.readObject();
      kapteiner = båteier;
      
      
      }
      catch(ClassNotFoundException e){
          System.out.println(e);
      }
      catch(IOException ex){
          System.out.println(ex);
      }
    
    
    }
}//End of class Registe