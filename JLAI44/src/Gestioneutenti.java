import java.sql.SQLException;
import java.util.Scanner;

public class Gestioneutenti {

    // --- CREATE ---
    public void aggiungiUtente(Scanner inputStr, Scanner inputInt, Scanner inputDou) throws SQLException {
        System.out.println("Nome utente:");
        String nome = inputStr.nextLine();
        System.out.println("Cognome utente:");
        String cognome = inputStr.nextLine();
        System.out.println("Username:");
        String username = inputStr.nextLine();
        System.out.println("Password:");
        String password = inputStr.nextLine();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String sql = "INSERT INTO utenti (NOME_ESTESO, COGNOME, UTENTE, PASSWORD) " +
                     "VALUES ('" + nome + "', '" + cognome + "', '" + username + "', '" + password + "')";
        conn.comando(sql);
        conn.disconnetti();

        System.out.println("Utente aggiunto!");
    }

    // --- UPDATE ---
    public void modificaUtente(Scanner inputStr, Scanner inputInt, Scanner inputDou) throws SQLException {
        System.out.println("Inserisci l'ID dell'utente da modificare:");
        int id = inputInt.nextInt();
        inputStr.nextLine(); // svuota buffer

        System.out.println("Nuovo nome utente:");
        String nome = inputStr.nextLine();
        System.out.println("Nuovo cognome utente:");
        String cognome = inputStr.nextLine();
        System.out.println("Nuovo username:");
        String username = inputStr.nextLine();
        System.out.println("Nuova password:");
        String password = inputStr.nextLine();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String sql = "UPDATE utenti SET NOME_ESTESO='" + nome + "', COGNOME='" + cognome +
                     "', UTENTE='" + username + "', PASSWORD='" + password + "' WHERE ID=" + id;
        conn.comando(sql);
        conn.disconnetti();

        System.out.println("Utente modificato!");
    }

    // --- DELETE ---
    public void eliminaUtente(Scanner inputStr, Scanner inputInt) throws SQLException {
        System.out.println("Inserisci l'ID dell'utente da eliminare:");
        int id = inputInt.nextInt();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String sql = "DELETE FROM utenti WHERE ID=" + id;
        conn.comando(sql);
        conn.disconnetti();

        System.out.println("Utente eliminato!");
    }
}
