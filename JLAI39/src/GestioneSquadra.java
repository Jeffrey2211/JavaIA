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



public class GestioneSquadra {
	
public static ArrayList<Giocatori> listaGiocatori = new ArrayList<Giocatori>(); 

public static Scanner InputInt = new Scanner (System.in);
public static Scanner InputStr = new Scanner (System.in);
public static Scanner InputDou = new Scanner (System.in);

	public static void main(String[] args) throws IOException {
		
		//ISTANZIO UN OGGETTO LEGGI SCRIVI
		LeggiScrivi fonte = new LeggiScrivi("ElencoGiocatori.csv");
		//SCARICO LA SUA LISTA NELLA MIA
		listaGiocatori = fonte.getListaGiocatore();
		
		int scelta;
		do {
			
			scelta = mostarmenu();
			
			faiswitch(scelta);

		} while(scelta != 0);
		
		salvamodifiche();
		
		
	}

	private static void leggiGiocatori() throws IOException{

	}

	private static int mostarmenu() {
		System.out.println("1 Mostra Lista Giocatori");
		System.out.println("2 Inserisci Giocatore nella lista");
		System.out.println("3 Modifica Giocatore nella lista");
		System.out.println("4 Elimina Giocatore dalla lista");
		System.out.println("5 Salva modifiche");
		System.out.println("0 Esci");
		
		return InputInt.nextInt();
	}

	private static void faiswitch(int scelta) throws IOException {
		switch(scelta) {
		
		case 1:
			mostralistagiocatore();
			break;
		case 2:
			inseriscigiocatore();
			break;
		case 3:
			modificagiocatore();
			break;
		case 4:
			eliminagiocatore();
			break;
		case 5:
			salvamodifiche();
			break;
		case 0:
			break;
		default:
			System.out.println("Attenzione scelta sbagliata");
			break;
		}
		
	}

	private static void mostralistagiocatore() {
		
		System.out.println("Mostra lista giocatori");
		
		for (int i = 0; i < listaGiocatori.size(); i++) {
			
			listaGiocatori.get(i).mostragiocatori();;
			
		}
	}

	private static void inseriscigiocatore() {
		
	    System.out.println("Inserisci ID:");
	    int id = InputInt.nextInt();
	    InputStr.nextLine(); // pulisce buffer
	    System.out.println("Nome:");
	    String nome = InputStr.nextLine();
	    System.out.println("Cognome:");
	    String cognome = InputStr.nextLine();
	    System.out.println("Ruolo:");
	    String ruolo = InputStr.nextLine();
	    System.out.println("Altezza:");
	    double altezza = InputDou.nextDouble();
	    System.out.println("Peso:");
	    double peso = InputDou.nextDouble();
	    System.out.println("Ingaggio:");
	    double ingaggio = InputDou.nextDouble();
	    System.out.println("Extracomunitario (true/false):");
	    boolean extra = InputStr.nextBoolean();

	    listaGiocatori.add(new Giocatori(id, nome, cognome, ruolo, altezza, peso, ingaggio, extra));
	    
	}

	private static void modificagiocatore() {
		
		mostralistagiocatore();

	    System.out.println("Inserisci il numero della riga del giocatore da modificare:");
	    int scelta = InputInt.nextInt();
	    InputStr.nextLine(); // pulisce il buffer

	    // Prendo l'oggetto Giocatori dalla lista
	    Giocatori g = listaGiocatori.get(scelta - 1);

	    System.out.println("Inserisci nome modificato:");
	    String nome = InputStr.nextLine();
	    System.out.println("Inserisci cognome modificato:");
	    String cognome = InputStr.nextLine();
	    System.out.println("Inserisci ruolo modificato:");
	    String ruolo = InputStr.nextLine();
	    System.out.println("Inserisci altezza modificata:");
	    double altezza = InputDou.nextDouble();
	    System.out.println("Inserisci peso modificato:");
	    double peso = InputDou.nextDouble();
	    System.out.println("Inserisci ingaggio modificato:");
	    double ingaggio = InputDou.nextDouble();
	    System.out.println("Extracomunitario (true/false):");
	    boolean extra = InputStr.nextBoolean();

	    // Aggiorno i campi dell'oggetto
	    g.nome = nome;
	    g.cognome = cognome;
	    g.ruolo = ruolo;
	    g.altezza = altezza;
	    g.peso = peso;
	    g.ingaggio = ingaggio;
	    g.extracomunitario = extra;

	    System.out.println("Giocatore modificato con successo!");
		
	}

	private static void eliminagiocatore() {
		
	    // Mostro la lista dei giocatori
	    mostralistagiocatore();

	    // Chiedo all'utente l'ID del giocatore da eliminare
	    System.out.println("Inserisci l'ID del giocatore da eliminare:");
	    int id = InputInt.nextInt();
	    InputInt.nextLine(); // pulisco il buffer dopo nextInt()

	    // Cerco il giocatore nella lista
	    boolean trovato = false;
	    for (int i = 0; i < listaGiocatori.size(); i++) {
	        if (listaGiocatori.get(i).id == id) {
	            listaGiocatori.remove(i); // elimino l'oggetto
	            trovato = true;
	            System.out.println("Giocatore eliminato con successo!");
	            break;
	        }
	    }

	    if (!trovato) {
	        System.out.println("Giocatore con ID " + id + " non trovato.");
	    }
		
	}
	
	private static void salvamodifiche() throws IOException{
		LeggiScrivi fonte = new LeggiScrivi("ElencoGiocatori_Aggiornato.csv"); // lo stesso file originale
	    fonte.setListaGiocatori(listaGiocatori); // aggiorno la lista
	    fonte.salvafile(); // salvo su file
	    System.out.println("Modifiche salvate correttamente!");
	}
}
