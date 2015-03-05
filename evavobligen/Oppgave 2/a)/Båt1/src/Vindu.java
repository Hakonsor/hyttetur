/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package båtregister;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author hakon_000
 */


public class Vindu extends JFrame {
    
    //båteier
    private JLabel navnLabel;
    private JLabel adrLabel;
    private JLabel medlemsNrLabel;
    private JTextField navnField;
    private JTextField adrField;
    private JTextField medlemsNrField;
    private JButton registerEier;
    private JButton slettEier;

    //båt
    private JLabel regNrLabelr;
    private JLabel merkeLabel;
    private JLabel fargeLabel;
    private JLabel årLabel;
    private JLabel størelseLabel;
    private JLabel hestekrefterLabel;
    private JTextField regNrField;
    private JTextField merkeField;
    private JTextField fargeField;
    private JTextField årField;
    private JTextField størlseField;
    private JTextField hesteKrefter;
    private JButton regBåt;
    private JButton slettBåt;
    private JButton søkBåt;
    private JButton registrerNyEier;
    
    //misc
    private JLabel bytteRegLabel;
    private JTextField bytteRegField;
    private JTextArea utskriftsFelt;
    
    public Vindu(){
        super("Båtregister");
        
        // eier
        navnLabel = new JLabel("Navn:");
        adrLabel = new JLabel("Adresse:");
        medlemsNrLabel = new JLabel("Medlems Nr");
        navnField = new JTextField(10);
        adrField = new JTextField(10);        
        medlemsNrField = new JTextField(10);
        registerEier = new JButton("Registrer eier");
        slettEier = new JButton("Slett eier");
        
        //båt
       regNrLabelr = new JLabel("RegNr");
       merkeLabel = new JLabel("Merke");
       fargeLabel = new JLabel("Farge");
       årLabel = new JLabel("År");     
       størelseLabel = new JLabel("Størelse");
       hestekrefterLabel = new JLabel("Hestekrefer");       
       regNrField = new JTextField("", 10);      
       merkeField = new JTextField("", 10);  
       fargeField = new JTextField("", 10);  
       årField = new JTextField("", 10);  
       størlseField = new JTextField("", 10);   
       hesteKrefter = new JTextField("", 10);   
       regBåt = new JButton("Registerer Båt");
       slettBåt = new JButton("Slett Båt");
       
       //misc
       bytteRegLabel = new JLabel("Navn:");
       bytteRegField = new JTextField(10);
       utskriftsFelt = new JTextArea(40,40);
                
       Container c = getContentPane();
       
       c.setLayout(new FlowLayout());
           
       //bil
       c.add(navnLabel);
       c.add(navnField);
       c.add(adrLabel);
       c.add(adrField );
       c.add(medlemsNrLabel);
       c.add(medlemsNrField);
       c.add(registerEier);
       c.add(slettEier);
       
       //båt
       c.add(regNrLabelr);
       c.add(regNrField);
       c.add(merkeLabel);
       c.add(merkeField );
       c.add(fargeLabel);
       c.add(fargeField);
       c.add(årLabel);
       c.add(årField);
       c.add(størelseLabel);
       c.add(størlseField);
       c.add(hestekrefterLabel);
       c.add(hesteKrefter);
       c.add(regBåt );
       c.add(slettBåt );
       
       //misc
       c.add(bytteRegLabel);
       c.add(bytteRegField);       
       c.add(utskriftsFelt);
       
       Knappelytter lytter = new Knappelytter();
       
    registerEier.addActionListener( lytter );
    slettEier.addActionListener( lytter );
    regBåt.addActionListener( lytter );
    slettBåt.addActionListener( lytter );
    

     }
    
    private class Knappelytter implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      if ( e.getSource() == registerEier )
            System.out.println("");
      else if ( e.getSource() == slettEier )
            System.out.println("");
      else if ( e.getSource() == regBåt )
            System.out.println("");
      else if ( e.getSource() == slettBåt )
            System.out.println("");
    }
  }
    
    
    
    
    
    
   
    
}
