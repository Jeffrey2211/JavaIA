import java.time.LocalDate;

public abstract class Pubblicazione {
	
	//ATTRIBUTI
	private String nome;
	private LocalDate datapubblicazione;
	private double prezzo = 10;
	private String tipo;
	
	
	//COSTRUTTORI
	public Pubblicazione(String nome, LocalDate datapubblicazione) {
		this.nome = nome;
		this.datapubblicazione = datapubblicazione;
	}


	
	//GETTER AND SETTER
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDatapubblicazione() {
		return datapubblicazione;
	}


	public void setDatapubblicazione(LocalDate datapubblicazione) {
		this.datapubblicazione = datapubblicazione;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	//METODI
	public abstract void sconto ();
	
	public abstract void mostrapubblicazione ();
	
	public void supersconto () {
		
		
	}

}
