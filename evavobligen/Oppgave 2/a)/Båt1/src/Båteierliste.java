import java.util.*;


public class Båteierliste {
	private Båteier kapteiner;
	private Båt joller;
	
	private Node nodeType(Node n){
            if(n instanceof Båteier){
                Node node = kapteiner;
                return node;
            }
            else if(n instanceof Båt){
                Node node = joller;
                return node;
            }
                
		return null;
	}
        
        

	public void nyBåteier(Båteier ny){
           // Node node = ny;
            Båteier node = kapteiner;
            
            if (node == null){
		node = ny;
            }

            else {
                while (node.neste != null){
                    node = node.neste;
                }
                node.neste = ny;
            }
        }
        
        
	public String nyBåt (Båt b, String eier){
            Båteier be = finnEier(eier);
            if (be == null){
                return "Båten har ingen eier, dette må registreres først!";
            }
            if(finnEier(b.getRegNr()) != null){
                return b.getRegNr() + " Tidligere registrert båt.";
            }
            Båt node = joller;
            
            if (node == null){
		node = b;
            }
            
            else {
                while (node.neste != null){
                    node = node.neste;
                }
                node.neste = b;
            }
            be.nyBåt(b);
            return "Da er Båten registrert :D";
	}
	
        public Båt finnBåt(String regNr){
            Båt node = joller;
            
            if (node == null){
                    return null;
		}
            while (node.neste != null) {
                if (node.getRegNr().equals(regNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
        }
        
	public Båteier finnEier(String medlemsNr){
            Båteier node = kapteiner;
            
            if (node == null){
                    return null;
		}
            while (node.neste != null) {
                if (node.getMedlem().equals(medlemsNr)){
                    return node;
                }
                else{
                    node = node.neste;
                }
            }
            return null;
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
	/*
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
	*/
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