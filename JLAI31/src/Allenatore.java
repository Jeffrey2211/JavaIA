
public class Allenatore extends Componente {
	
	//ATTRIBUTI
	public boolean primoallenatore;
	private double moltiplicatore;
	
	//COSTRUTTORI
	public Allenatore(String nome, String cognome, double ingaggio, boolean primoallenatore, double moltiplicatore) {
		
		super(nome, cognome, ingaggio);
		this.primoallenatore = primoallenatore;
		this.setMoltiplicatore(moltiplicatore);
		
	}
	
	//GETTER AND SETTER

	public double getMoltiplicatore() {
		return moltiplicatore;
	}

	public void setMoltiplicatore(double moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}
	
	
	private double calcolaingaggio() {
		
		return super.getIngaggio()*moltiplicatore;
	}
	
	
	//METODI
	public void Presentazione() {
		
		if (primoallenatore) {
		
			System.out.println("Il primo Allenatore: " + nome + " " + cognome + " Ingaggio: " + calcolaingaggio());
			
		} else {
			
			System.out.println("Allenatore: " + nome + " " + cognome + " Ingaggio: " + calcolaingaggio());
			
		}
		
	}

	public double calcolacostocomponente() {
		
		return calcolaingaggio();
		
	}
}
