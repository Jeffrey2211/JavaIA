
public class Giocatori {
	
	//ATTRIBUTI
	public int id;
	public String nome;
	public String cognome;
	public String ruolo;
	public double altezza;
	public double peso;
	public double ingaggio;
	public boolean extracomunitario;
	
	//COSTRUTTI
	public Giocatori(int id, String nome,String cognome, String ruolo, double altezza, double peso, double ingaggio, boolean extracomunitario) {
		this.id = id;
		this.nome = nome;
		this.cognome =cognome;
		this.ruolo = ruolo;
		this.altezza = altezza;
		this.peso = peso;
		this.ingaggio = ingaggio;
		this.extracomunitario = extracomunitario;
	}
	
	//METODO
	public void mostragiocatori() {
		
		System.out.print("ID: " + id);
		System.out.print(" - Nome: " + nome);
		System.out.print(" - Cognome: " + cognome);
		System.out.print(" - Ruolo: " + ruolo);
		System.out.println(" - Altezza: " + altezza);
		System.out.println(" - Peso: " + peso);
		System.out.println(" - Ingaggio: " + ingaggio);
		System.out.println(" - Extracomunitario: " + extracomunitario);
		
	}

}
