
public abstract class Componente {
	
	//ATTRIBUTI
	public String nome;
	public String cognome;
	private double ingaggio;
	
	//COSTRUTTORI
	public Componente (String nome, String cognome, double ingaggio) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.ingaggio = ingaggio;
		
	}

	
	//GETTER AND SETTER
	public double getIngaggio() {
		return ingaggio;
	}

	public void setIngaggio(double ingaggio) {
		this.ingaggio = ingaggio;
	}
		
	
	//METODI
	//UN METODO ASTRATTO HA LE SUE ISTRUZIONI
	//SOLO NELLE CLASSI ESTESE
	public abstract void Presentazione();


	public abstract double calcolacostocomponente();
	
	

}
