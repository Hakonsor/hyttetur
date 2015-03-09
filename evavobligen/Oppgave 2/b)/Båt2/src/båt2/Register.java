package båt2;


import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Register {
    
    private Båteier kapteiner;
    private Båt joller;
    private String fil = "Båt2.txt";
    
    public Register()   {
        kapteiner = null;
        joller = null;
        
        lesOppfil();
        if( kapteiner != null)
            kapteiner.setStaticNR(sisteKaptein());
    }
    
    public void nyBåt( Båt ny ){
      if ( ny == null )
       return;

     if ( joller == null )
       joller = ny;
     else
     {
       Båt løper = joller;
       while ( løper.neste != null )
         løper = løper.neste;
      løper.neste = ny;
         
     }
     ny.neste = null;
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
                if (node.getRegNr().matches(regNr)){
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
            System.out.println("1");
            eier.nyBåt(b);

          
            b.setEier(medlemsNr);//hush
           System.out.println("2");
            nyBåt(b);
            System.out.println("3");
            return "Da er Båten registrert";
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
          
        Båt båt = (finnBåt(regNr)) ;
        
        if(joller == null)
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
            løper = løper.neste;
        }
        return "Denne båten er ikke i registeret";
        }
    
    public String slettEier(int medlemsNr){
        Båteier eier = finnEier(medlemsNr);
        if(eier == null) 
            return "Denne personen finnes ikke";
        
        if(eier.sjekkFlåte() == true)
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
                               new FileOutputStream( fil ) ))
        {
         utfil.writeObject( kapteiner );
         utfil.writeObject( joller );
        }
        catch( IOException ex){
            JOptionPane.showMessageDialog(null, "Misslykket lagreing \n"+ ex);
        }  
    }
    
    public void lesOppfil(){
      try( ObjectInputStream innfil = new ObjectInputStream(
                               new FileInputStream( fil ) )){
          
      Båteier båteier = (Båteier) innfil.readObject();
      Båt båt = (Båt) innfil.readObject();
      kapteiner = båteier;
      joller = båt;
      
      }
      catch(ClassNotFoundException e){
          System.out.println(e);
      }
      catch(IOException ex){
          System.out.println(ex);
      }
    
    
    }
}//End of class Registe