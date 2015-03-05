public class Båt extends Node{
	private String regNr;
	private String merke;
	private String farge;
	private int år;
	private int str;
	private double hk;
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
	public String toString(){
		String s = "";
		s += "\tRegNr: " + regNr + "\n";
		s += "\tMerke: " + merke + "\n";
		s += "\tFarge: " + farge + "\n";
		s += "\tÅr: " + år + "\n";
		s += "\tStr: " + str + "\n";
		s += "\tHK: " + hk + "\n";
		return s;
	}
}//End of class Båt