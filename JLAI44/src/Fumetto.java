import java.time.LocalDate;

public class Fumetto extends Pubblicazione {
	
	//ATTRIBUTI
	private String disegnatore;
	private boolean acolori;
	
	
	
	//COSTRUTTROI
	public Fumetto(String nome, LocalDate datapubblicazione, String disegnatore, boolean acolori) {
		super(nome, datapubblicazione);
		this.disegnatore = disegnatore;
		this.acolori = acolori;
	}



	//GETTER AND SETTER
	public String getDisegnatore() {
		return disegnatore;
	}



	public void setDisegnatore(String disegnatore) {
		this.disegnatore = disegnatore;
	}



	public boolean getAcolori() {
		return acolori;
	}



	public void setAcolori(boolean acolori) {
		this.acolori = acolori;
	}
	
	public void sconto () {
		
		int sconto = 1;
		System.out.println("Prezzo scontato: " + (super.getPrezzo() - sconto) + " euro");
		
	}
	
	public void mostrapubblicazione () {
		
		System.out.println("Nome Fumetto: " + super.getNome() 
		+ " Data Pubblicazione: " 
		+ super.getDatapubblicazione() 
		+ " Disegnatore: "  + disegnatore 
		+ " A ciolori: " + acolori);
		
		
	}
	
	
	//METODI

}
