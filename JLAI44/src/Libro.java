import java.time.LocalDate;

public class Libro extends Pubblicazione implements Superscontato{
	
	//ATTRIBUTI
	private String autore;
	private boolean copertinarigida;
	
	//COSTRUTTORE
	public Libro(String nome, LocalDate datapubblicazione, String autore, boolean copertinarigida) {
		super(nome, datapubblicazione);
		this.autore = autore;
		this.copertinarigida = copertinarigida;
	}

	
	//GETTER AND SETTER
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public boolean getCopertinarigida() {
		return copertinarigida;
	}

	public void setCopertinarigida(boolean copertinarigida) {
		this.copertinarigida = copertinarigida;
	}
	
	
	
	
	//METODI
	public void sconto () {
		
		int sconto = 3;
		System.out.println("Prezzo scontato: " + (super.getPrezzo() - sconto) + " euro");
		
	}
	
	public void supersconto () {
		
		System.out.println("Prezzo Super scontato: " + (super.getPrezzo()/2) + " euro");
		
	}
	
	public void mostrapubblicazione () {

		System.out.println("Nome Libro: " + super.getNome() 
		+ " Data Pubblicazione: " 
		+ super.getDatapubblicazione() 
		+ " Autore: "  + autore 
		+ " Copertina rigida: " + copertinarigida);
		
	}

}
