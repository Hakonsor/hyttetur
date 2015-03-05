import java.util.*;


public class Båteierliste {
	private Båteier node;
	
	
	public Båteierliste(){
		node = null;
	}

	public void nyBåteier(Båteier ny){
		if (node == null){
			node = ny;
		}

		else {
			Båteier ekstra = node;
			
			while (ekstra.neste != null) {
				ekstra = ekstra.neste;
			}
			ekstra.neste = ny;
		}
	}
	public String nyBåt (Båt b, String eier){
		Båteier be = finn (eier);
		if (be == null) {
			return "Båten har ingen eier, dette må registreres først!";
		}
		if (finnEier(b.getRegNr()) != null) {
			return b.getRegNr() + " tidligere registrert.";
		}
		be.nyBåt(b);
		return "Da er Båten registrert :D";
	}
	
	public Båteier finn(String medlemsNr){
		if (node == null){
			return null;
		}
		Båteier ekstra = node;
		
		while (ekstra != null) {
			if (ekstra.getMedlem().equals(medlemsNr)) {
				return ekstra;
			} else {
				ekstra = ekstra.neste;
			}
		}
		return ekstra;
	}
	
	public Båteier slettBåteier(String medlemsNr){
		if (node == null) {
			return null;
		}
		if (node.getMedlem().equals(medlemsNr)) {
			if (!node.eierBåt()) {
				Båteier slettet = node;
				node = node.neste;
				return slettet;
			}
			else {
				return null;
			}
		}
		Båteier ekstra = node;
		
		while (ekstra.neste != null && !ekstra.neste.getMedlem().equals(medlemsNr)) {
			ekstra = ekstra.neste;
		}
		
		if (ekstra.neste != null && !ekstra.neste.eierBåt()) {
			Båteier slettet = ekstra.neste;
			ekstra.neste = ekstra.neste.neste;
			return slettet;
		}
		else {
			return null;
		}
	}
	
	public Båt slettBåt(String regNr){
		Båteier eier = finnEier(regNr);
		if (eier != null){
			return eier.slettBåt(regNr);
		}
		else {
			return null;
		}
	}
	
	public String getEier(String medlemsNr){
		Båteier be = finn(medlemsNr);
		if (be != null) {
			return be.toString() + "\n" + be.getBåt();
		}
		else {
			return "Finner ikke eieren av båten!";
		}
	}
	
	public String skrivBåtEierListe(){
		if (node == null) {
			return "Listen er tom";
		}
		else {
			Båteier ekstra = node;
			String back = "";
			while (ekstra != null) {
				back += ekstra.toString() + "\n" + ekstra.getBåt() + "\n";
				ekstra = ekstra.neste;
			}
			return back;
		}
	}
	
	public Båteier finnEier(String regNr){
		if (node == null) {
			return null;
		}
		Båteier ekstra = node;
		while (ekstra != null) {
			Båt b = ekstra.finn(regNr);
			if (b != null) {
				return ekstra;
			}
			ekstra = ekstra.neste;
		}
		return null;
	}
	
	public String skiftEier(String regNr, String nyMedlemNr){
		Båteier eier = finnEier(regNr);
		if (eier == null) {
			return "Fant ikke eier av " + regNr;
		}
		Båteier nyEier = finn(regNr);
		if (nyEier == null) {
			return "Ny eier må registreres før omreg.";
		}
		nyEier.nyBåt(eier.slettBåt(regNr));
		return "Ny eier på båten er registrert!";
	
	}
	
}//End of class Båteierliste