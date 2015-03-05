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
abstract class Roman extends Bok
{
	protected String sjanger;
        
        protected Roman(){}

	protected Roman( String f, String t, int sider, double p, String s )
        {
		super( f, t, sider, p );
		sjanger = s;
	}

	public String toString()
        {
		String s = super.toString();
		s += ". Sjanger: " + sjanger;
		return s;
	}
                        @Override
        public boolean lesObjektFraFil( DataInputStream input )
        {
            try{
            if(super.lesObjektFraFil(input))
            {
                sjanger = input.readUTF(); 
                System.out.println("roman les");
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
                
                super.skrivObjektTilFil(output);
                output.writeUTF(sjanger); 
            }
            catch( IOException e)
            {
                System.out.println("utskriftfeil i roman");
            }
        }
}