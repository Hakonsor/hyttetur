/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evavobligen;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author hakon_000
 */
public class Evavobligen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Bokarkiv vindu = new Bokarkiv();
    vindu.addWindowListener(
      new WindowAdapter() {
        public void windowClosing( WindowEvent e )
        {

          System.exit( 0 );
        }
      } );
       /* Bok boka = new Bok();
        //skriveDatafil("boka.txt", boka);
       
        
               try (DataInputStream inn = new DataInputStream(
             new FileInputStream("boka.txt")))
             {
                boka.lesObjektFraFil(inn);
             }
        catch(IOException e)
        {
            System.out.println(" spis mer frukt");
        }
               System.out.println(boka.toString());


}
        // TODO code application logic here
    
    
    public static void skriveDatafil(String filnavn, Bok boka)
    {
        try(DataOutputStream ut = 
                new DataOutputStream(new FileOutputStream(filnavn)))
        {
          ut.writeUTF("Idioeeeeeeet");
          ut.writeUTF("apen");
          ut.writeInt(123);
          ut.writeDouble(20.0);
            System.out.println("skrevet til fil");
          boka.lesObjektFraFil(ut); 
        }
        catch( IOException ex)
        {
            System.out.println("bamse");
        }
        
     */    
    }
   
}
