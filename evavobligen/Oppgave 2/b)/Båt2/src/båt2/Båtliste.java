/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package båt2;

import java.io.Serializable;

public class Båtliste implements Serializable{
    private Båt joller = null;
    public void nyBåt (Båt b){   

        if ( b == null ) return;              
        if (joller == null){		
            joller = b;            
        }
                        
        else {               
            Båt node = joller;
            while (node != null){                  
                node = node.neste;               
            }               
            node = b;
            
        }
    }
    
    public Båt finnBåt(String regNr){
            Båt node = joller;
            if (node == null){           
                    return null;
		}
            while (node != null) {
                if (node.getRegNr().equals(regNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
        }
    public boolean slettBåt(String regNr){
        Båt fjernBåt = finnBåt(regNr);     
        Båt løper = joller;
        if(løper == null){
            return false;
        }// denne feilmeingen kommer aldri
        if(løper == fjernBåt){
            joller = løper.neste;
            return true;
        }
        while(løper.neste != null){
            if (løper.neste == fjernBåt){
                løper.neste = løper.neste.neste;
                return true;
            }
            løper = løper.neste;
        }return false;
        }
    @Override
    public String toString(){
        String s = "";
        Båt løper = joller;
        if(løper == null) return "Ingen Båter i registeret";
        if(løper.neste == null) return løper.toString();
        
        while(løper != null){
            s += løper.toString();
            løper = løper.neste;
        }
        return s;
    }
    public boolean sjekkFlåte(){
    return joller != null;
    }
       
           
    
    }

