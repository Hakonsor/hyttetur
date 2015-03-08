/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package båt2;


import javax.swing.JFrame;

/**
 *
 * @author hakon_000
 */
public class Båt2 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[]args){
        
        Vindu v = new Vindu();
        
        v.setVisible(true);
        v.setSize(500, 500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}

