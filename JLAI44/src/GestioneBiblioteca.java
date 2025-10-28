import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneBiblioteca {

	public static ArrayList<Pubblicazione> ListaPubblicazioni = new ArrayList<Pubblicazione>(); 
	public static Scanner InputInt = new Scanner (System.in);
	public static Scanner InputStr = new Scanner (System.in);
	public static Scanner InputDou = new Scanner (System.in);
	public static String nomeesteso = "";
	
	public static void main(String[] args) throws SQLException {
		
		boolean loggato = false;
		while (loggato == false) {
		loggato = failogin();
		}
		
		
		int scelta;
		do {
			
			scelta = mostramenu();
			faiswitch(scelta);
			
		} while (scelta != 0);
		

	}


	private static boolean failogin() throws SQLException {
		
		System.out.println("Inserisci Utente:");
		String utente = InputStr.nextLine();
		System.out.println("Inserisci Password:");
		String pass = InputStr.nextLine();
		
		
		
		Connessione perlogin = new Connessione("biblioteca", "root", "");
		perlogin.connetti();
		perlogin.getSelezione("Select NOME_ESTESO from utenti where utente = '"+utente+"' and password = '"+pass+"'");
		while (perlogin.getMatrice().next()) {
			nomeesteso = perlogin.getMatrice().getString("NOME_ESTESO");
		}
		perlogin.disconnetti();
		if (!nomeesteso.isEmpty()) {
			
			System.out.println("Bentornato " + nomeesteso);
			return true;
		} else {
			System.out.println("Attenzione credenziali non valide");
		return false;
		}
	}


	private static int mostramenu() {
		
		System.out.println("1 Mostra pubblicazioni");
		System.out.println("2 Gestione Prestiti");
		System.out.println("0 Esci");
		
		return InputInt.nextInt();
	}


	private static void faiswitch(int scelta) throws SQLException {
		
		switch (scelta) {
		
		case 1:
			mostrapubblicazioni();
			break;
		case 2:
			gestisciprestiti();
			break;
		case 0:
			break;
			
			default : System.out.println("Attenzione scelta non valida");
		
		}
		
	}


	private static void mostrapubblicazioni() throws SQLException {
		
		int scelta;
		do {
			
			scelta = mostramenupubblicazioni();
			faiswitchpubblicazioni(scelta);
			
		} while (scelta != 0);
		
	}


	private static int mostramenupubblicazioni() throws SQLException {
		
		
		ListaPubblicazioni.clear();
		
		Connessione ConnLibri = new Connessione("biblioteca", "root", "");
		ConnLibri.connetti();
		
		ConnLibri.getSelezione("SELECT pubblicazioni.*, tipi.TIPO "
				+ "FROM pubblicazioni inner join tipi "
				+ "on tipi.ID = pubblicazioni.IDTIPO");
		
		while (ConnLibri.getMatrice().next()) {
			
			if (ConnLibri.getMatrice().getString("TIPO").equals("LIBRO")) {
				ListaPubblicazioni.add(new Libro(ConnLibri.getMatrice().getString("NOME"), LocalDate.parse(ConnLibri.getMatrice().getString("DATAPUBBLICAZIONE")), ConnLibri.getMatrice().getString("AUTORE"), ConnLibri.getMatrice().getBoolean("COPERTINARIGIDA")));
			} else if (ConnLibri.getMatrice().getString("TIPO").equals("RIVISTA")) {
				ListaPubblicazioni.add(new Rivista(ConnLibri.getMatrice().getString("NOME"), LocalDate.parse(ConnLibri.getMatrice().getString("DATAPUBBLICAZIONE")), ConnLibri.getMatrice().getString("CASA_EDITRICE"), ConnLibri.getMatrice().getDouble("COSTO_ABBONAMENTO")));
			} if (ConnLibri.getMatrice().getString("TIPO").equals("FUMETTO")) {
				ListaPubblicazioni.add(new Fumetto(ConnLibri.getMatrice().getString("NOME"), LocalDate.parse(ConnLibri.getMatrice().getString("DATAPUBBLICAZIONE")), ConnLibri.getMatrice().getString("DISEGNATORE"), ConnLibri.getMatrice().getBoolean("ACOLORI")));
			}
			
			
		}
		ConnLibri.disconnetti();
		
		
		System.out.println("1 - Libri");
		System.out.println("2 - Riviste");
		System.out.println("3 - Fumetti");
		System.out.println("5 - Gestione pubblicazioni");
		System.out.println("6 - Gestione utenti");
		System.out.println("0 - Torna a menu principale");
		
		return InputInt.nextInt();
	}


	private static void faiswitchpubblicazioni(int scelta) throws SQLException {
		
		switch (scelta) {
		
		case 1:
			mostralibri();
			break;
		case 2:
			mostrariviste();
			break;
		case 3:
			mostrafumetti();
			break;
		case 4:
			mostrainsupersconto();
			break;
		case 5:
			gestionepublicazioni();
			break;
		case 6:
			gestioneutenti();
			break;
		case 0:
			break;
			
		default : System.out.println("Attenzione scelta non valida");
			
		
		
		}
		
	}


	


	private static void mostrainsupersconto() {
		
		//MOSTRO I LIBRI FILTRANDO DALLA MIA LISTA
				for (int i = 0; i < ListaPubblicazioni.size(); i++) {
					
					if (ListaPubblicazioni.get(i) instanceof Superscontato) {
						
						ListaPubblicazioni.get(i).mostrapubblicazione();	
						ListaPubblicazioni.get(i).supersconto();
						
					}
				
				}
		
	}


	private static void mostralibri() throws SQLException {
		
		//MOSTRO I LIBRI FILTRANDO DALLA MIA LISTA
		for (int i = 0; i < ListaPubblicazioni.size(); i++) {
			
			if (ListaPubblicazioni.get(i) instanceof Libro) {
				
				ListaPubblicazioni.get(i).mostrapubblicazione();				
				
			}
		
		}
		
		
		
	}


	private static void mostrariviste() {
		//MOSTRO I LIBRI FILTRANDO DALLA MIA LISTA
		for (int i = 0; i < ListaPubblicazioni.size(); i++) {
			
			if (ListaPubblicazioni.get(i) instanceof Rivista) {
				
				ListaPubblicazioni.get(i).mostrapubblicazione();				
				
			}
		
		}
		
	}


	private static void mostrafumetti() {
		
		//MOSTRO I LIBRI FILTRANDO DALLA MIA LISTA
		for (int i = 0; i < ListaPubblicazioni.size(); i++) {
			
			if (ListaPubblicazioni.get(i) instanceof Fumetto) {
				
				ListaPubblicazioni.get(i).mostrapubblicazione();				
				
			}
		
		}
		
	}
	
    private static void gestionepublicazioni() throws SQLException {
    	
    	Gestionepubblicazioni gp = new Gestionepubblicazioni();
	
		int scelta;
		do {
			
			System.out.println("1 - Aggiungi pubblicazione");
			System.out.println("2 - Modifica pubblicazione");
			System.out.println("3 - Elimina pubblicazione");
			
			scelta = InputInt.nextInt();
			
			switch(scelta) {
			case 1:
				gp.aggiungiPubblicazione(InputStr, InputInt, InputDou); 
				break;
			case 2: 
				gp.modificaPubblicazione(InputStr, InputInt, InputDou); 
				break;
			case 3: 
				gp.eliminaPubblicazione(InputStr, InputInt); 
				break;
			case 0:
				System.out.println("Torna al menu principale!");
				break;
			default:
				System.out.println("Scelta non valida!");
				break;
			}
		} while(scelta != 0);
		
	}
    
    private static void gestioneutenti() throws SQLException {
		
		Gestioneutenti gu = new Gestioneutenti();
		
		int scelta;
		do {
			
			System.out.println("1 - Aggiungi pubblicazione");
			System.out.println("2 - Modifica pubblicazione");
			System.out.println("3 - Elimina pubblicazione");
			
			scelta = InputInt.nextInt();
			
			switch(scelta) {
			case 1:
				gu.aggiungiUtente(InputStr, InputInt, InputDou); 
				break;
			case 2: 
				gu.modificaUtente(InputStr, InputInt, InputDou); 
				break;
			case 3: 
				gu.eliminaUtente(InputStr, InputInt); 
				break;
			case 0:
				System.out.println("Torna al menu principale!");
				break;
			default:
				System.out.println("Scelta non valida!");
				break;
			}
		} while(scelta != 0);
		
    }

	private static void gestisciprestiti() {
		Gestioneprestiti gp = new Gestioneprestiti();

		int scelta;
		do {
			System.out.println("\n--- GESTIONE PRESTITI ---");
		    System.out.println("1 - Registra prestito");
		    System.out.println("2 - Restituisci prestito");
		    System.out.println("3 - Visualizza prestiti attivi");
		    System.out.println("0 - Torna al menu principale");
		    System.out.print("Scelta: ");
		        
		    scelta = InputInt.nextInt(); // 🔹 Devi leggere la scelta

		    switch (scelta) {
		    case 1:
		    	System.out.println("Registrazione prestito...");
		        gp.registraPrestito(InputStr, InputInt);
		        break;

		     case 2:
		        System.out.println("Restituzione prestito...");
		        gp.restituisciPrestito(InputStr);
		        break;

		     case 3:
		        System.out.println("Visualizzazione prestiti attivi...");
		        gp.visualizzaPrestitiAttivi(Scanner inputInt);
		        break;

		      case 0:
		         System.out.println("Torna al menu principale...");
		         break;

		       default:
		          System.out.println("⚠️ Scelta non valida, riprova!");
		          break;
		        }

		    } while (scelta != 0);
		
	}

}
