import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestioneTeamClasseConnessione {

	public static Scanner inputStr = new Scanner (System.in);
	public static Scanner inputInt = new Scanner (System.in);
	public static ResultSet miamatrice;
	public static Connessione miaconnessione;
	
	public static void main(String[] args) throws SQLException {
		
		//CREO LA CONNESSIONE AL DATABASE
		
		System.out.println("A quale database vuoi collegarti?");
		String database = inputStr.nextLine();
		System.out.println("Inserisci nome utente");
		String utente = inputStr.nextLine();
		System.out.println("Inserisci password");
		String password = inputStr.nextLine();
		
		miaconnessione = new Connessione(database, utente, password);
		
		int scelta;
		do {
			
			scelta = mostramenu();
			faiswitch(scelta);
			
		} while (scelta != 0);
		

	}

	private static int mostramenu() {
		
		System.out.println("1 Gestisci Ruoli");
		System.out.println("2 Gestisci Giocatori");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();
	}

	private static void faiswitch(int scelta) throws SQLException {
		
		switch (scelta) {
		
		case 1:
			gestioneruoli();
			break;
		case 2:
			gestionegiocatori();
			break;
		case 0:
			break;
			
			default: System.out.println("Attenzione scelta nono valida");
		
		}
		
	}

	private static void gestionegiocatori() throws SQLException {

		int scelta;
		do {
			
			scelta = mostramenugiocatori();
			faiswitchgiocatori(scelta);
			
		} while (scelta != 0);
		
	}

	private static int mostramenugiocatori() {
		System.out.println("1 Mostra Giocatori");
		System.out.println("2 Inserisci Giocatore");
		System.out.println("3 Modifica Giocatore");
		System.out.println("4 Elimina Giocatore");
		System.out.println("0 Torna al menu principale");
		
		return inputInt.nextInt();
	}

	private static void faiswitchgiocatori(int scelta) throws SQLException {

        switch(scelta) {
		
		case 1:
			mostragiocatori();
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
		case 0:
			break;
			
			default : System.out.println("Attenzione scelta non valida");
		
		}
		
	}

	private static void mostragiocatori() throws SQLException {
		
		miaconnessione.mostramatrice("Select giocatori.id, giocatori.nome, "
				+ "giocatori.cognome, giocatori.ingaggio, ruoli.ruolo "
				+ "from ruoli inner join giocatori on ruoli.id = giocatori.idruolo");
		
	}

	private static void inseriscigiocatore() {
		// TODO Auto-generated method stub
		
	}

	private static void modificagiocatore() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminagiocatore() {
		// TODO Auto-generated method stub
		
	}

	private static void gestioneruoli() throws SQLException {
		
		int scelta;
		do {
			
			scelta = mostramenuruoli();
			faiswitchruoli(scelta);
			
		} while (scelta != 0);
		
	}

	private static int mostramenuruoli() {
		
		System.out.println("1 Mostra Ruoli");
		System.out.println("2 Inserisci Ruolo");
		System.out.println("3 Modifica Ruolo");
		System.out.println("4 Elimina Ruolo");
		System.out.println("0 Torna al menu principale");
		
		return inputInt.nextInt();
	}

	private static void faiswitchruoli(int scelta) throws SQLException {
		
		switch(scelta) {
		
		case 1:
			mostraruoli();
			break;
		case 2:
			inserisciruolo();
			break;
		case 3:
			modificaruolo();
			break;
		case 4:
			eliminaruolo();
			break;
		case 0:
			break;
			
			default : System.out.println("Attenzione scelta non valida");
		
		}
		
	}

	private static void mostraruoli() throws SQLException {
		
		miaconnessione.mostramatrice("Select * from ruoli");
		/*
		miamatrice = miaconnessione.getSelezione("Select * from ruoli");
		
		while (miamatrice.next()) {
			
			System.out.print("ID: " + miamatrice.getString("ID"));
			System.out.println(" - Ruolo: " + miamatrice.getString("RUOLO"));
			
			
		}
		*/
	}

	private static void inserisciruolo() throws SQLException {
		
		System.out.println("Quale ruolo vuoi inserire?");
		String ruolo = inputStr.nextLine();
		
		String comando = "Insert into ruoli (ruolo) values ('" + ruolo + "')";
		
		miaconnessione.comando(comando);
	}

	private static void modificaruolo() throws SQLException {
		
		mostraruoli();
		System.out.println("Inserisci l'ID del ruolo da modificare:");
		int scelta = inputInt.nextInt();
		System.out.println("Inserisci il nuovo valore per il ruolo:");
		String nuovoruolo = inputStr.nextLine();
		
		String comando = "Update ruoli set ruolo = '" + nuovoruolo + "' where id = '" + scelta + "'";
		miaconnessione.comando(comando);
		
		
	}

	private static void eliminaruolo() throws SQLException {
		
		mostraruoli();
		System.out.println("Inserisci l'ID del ruolo da eliminare:");
		int scelta = inputInt.nextInt();
		
		String comando = "Delete from ruoli where id = '" + scelta + "'";
		miaconnessione.comando(comando);
		
		
	}

}
