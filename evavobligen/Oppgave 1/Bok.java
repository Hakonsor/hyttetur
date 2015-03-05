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
public abstract class  Bok {
    
    
    private String forfatter;
    private String tittel;
    private int sidetall;
    private double pris;
    Bok neste;
    
    public Bok(){}
    
    public Bok(String forfatter, String tittel, int sidetall, double pris)
    {
    this.forfatter = forfatter;
    this.tittel = tittel;
    this.sidetall = sidetall;
    this.pris = pris;
    }
    public String getForfatter()
    {
		return forfatter;
    }


	public String getTittel()
       {
		return tittel;
       }
        
        public String toString()
        {
            String s = forfatter + "; ";
            s += tittel + "; ";
            s += sidetall + " s., ";
            s += "kr. "+ pris;
            return s;
            
        }
        

        public boolean lesObjektFraFil( DataInputStream input )
        {
            try
            {
            forfatter = input.readUTF();
            tittel = input.readUTF();
            sidetall = input.readInt();
            pris = input.readDouble();
                System.out.println("bok les");
            return true;
            }
            catch(IOException ex)
            {
                System.out.println("finner ikke filen, eller corrupt fil.");
            }   
            return false;
            
                 }
        public void skrivObjektTilFil( DataOutputStream output )
        {
            try
            {
            output.writeUTF(forfatter);
            output.writeUTF(tittel);
            output.writeInt(sidetall);
            output.writeDouble(pris);
            }
            catch(IOException ex)
            {
                System.out.println("Data ble ikke lagret");
            }
        }
}
