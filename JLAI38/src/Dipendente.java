
public class Dipendente {
	
	//ATTRIBUTI
	public int id;
	public String nome;
	public String cognome;
	public String mansione;
	public double stipendio;
	
	//COSTRUTTORI
	public Dipendente(int id, String nome, String cognome, String mansione, double stipendio) {
		
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.mansione = mansione;
		this.stipendio = stipendio;
		
	}
	
	//GETTER AND SETTER
	
	//METODI
	public void mostradipendente() {
		
		System.out.print("ID: " + id);
		System.out.print(" - Nome: " + nome);
		System.out.print(" - Cognome: " + cognome);
		System.out.print(" - Mansione: " + mansione);
		System.out.println(" - Stipendio: " + stipendio);
		
	}
	

}
