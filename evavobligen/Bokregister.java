/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evavobligen;
import java.io.*;
/**
 *
 * @author hakon_000
 */
import javax.swing.JTextArea;

public class Bokregister
{
  private Bok første;
  private String filnavn = "bokregister.txt";
  
 public Bokregister()
 {
     lesFil();
 }
 public Bokregister(String filnavn)
 {
     this.filnavn = filnavn;
     lesFil();
 }
 
 public void lesFil()
 {
     String type = "";
     try (DataInputStream innfil = new DataInputStream(
             new FileInputStream(filnavn)))
 {
    while(true)
    {
        
        type = innfil.readUTF();
        System.out.println(type);
        Bok b;
        if(type.equals("Fagbok"))
        {
            b = new Fagbok();
            if(b.lesObjektFraFil(innfil)) {settInn(b);}
        }
        else if(type.equals("Skolebok"))
        {
            b = new Skolebok();
            if(b.lesObjektFraFil(innfil))
            {settInn(b);}
        }
        else if(type.equals("NorskRoman"))
        {
            b = new NorskRoman();
            if(b.lesObjektFraFil(innfil))
            {settInn(b);}
        }
        else if(type.equals("UtenlandsRoman"))
        {
            System.out.println("fant utenlands");
            b = new UtenlandskRoman();
            if(b.lesObjektFraFil(innfil))
            {settInn(b);}
        }
        
        
    } 
 }
  catch(EOFException ex)
 {
     System.out.println("Ikke flere objekter");
 }
 catch(IOException e)
 {
     System.out.println(type);
     System.out.println("Feil i lesfil while løkke, eller corrup fil");
 }

 }
 
 public void skrivFil()
 {
     try(DataOutputStream ut = new DataOutputStream(new FileOutputStream(filnavn)))
        {
        if (!( første == null ))
        {
      Bok løper = første;
      while ( løper != null )
      {
        løper.skrivObjektTilFil(ut);
        løper = løper.neste;
      }
    }

        }
        catch (IOException e)
        {
            System.out.println("FAEN");
        }
     
 }

  //registrerer et bokobjekt
  public void settInnForrest( Bok ny )  // sortert
  { if(ny == null) return;
    ny.neste = første;
    første = ny;
  }
  public void settInn( Bok ny )
	{
    if( ny == null ) return;

    if( første == null ) // tom liste:
    {
      første = ny;
      return;
    }
					// objektet skal inn forrest:
    if( ( ny.getForfatter().compareToIgnoreCase( første.getForfatter() ) == 0 &&
          ny.getTittel().compareTo( første.getTittel() ) < 0 )
		 || ( ny.getForfatter().compareTo( første.getForfatter() ) < 0 ) )
    {
	    settInnForrest( ny );
      return;
    }

    Bok løper = første;
    while( løper.neste != null )
    {
      if( ( ny.getForfatter().compareTo(løper.neste.getForfatter() ) == 0 &&
            ny.getTittel().compareTo(løper.neste.getTittel() ) < 0 )
       || ( ny.getForfatter().compareTo(løper.neste.getForfatter() ) < 0 ) )
      {
        ny.neste = løper.neste;
        løper.neste = ny;
					  return;
      }
      else
        løper = løper.neste;
    }
   // setter inn boka sist i lista.
    løper.neste = ny;
    
  }


  //utskrift av innhold i bokliste
  public void skrivListe( JTextArea bøker )
  {
    if ( første == null )
      bøker.append( "Ingen bøker registrert." );
    else
    {
      bøker.setText( "" );
      Bok løper = første;
      while ( løper != null )
      {
        bøker.append( løper.toString() + "\n" );
        løper = løper.neste;
      } skrivFil();
    }
  }
}

