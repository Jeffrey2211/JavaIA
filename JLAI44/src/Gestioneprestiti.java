import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Gestioneprestiti {

    // 🔹 Metodo per registrare un nuovo prestito
    public void registraPrestito(Scanner inputStr, Scanner inputInt) throws SQLException {
        System.out.println("\n--- REGISTRA NUOVO PRESTITO ---");

        System.out.print("Inserisci ID Utente: ");
        int idUtente = inputInt.nextInt();
        inputInt.nextLine(); // pulisci buffer

        System.out.print("Inserisci ID Pubblicazione: ");
        int idPubblicazione = inputInt.nextInt();
        inputInt.nextLine();

        LocalDate dataInizio = LocalDate.now();
        LocalDate dataFine = dataInizio.plusDays(30); // prestito valido 30 giorni

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String query = "INSERT INTO prestiti (id_utente, id_pubblicazione, data_inizio, data_fine, restituito) " +
                       "VALUES (" + idUtente + ", " + idPubblicazione + ", '" + dataInizio + "', '" + dataFine + "', false)";
        conn.eseguiQuery(query);
        conn.disconnetti();

        System.out.println("✅ Prestito registrato correttamente!");
    }

    // 🔹 Metodo per restituire un prestito
    public void restituisciPrestito(Scanner inputInt) throws SQLException {
        System.out.println("\n--- RESTITUZIONE PRESTITO ---");

        System.out.print("Inserisci ID del prestito da restituire: ");
        int idPrestito = inputInt.nextInt();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String query = "UPDATE prestiti SET restituito = true WHERE id = " + idPrestito;
        conn.eseguiQuery(query);
        conn.disconnetti();

        System.out.println("📦 Prestito restituito con successo!");
    }

    // 🔹 Metodo per visualizzare i prestiti attivi
    public void visualizzaPrestitiAttivi() throws SQLException {
        System.out.println("\n--- PRESTITI ATTIVI ---");

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        conn.getSelezione("SELECT p.id, u.nome_esteso, pub.nome, p.data_inizio, p.data_fine " +
                          "FROM prestiti p " +
                          "JOIN utenti u ON p.id_utente = u.id " +
                          "JOIN pubblicazioni pub ON p.id_pubblicazione = pub.id " +
                          "WHERE p.restituito = false");

        while (conn.getMatrice().next()) {
            System.out.println("ID Prestito: " + conn.getMatrice().getInt("id"));
            System.out.println("Utente: " + conn.getMatrice().getString("nome_esteso"));
            System.out.println("Pubblicazione: " + conn.getMatrice().getString("nome"));
            System.out.println("Data inizio: " + conn.getMatrice().getString("data_inizio"));
            System.out.println("Data fine: " + conn.getMatrice().getString("data_fine"));
            System.out.println("----------------------------");
        }

        conn.disconnetti();
    }
}
