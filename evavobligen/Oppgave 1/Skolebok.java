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

class Skolebok extends Bok
{
	private int klassetrinn;
	private String skolefag;
        public Skolebok(){}
        

	public Skolebok( String f, String t,int sider, double p, int kt, String fag )
        {
		super( f, t, sider, p );
		klassetrinn = kt;
		skolefag = fag;
	}

	public String toString()
        {
		String s = super.toString();
		s += "; trinn: " + klassetrinn;
		s += ", " + skolefag;
		return s;
	}
        
                @Override
        public boolean lesObjektFraFil( DataInputStream input )
        {
            try{
            if(super.lesObjektFraFil(input))
            {
               skolefag = input.readUTF(); 
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
                output.writeUTF("Skolebok");
                super.skrivObjektTilFil(output);
                output.writeUTF(skolefag); 
            }
            catch( IOException e)
            {
                System.out.println("utskriftfeil i skolebok");
            }
        }
}