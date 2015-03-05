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
class NorskRoman extends Roman
{
	private String målform;
        public NorskRoman(){}

	public NorskRoman( String f, String t,  int s, double p, String sj, String m )
        {
		super( f,t, s, p, sj );
		målform = m;
	}

	public String toString()
        {
		String s = super.toString();
		s += ". " + målform;
		return s;
	}
                                @Override
        public boolean lesObjektFraFil( DataInputStream input )
        {
            try{
            if(super.lesObjektFraFil(input))
            {
               målform = input.readUTF(); 
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
                output.writeUTF("NorskRoman");
                super.skrivObjektTilFil(output);
                output.writeUTF(målform); 
            }
            catch( IOException e)
            {
                System.out.println("utskriftfeil i norskroman");
            }
        }
}