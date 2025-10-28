import java.util.ArrayList;
import java.util.Scanner;

/*
		 * ABBIAMO VISTO CHE GLI ARRAYLIST SANNO FARE IL CRUD
		 * HANNO QUINDI LE 4 OPERAZIONI CLASSICHE DI UNA TABELLA
		 * MA UNA TABELLA HA DEI CAMPI BEN DEFINITI
		 * COSA POSSO USARE PER DEFINIRLI?
		 * QUANDO CREO UNA CLASSE E ISTANZIO I SUOI OGGETTI
		 * OGNI ISTANZA HA SEMPRE GLI STESSI ATTRIBUTI, COME
		 * UNA TABELLA AD OGNI RECORD HA SEMPRE LE STESSE COLONNE
		 * 
		 * POSSO QUINDI CREARE UNA LISTA DI ISTANZE DELLO STESSO TIPO
		 * CHE AVRANNO GLI STESSI ATTRIBUTI
		 * OGNI ISTANZA SARà UN RIGO, OGNI ATTRIBUTO SARAà UNA COLONNA
		 * 
		 * LA TABELLA E' QUINDI UNA LISTA DI OGGETTI DELLO STESSO TIPO
		 * 
		 * LISTA -> TABELLA
		 * OGGETTI -> RIGHE
		 * ATTRIBUTI -> COLONNE
		 */
public class ArrayComeTabella {

	//CON I BAFFETTI DELIMITO IL CONTENUTO DELLA LLISTA
	//AI SOLI OGGETTI DI TIPO PERSONA
	//QUESTA LISTA ORA E' PRATICAMENTE UNA TABELLA!
	public static ArrayList<Persona> listapersone = new ArrayList<Persona>();
	public static Scanner InputInt = new Scanner (System.in);
	public static Scanner InputStr = new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("Gestione lista persone");

		int scelta;
		
		do {
			
			scelta = mostramenu();
			faiswitch(scelta);
			
		} while (scelta != 0);
		
		
		

	}


	private static void faiswitch(int scelta) {
		
		switch(scelta) {
		case 1:
			mostralista();
			break;
		case 2:
			inserisciinlista();
			break;
		case 3:
			modificainlista();
			break;
		case 4:
			eliminadalista();
			break;
		case 0:
			break;
			
			default: System.out.println("Attenzione scelta non valida");
		
		}
		
	}


	private static void mostralista() {
		
		for (int i = 0; i < listapersone.size(); i++) {
			
			System.out.print((i+1));
			System.out.print(" - ");
			System.out.print(listapersone.get(i).nome);
			System.out.print(" - ");
			System.out.println(listapersone.get(i).cognome);
			
		}
		
	}


	private static void inserisciinlista() {
		
		System.out.println("Inserisci il nome:");
		String nome = InputStr.nextLine();
		System.out.println("Inserisci il cognome:");
		String cognome = InputStr.nextLine();
		
		listapersone.add(new Persona(nome, cognome));
		
	}


	private static void modificainlista() {
		
		mostralista();
		System.out.println("Inserisci il codice della persona da modificare:");
		int scelta = InputInt.nextInt();
		
		System.out.println("Inserisci nome modificato:");
		String nome = InputStr.nextLine();
		System.out.println("Inserisci cognome modificato:");
		String cognome = InputStr.nextLine();
		
		//CON GET PRENDO LA LINEA GIUSTA
		//ESSENDO GLLI ATTRIBUTI PUBBLICI POSSO MODIFICARLI AL VOLO
		listapersone.set(scelta - 1, new Persona(nome, cognome));
		
//		listapersone.get(scelta-1).
//		listapersone.get(scelta-1).cognome = cognome;
		
		
		
		
	}


	private static void eliminadalista() {
		
		mostralista();
		System.out.println("Inserisci il codice della persona da eliminare:");
		int scelta = InputInt.nextInt();
		
		listapersone.remove(scelta-1);
		
	}


	private static int mostramenu() {
		
		System.out.println("1 Mostra Lista Persone");
		System.out.println("2 Inserisci Persona nella lista");
		System.out.println("3 Modifica Persona nella lista");
		System.out.println("4 Elimina Persona dalla lista");
		System.out.println("0 Esci");
		
		return InputInt.nextInt();
	}

}
