
public class Dirigente extends Componente {
	
	//ATTRIBUTI
	public String competenza;
	private int mesiingaggio;
	
	//COSTRUTTORI
	public Dirigente(String nome, String cognome, double ingaggio, String competenza, int mesiingaggio) {
		super(nome, cognome, ingaggio);

		this.competenza = competenza;
		this.setMesiingaggio(mesiingaggio);
	}

	//GETTER AND SETTER
	
	public int getMesiingaggio() {
		return mesiingaggio;
	}

	public void setMesiingaggio(int mesiingaggio) {
		this.mesiingaggio = mesiingaggio;
	}
	
	
	private double dividiingaggio() {
	
		
		
		return super.getIngaggio()/12*mesiingaggio;
		
	}
	
	
	//METODI
	public void Presentazione() {
		System.out.println("Dirigente: " + nome + " " + cognome + " Ingaggio: " + dividiingaggio());
	}

	
	public double calcolacostocomponente() {
		
		return dividiingaggio();
		
	}

}
