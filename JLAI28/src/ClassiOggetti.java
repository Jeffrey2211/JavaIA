		/*
		 * INTRODUCIAMO LA OOP (OBJECT ORIENTED PROGRAMMING)
		 * FINO AD ORA ABBIAMO CREATO NEL FLUSSO DEL PROGRAMMA
		 * INTERAZIONI UTENTE/PROGRAMMA SU CUI ABBIAMO 
		 * BASATO LA NOSTRA PROGRAMMAZIONE
		 * oRA JAVA MI PERMETTE DI CREARE DELLE CLASSI 
		 * (NUOVE SCATOLE ANCORA PIU' GRANDI)
		 * SIAMO PASSATI DALLE VARIABILI AGLI OGGETTI
		 * ORA LE CLASSI SONO LE "FABBRICHE" DI OGGETTI
		 * OGNI CLASSE POTR� GESTIRE ATTRIBUTI E METODI, MA ANCHE
		 * QUALCOSA DI ORIGINALE 
		 * I COSTRUTTORI E I GETTER AND SETTER
		 */
		
		/*
		 * PERCH� USARE LE CLASSI?
		 * PU� ESSERE MOLTO UTILE NELLA PROGETTAZIONE DI UN SOFTWARE
		 * CREARE DELLE ENTIT� CHE POI POSSANO INTERAGIRE TRA LORO
		 * AD ESEMPIO UN PROGRAMMA DI CONTABILIT� POTREBBE AVERE
		 * UTENTE, FATTURA, CLIENTE, FORNITORE, BOLLA, PAGAMENTO....
		 */
public class ClassiOggetti {

	public static void main(String[] args) {
		
		Persona miapersona = new Persona();
		
		miapersona.nome = "Nicola";
		miapersona.coloreocchi = "castani";
		miapersona.altezza = 178;
		
		Persona altrapersona = new Persona("Pippo", 200, "Azzurri", 10000);
		
		System.out.println(altrapersona.nome);
		System.out.println(altrapersona.altezza);
		System.out.println(altrapersona.coloreocchi);
		System.out.println(altrapersona.getPatrimonio());
		
		System.out.println(miapersona.razza);
		System.out.println(altrapersona.razza);
		System.out.println(Persona.razza);
		
		altrapersona.razza = "Extraterrestre";
		
		System.out.println(miapersona.razza);
		System.out.println(altrapersona.razza);
		System.out.println(Persona.razza);
		
		miapersona.presentazione();
		System.out.println("------------------");
		altrapersona.presentazione();
		
		
	}

}
