
/*
 * UNA CLASSE ESTESA GENERE ISTANZE
 * CHE SONO COMUNQUE OGGETTI DELLA SUPERCLASSE!
 * UN GIOCATORE E' SEMPRE UN COMPONENTE
 */

public class Giocatore extends Componente {
	
	//ATTRIBUTI
	public String ruolo;
	public int numeromaglia;	
	private double bonus;
	
	//COSTRUTTORI
	public Giocatore(String nome, String cognome, double ingaggio, String ruolo, int numeromaglia, double bonus) {
		
		super(nome, cognome, ingaggio);
		this.ruolo = ruolo;
		this.numeromaglia = numeromaglia;
		this.setBonus(bonus);
		
	}

	//GETTER AND SETTER
	
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	private double sommaingaggiobonus() {
		return super.getIngaggio() + bonus;
	}
	

	//METODI
	public void Presentazione() {
		System.out.println("Giocatore: " + nome + " " + cognome + " Ingaggio: " + sommaingaggiobonus());
	}
	
	
	public double calcolacostocomponente() {
	
		return sommaingaggiobonus();
		
	}
	

}
