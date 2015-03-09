/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package båt2;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author hakon_000
 */


public class Vindu extends JFrame {
    private Register register = new Register();
    
    
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
        medlemsNrField = new JTextField("",10);
        
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
       
       søkBåt = new JButton("Søk etter eier av Båt");
       regBåt = new JButton("Registerer Båt");
       slettBåt = new JButton("Slett Båt");
       registrerNyEier = new JButton("Registrer ny eier på båt");
       
       //misc
       bytteRegLabel = new JLabel("Medlemsnummer til ny eier:");
       bytteRegField = new JTextField(10);
       utskriftsFelt = new JTextArea(20,40);
                
       Container c = getContentPane();
       
       c.setLayout(new FlowLayout());
           
       //bil
       c.add(navnLabel);
       c.add(navnField);
       c.add(adrLabel);
       c.add(adrField );
       c.add(medlemsNrLabel);
       c.add(medlemsNrField);
      
       
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

       c.add(bytteRegLabel);
       c.add(bytteRegField);
       //misc   
       
       c.add(registerEier);
       c.add(slettEier); 
       c.add(regBåt );
       c.add(slettBåt );
       c.add(søkBåt);
       c.add(registrerNyEier);
       c.add( new JScrollPane( utskriftsFelt));
 
       Knappelytter lytter = new Knappelytter();
       
    registrerNyEier.addActionListener(lytter);
    registerEier.addActionListener( lytter );
    slettEier.addActionListener( lytter );
    regBåt.addActionListener( lytter );
    slettBåt.addActionListener( lytter );
    søkBåt.addActionListener(lytter);
    
    register.skrivListe(utskriftsFelt);
    
        setVisible(true);
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  setLocation(200, 200);
     }


    private class Knappelytter implements ActionListener
  {
    @Override
    public void actionPerformed( ActionEvent e )
    {
      if ( e.getSource() == registerEier ){
           try{
          register.nyBåteier(new Båteier(navnField.getText(), adrField.getText()));
          register.skrivListe(utskriftsFelt);
          register.skrivTilFil();
          }
          catch ( NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Ugyldig tegn, FY FY!");
        }
      }
      else if ( e.getSource() == slettEier ){
          try{
            JOptionPane.showMessageDialog(null, register.slettEier(Integer.parseInt(medlemsNrField.getText())));
            register.skrivListe(utskriftsFelt);
            register.skrivTilFil();
            }
            catch ( NumberFormatException nfe ){
                JOptionPane.showMessageDialog(null, "Ugyldig tegn, Skriv inn Heltall i medlemsnummer");
            }
      }
      else if ( e.getSource() == regBåt ){
          try{
            JOptionPane.showMessageDialog(null, register.registerNyBåt(new Båt(regNrField.getText(), merkeField.getText(), fargeField.getText(), Integer.parseInt(årField.getText()), Integer.parseInt(størlseField.getText()), Double.parseDouble(hesteKrefter.getText()) ), Integer.parseInt(medlemsNrField.getText())));
            register.skrivListe(utskriftsFelt);
            register.skrivTilFil();
          }
          catch ( NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Ugyldig tegn, Skriv inn heltall i årsfelt, størrelse og medlemsnr");
        }
      }
      else if ( e.getSource() == slettBåt ){
           try{
            JOptionPane.showMessageDialog(null, register.slettBåt(regNrField.getText()/*,Integer.parseInt( medlemsNrField.getText())*/ )); 
            register.skrivListe(utskriftsFelt);
            register.skrivTilFil();
            }
          catch ( NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Ugyldig tegn, FY FY!");
        }
      }
      else if (e.getSource() == søkBåt){
           try{
           utskriftsFelt.setText(register.finnEier(regNrField.getText()).toString());
           register.skrivTilFil();
           }
          catch ( NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Ugyldig tegn, FY FY!");
        }
      }
      else if (e.getSource() == registrerNyEier){
           try{
           JOptionPane.showMessageDialog(null, register.skiftEier( regNrField.getText(),Integer.parseInt(bytteRegField.getText())));
           register.skrivListe(utskriftsFelt);
           register.skrivTilFil();
           }
          catch ( NumberFormatException nfe ){
            JOptionPane.showMessageDialog(null, "Ugyldig tegn, Skriv inn helltall i ny eier");
        }
      }
       //else if
  }

}
    
}
