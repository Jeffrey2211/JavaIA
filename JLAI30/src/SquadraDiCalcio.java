import java.util.Scanner;

public class SquadraDiCalcio {
	/*
	*MACROANALISI
	*Gestione di un elenco di giocatori di una squadra
	*Il programma deve avere la possibilità di
	*Inserire un giocatore
	*mostrare tutti i giocatori
	*mostrare i giocatori di un determinato ruolo


	*PROGETTAZIONE
	*Creo una classe Giocatore le cui istanze le inserisco in un array di Giocatore
	*La classe Giocatore deve avere almeno gli attributi:
	*Nome, ruolo, ingaggio (quest'ultimo privato)
	*Tutti i giocatori appartengono alla stessa squadra informazione da palesare sempre!
	*Uso un ciclo for per mostrare tutti i giocatori richiamando un metodo di presentazione giocatore che creo nella classe
	*per filtrare creo un ciclo for con un controllo if
	*Quando mostro tutta la squadra devo mostrare il costo di tutta la squadra
	*Se filtro il costo dei giocatori del ruolo filtrato 
	*/
	
	public static Giocatore[] elencogiocatori = new Giocatore[11];
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);
	public static Scanner inputDouble = new Scanner(System.in);
	public static int posizione = 0;
	public static double totaleingaggio = 0.0;
	

	public static void main(String[] args) {
		
		System.out.println("=== Gestione elenco giocatori ===");
		
		int scelta;
		do {
			
			scelta = mostramenu();
			faiswitch(scelta);
			
		} while (scelta != 0);
		
		

	}


	private static void faiswitch(int scelta) {
		switch(scelta) {
		case 1:
			Inserisciungiocatore();
			break;
		case 2:
			Mostratuttiigiocatori();
			break;
		case 3:
			Mostraigiocatoridiundeterminatoruolo();
			break;
		case 0:
			System.out.println("Sei uscito dal menu!");
			break;
		default:
			System.out.println("Valore non valido!");
			break;
		}
		
	}


	private static void Mostraigiocatoridiundeterminatoruolo() {
		
		System.out.println("Che tipo di giocatori vuoi vuoi vedere?");
		String ruolo = inputString.nextLine();
		double totaleFiltrato = 0;
		

	    for (int i = 0; i < posizione; i++) {
	        totaleFiltrato += elencogiocatori[i].mostraSeRuolo(ruolo);
	    }

	    System.out.println("Totale ruoli filtrati: " + totaleFiltrato + " €");
		
				
	}


	private static void Mostratuttiigiocatori() {
		System.out.println("--- Elenco Giocatori ---");
	    for (int i = 0; i < posizione; i++) {
	        elencogiocatori[i].presentati(); // usa il metodo già presente in Giocatore
	    }
	    System.out.println("Costo totale squadra: " + totaleingaggio + " €");
	}
		


	private static void Inserisciungiocatore() {
		
		System.out.println("Inserisci il nome del giocatore:");
		String nome = inputString.nextLine();
		System.out.println("Inserisci il ruolo del giocatore:");
		String ruolo = inputString.nextLine();
		System.out.println("Inserisci l'ingaggio del giocatore:");
		double ingaggio = inputDouble.nextDouble();
		
		elencogiocatori[posizione] = new Giocatore(nome, ruolo, ingaggio);

		
		totaleingaggio += elencogiocatori[posizione].getIngaggio();
		posizione++;
		
		System.out.println("Giocatore inserito");
	}

		


	private static int mostramenu() {
		 System.out.println("1 Inserisci un giocatore");
		 System.out.println("2 Mostra tutti i giocatori");
		 System.out.println("3 Mostra i giocatori di un determinato ruolo");
		 System.out.println("0 Esci");
		 System.out.println("Scegli opzione: ");
		 
		 return inputInt.nextInt();
	}

}
