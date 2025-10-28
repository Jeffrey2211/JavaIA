package Mare;

import Nuoto.Nuotatore;

public class Delfini extends Pesce implements Nuotatore{
	
	//ATTRIBUTI
	public String razzadelfini;
	
	//COSTRUTTORI
	public Delfini(String nomepesce, int numeropinne, int profondita, String razzadelfini) {
		
		super(nomepesce, numeropinne, profondita);
		this.razzadelfini = razzadelfini;
		
	}
	
	
	//GETTER AND SETTER
	
	//METODI
	public void nuotare() {
		
		System.out.println(nomepesce + " da bravo delfini arriva a  una profndit� di " + profondita);
		
	}

}
