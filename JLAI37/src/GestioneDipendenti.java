/*
 * GESTIONE DI UNA LISTA DI DIPENDENTI

 *Crea un file csv che contenga un elenco di dipendenti con i seguenti campi (usa come comma il ;)
 *ID, NOME, COGNOME, MANSIONE, STIPENDIO
 *inizialmente di 5 dipendenti

 *Nel programma crea un arraylist di array di strighe che leggano il file come nell'esempio

 *crea quindi un menu CRUD per la gestione delle informazioni
 *NB: ricorda che sul file sono tutte stringhe!!!

 *aggiungi un menu salva prima del menu chiudi
 *Salva va a sovrascrivere il file iniziale.

 *Difficoltà 0: Come nell'esempiio
 *Difficoltà 1: Crea metodi separati per la lettura e la scrittura richiamati da main
 *Difficoltà 2: Crea una classe lettore e una classe scrittore per gestire letture e scritture del file
 *Difficoltà 3: Crea un'unica classe LeggiScrivi per gestire le operazioni sul file
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class GestioneDipendenti {
	
public static ArrayList<String[]> listadipendenti = new ArrayList<String[]>();

public static Scanner InputInt = new Scanner (System.in);
public static Scanner InputStr = new Scanner (System.in);

public static String InDipendenti = "Dipendenti.csv";
public static String OutDipendenti = "Dipendenti_Aggiornato.csv";


	public static void main(String[] args) throws IOException {
		
		leggidipendenti();
		
		int scelta;
		do {
			
			scelta = mostarmenu();
			
			faiswitch(scelta);

		} while(scelta != 0);
		
		scividipendenti();
		
		
	}

	private static void scividipendenti() throws IOException{
		
		PrintWriter scrittore = new PrintWriter(new FileWriter(OutDipendenti, false));
		for (int i = 0; i < listadipendenti.size(); i++) {
			
			//OGNI ELEMENTO LO METTO IN UNA ARRAY
			String[] riga = listadipendenti.get(i);
			//SCRIVO NEL FILE SEPARANDO I VALORI DELL'ARRAY RIGA CON UN COMMA ;
			scrittore.println(String.join(";", riga));//MI PORTO SULLA NUOVA RIGA PER SCRIVERE LA PROSSIMA
			
		}
		
		scrittore.close(); //SALVATAGGIO
		
	}

	private static void leggidipendenti() throws IOException{
		BufferedReader lettore = new BufferedReader(new FileReader(InDipendenti));
		String linea;
        //CICLO INDEFINITO PERCH� NON SO QUANTO E' GRANDE IL FILE
		while ((linea = lettore.readLine()) != null) { //FINO A QUANDO NON TRO LINEE NULLE
			
			//POSSO CREARE NEL POSTO DELLA LISTA
			//NON UNA SOLA VARIABILE, MA UN ARRAY
			//FACENDO SPLIT PER UN CARATTERE SULLA LINEA
			listadipendenti.add(linea.split(";")); //CREA UN ARRAY (DI STRINGHE)
			
		}
		lettore.close();//SALVATAGGIO
	}

	private static int mostarmenu() {
		System.out.println("1 Mostra Lista Dipendenti");
		System.out.println("2 Inserisci Dipendente nella lista");
		System.out.println("3 Modifica Dipendente nella lista");
		System.out.println("4 Elimina Dipendente dalla lista");
		System.out.println("0 Esci");
		
		return InputInt.nextInt();
	}

	private static void faiswitch(int scelta) {
		switch(scelta) {
		
		case 1:
			mostralistadipendenti();
			break;
		case 2:
			inseriscidipendente();
			break;
		case 3:
			modificadipendente();
			break;
		case 4:
			eliminadipendente();
			break;
		case 0:
			break;
		default:
			System.out.println("Attenzione scelta sbagliata");
			break;
		}
		
	}

	private static void mostralistadipendenti() {
		
	
		for (int i = 0; i < listadipendenti.size(); i++) {
			
			String[] riga = listadipendenti.get(i);
			//POI CICLO ALL'INTERNO DELLA RIGA I VALORI DELL'ARRAY (COLONNE)
			for (int l = 0; l < riga.length; l++) {
				
				System.out.print(riga[l]);
				if (l < riga.length - 1) {
				System.out.print(" - ");
				}
			}
			System.out.println(); //va a capo dopo ogni riga
	    }
	}

	private static void inseriscidipendente() {
		
		mostralistadipendenti();
		
		System.out.println("Inserisci nuovo dipendente");
	    System.out.println("Inserisci ID:");
	    String id = InputStr.nextLine();
	    System.out.println("Inserisci Nome:");
	    String nome = InputStr.nextLine();
	    System.out.println("Inserisci Cognome:");
	    String cognome = InputStr.nextLine();
	    System.out.println("Inserisci Mansione:");
	    String mansione = InputStr.nextLine();
	    System.out.println("Inserisci Stipendio:");
	    String stipendio = InputStr.nextLine();

	    // Crea un array di stringhe con i valori
	    String[] nuovo = { id, nome, cognome, mansione, stipendio };
	    listadipendenti.add(nuovo); // Aggiunge l’array alla lista principale
	    
	}

	private static void modificadipendente() {
		
		mostralistadipendenti();

	    System.out.println("Inserisci il numero della riga del dipendente da modificare:");
	    int scelta = InputInt.nextInt();
	    InputStr.nextLine(); // pulisce il buffer

	    System.out.println("Inserisci nome modificato:");
	    String nome = InputStr.nextLine();
	    System.out.println("Inserisci cognome modificato:");
	    String cognome = InputStr.nextLine();
	    System.out.println("Inserisci mansione modificata:");
	    String mansione = InputStr.nextLine();
	    System.out.println("Inserisci stipendio modificato:");
	    String stipendio = InputStr.nextLine();

	    // Mantieni lo stesso ID
	    String[] vecchio = listadipendenti.get(scelta - 1);
	    String id = vecchio[0];
	    String[] nuovo = { id, nome, cognome, mansione, stipendio };

	    listadipendenti.set(scelta - 1, nuovo);

	    System.out.println("Dipendente modificato con successo!");
		
	}

	private static void eliminadipendente() {
		
		mostralistadipendenti();
	
		System.out.println("Inserisci il codice ID della persona da eliminare:");
		int scelta = InputInt.nextInt();
		
		listadipendenti.remove(scelta-1);
		
	}

}
