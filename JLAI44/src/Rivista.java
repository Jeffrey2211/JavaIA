import java.time.LocalDate;

public class Rivista extends Pubblicazione implements Superscontato{
	
    //ATTRIBUTI
	private String casaeditrice;
	private double costoabbonamento;

	//COSTRUTTROI
	public Rivista(String nome, LocalDate datapubblicazione, String casaeditrice, double costoabbonamento) {
		super(nome, datapubblicazione);
		this.casaeditrice = casaeditrice;
		this.costoabbonamento = costoabbonamento;
	}
	
	
	//GETTER AND SETTER
	public String getCasaeditrice() {
		return casaeditrice;
	}

	public void setCasaeditrice(String casaeditrice) {
		this.casaeditrice = casaeditrice;
	}

	public double getCostoabbonamento() {
		return costoabbonamento;
	}

	public void setCostoabbonamento(double costoabbonamento) {
		this.costoabbonamento = costoabbonamento;
	}	
	
	
	
	//METODI
	public void sconto () {
		
		int sconto = 2;
		System.out.println("Prezzo scontato: " + (super.getPrezzo() - sconto) + " euro");
		
	}
	
	public void supersconto () {
		
		System.out.println("Prezzo Super scontato: " + (super.getPrezzo()/3) + " euro");
		
	}
	
	public void mostrapubblicazione () {
		
		System.out.println("Nome Rivista: " + super.getNome() 
		+ " Data Pubblicazione: " 
		+ super.getDatapubblicazione() 
		+ " Casa Editrice: "  + casaeditrice 
		+ " Costo Abbonamento: " + costoabbonamento);
		
	}

}
