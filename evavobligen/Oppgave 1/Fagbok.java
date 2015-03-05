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
class Fagbok extends Bok
{
	private String fagområde;
        private String type = "Fagbok";
        
        public Fagbok()
        {
        
        }

	public Fagbok(   String f, String t, int sider, double p, String omr)
        {
		super( f, t, sider, p );
		fagområde = omr;
                
	}

	public String toString()
        {
		String s = super.toString();
		s += "; " + fagområde;
		return s;
	}
        
        @Override
        public boolean lesObjektFraFil( DataInputStream input )
        {
            try{
            if(super.lesObjektFraFil(input))
            {
               fagområde = input.readUTF(); 
               return true;
            }
            }
            catch (IOException e){
                System.out.println("Finner ikke fil");
            }
            
            return false;
            
        }

        @Override
        public void skrivObjektTilFil( DataOutputStream output )
        {
            try
            {
                output.writeUTF(type);
                super.skrivObjektTilFil(output);
                
                output.writeUTF(fagområde); 
            }
            catch( IOException e)
            {
                System.out.println("utskriftfeil i fagbok");
            }
        }
}


