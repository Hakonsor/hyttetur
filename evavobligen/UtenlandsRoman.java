/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evavobligen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author hakon_000
 */
class UtenlandskRoman extends Roman
{
	private String språk;
        
       
        public UtenlandskRoman()
        {}
        
	public UtenlandskRoman( String f, String t,  int s, double p, String sj, String sp )
        {
		super( f, t, s, p, sj );
		språk = sp;
	}
 	public String toString() {
		String s = super.toString();
		s += ". " + språk;
		return s;
	}
                                @Override
        public boolean lesObjektFraFil( DataInputStream input )
        {
            try{
            if(super.lesObjektFraFil(input))
            {
               
                språk = input.readUTF(); 
                System.out.println("les utenlandsroman");
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
                output.writeUTF("UtenlandsRoman");
                super.skrivObjektTilFil(output);
                output.writeUTF(språk); 
            }
            catch( IOException e)
            {
                System.out.println("utskriftfeil i roman");
            }
        }
}
