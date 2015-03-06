package Båt1;

import java.io.Serializable;

public class Båt implements Serializable{
    
	private String regNr;
	private String merke;
	private String farge;
	private int år;
	private int str;
	private double hk;
        private int medlemmEier;
	Båt neste;
	
	public Båt (String nr, String m, String f, int å, int s, double h){
		regNr = nr;
		merke = m;
		farge = f;
		år = å;
		str = s;
		hk = h;
	}
	
	public String getRegNr(){
		return regNr;
	}
        
        public int getEier(){
            return medlemmEier;
        }
        
        public void setEier(int e){
            medlemmEier = e;
        }
	public String toString(){
		String s = "\n";
		s += "RegNr: " + regNr + "";
		s += "\tMerke: " + merke + "\n";
		s += "Farge: " + farge + "";
		s += "\tÅr: " + år + "\n";
		s += "Str: " + str + "";
		s += "\tHK: " + hk + "\n";
		return s;
	}
}//End of class Båt