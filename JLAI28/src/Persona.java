
/*
 * OGNI ELEMENTO - ATTRIBUTO O METODO
 * IN UNA CVLASSE PU� ESSERE:
 * PUBLIC - VISIBILE DA TUTTE LE CLASSI E TUTTI I METODI DEL PROGRAMMA
 * PRIVATE - VISIBILI ESCLUSIVAMENTE DENTRO LA CLASSE CHE LI GENERA
 * PROTECTED - VISIBILE SOLO ALL'INTERNO DELLO STESSO PACKAGE
 */

/*
 * OGNI ELEMENTO PU� AVERE ANCHE UN'ALTRA CARATTERISTICA
 * PU� ESSERE STATIC O DYNAMIC
 * JAVA SOTTINTENDE SE NON VIENE DETTO CHE L'ELEMENTO SIA DYNAMIC
 */

/*
 * QUANDO UNA CLASSE "FABBRICA" CREA UN OGGETTO (LO ISTANZIA)
 * OGNI OGGETTO HA I SUOI ATTRIBUTI E I SUOI METODI
 * COPIATRI DALLA CLASSE GENERANTE IN MODO DYNAMIC
 * SE INVECE LE CARATTERISTICHE VENGONO CREATE COME STATIC
 * ATTRIBUTI E METODI STATICI NON VENGONO CREATI APPOSITAMENTE PER GLI OGGETTI
 * MA RIMANGONO STATICAMENTE COLLEGATI ALLA CLASSE
 */
public class Persona {
	
	//ATTRIBUTI
	public String nome;
	public int altezza;
	public String coloreocchi;
	private double patrimonio;
	public static String razza = "Umana"; 
	
	//COSTRUTTORI - METODI CON LO STESSO NOME DELLA CLASSE
	//POSSO AVERNE PI� DI UNO GRAZIE AL POLIMORFISMO
	
	public Persona() { //COSTRUTTORE VUOTO SE UNICO PU� ESSERE SOTTINTESO
		
	}
	
	public Persona(String nome, int altezza, String coloreocchi, double patrimonio) {
		
		this.nome = nome;
		this.altezza = altezza;
		this.coloreocchi = coloreocchi;
		this.setPatrimonio(patrimonio);
		
	}

	//GETTER AND SETTER
	
	public double getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}
	
	//METODI
	public void presentazione () {
		
		System.out.println("Il mio nome � " + nome);
		System.out.println("Sono alto " + altezza + " cm");
		System.out.println("Il colore dei miei occhi � " + coloreocchi);
		System.out.println("Il mio patrimonio ammonta a " + patrimonio + " euro");
		System.out.println("Sono di razza " + razza);
		
	}
	
	
	

}
