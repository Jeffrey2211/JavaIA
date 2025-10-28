/*
*Crea un database cucina su mysql
*inserisci le tabelle piatti e tipi
*nei tipi ci sono le tipologie di piatto (primo, secondo, frutta, dolce....)
*nei piatti ci sono i vari piatti con la loro tipologia espressa tramite una chiave esterna
*collegale in una relazione 1 a molti dal designer

*Crea un progetto java importando la libreria per il collegamento a mysql
*usa una classe per la connessione a database

*crea un software con un menu principale per la gestione dei tipi o dei piatti
*ognuno avrà un suo sottomenu che gestirà un completo crud sulla tabella
*/


import java.sql.SQLException;
import java.util.Scanner;

public class GestionePiatti {
	
	public static Scanner inputStr = new Scanner (System.in);
	public static Scanner inputInt = new Scanner (System.in);
	public static Scanner inputDou = new Scanner (System.in);

	public static void main(String[] args) throws SQLException {
	//CREO LA CONNESSIONE AL DATABASE
		
	    System.out.println("A quale database vuoi collegarti?");
	    String database = inputStr.nextLine();
	    System.out.println("Inserisci nome utente");
	    String utente = inputStr.nextLine();
	    System.out.println("Inserisci password");
	    String password = inputStr.nextLine();
				
	    // la connessione è locale, non più statica
	    Connessione miaconnessione = new Connessione(database, utente, password);

	    // istanzio gli oggetti con la connessione
	    NomiPiatti gestorePiatti = new NomiPiatti(miaconnessione);
	    TipiPiatti gestoreTipi = new TipiPiatti(miaconnessione);
		
		
		int scelta;
		do {
			
			scelta = mostramenu();
			
			faiswitch(scelta, gestorePiatti, gestoreTipi);
			
		} while (scelta != 0);



}

	private static int mostramenu() {
		
		System.out.println("1 Gestisci piatti");
		System.out.println("2 Gestisci tipi di piatti");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();
	}

	private static void faiswitch(int scelta,  NomiPiatti gestorePiatti, TipiPiatti gestoreTipi) throws SQLException {
		switch(scelta) {
		
		case 1:
			gestionepiatti(gestorePiatti);
			break;
		case 2:
			gestionetipi(gestoreTipi);
			break;
		case 0:
			System.out.println("Torna al menu principale");
			break;
        default:
            System.out.println("Attenzione! Scelta non valida.");
        	break;
		
		}
		
	}

	private static void gestionepiatti(NomiPiatti gestorePiatti) throws SQLException {

		int scelta;
        do {
        	
        	System.out.println("\n--- GESTIONE PIATTI ---");
			System.out.println("1 - Visualizza tutti i piatti");
			System.out.println("2 - Modifica piatto");
			System.out.println("3 - Elimina piatto");
			System.out.println("4 - Inserisci nuovo piatto");
			System.out.println("0 - Torna al menu principale");
			
			scelta = inputInt.nextInt();
			inputStr.nextLine(); // pulisci buffer
			
        	switch(scelta) {
        	
        	case 1:
        		gestorePiatti.visualizza();
        		break;
        	case 2:
        		gestorePiatti.inserisci();
        		break;
        	case 3:
        		gestorePiatti.modifica();
        		break;
        	case 4:
        		gestorePiatti.elimina();
        		break;
        	case 0:
        		break;
        	default:
        		System.out.println("Attenzione scelta sbagliata!");
        		break;
        	        	
        	}
        	
        } while(scelta != 0);
		
	}

	private static void gestionetipi(TipiPiatti gestoreTipi) throws SQLException {
		
		int scelta;
        do {
        	System.out.println("\n--- GESTIONE TIPI DI PIATTI ---");
			System.out.println("1 - Inserisci nuovo tipo");
			System.out.println("2 - Modifica tipo");
			System.out.println("3 - Elimina tipo");
			System.out.println("4 - Visualizza tutti i tipi");
			System.out.println("0 - Torna al menu principale");
			
			scelta = inputInt.nextInt();
			inputStr.nextLine();
			
        	switch(scelta) {
        	
        	case 1:
        		gestoreTipi.visualizza();
        		break;
        	case 2:
        		gestoreTipi.inserisci();
        		break;
        	case 3:
        		gestoreTipi.modifica();
        		break;
        	case 4:
        		gestoreTipi.elimina();
        		break;
        	case 0:
        		break;
        	default:
        		System.out.println("Attenzione scelta sbagliata!");
        		break;
        	}
        } while(scelta != 0);// gestisci tipi
		
	}

}
