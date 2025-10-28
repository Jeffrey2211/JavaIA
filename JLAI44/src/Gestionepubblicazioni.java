import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;

public class Gestionepubblicazioni {

    // --- CREATE ---
    public void aggiungiPubblicazione(Scanner inputStr, Scanner inputInt, Scanner inputDou) throws SQLException {
        System.out.println("Scegli tipo (1=Libro, 2=Rivista, 3=Fumetto):");
        int tipo = inputInt.nextInt();
        inputStr.nextLine(); // svuota buffer

        System.out.println("Nome:");
        String nome = inputStr.nextLine();
        System.out.println("Data (YYYY-MM-DD):");
        String data = inputStr.nextLine();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String sql = "";

        if(tipo == 1) { 
            System.out.println("Autore:");
            String autore = inputStr.nextLine();
            System.out.println("Copertina rigida? true/false:");
            boolean copertina = inputStr.nextBoolean();

            sql = "INSERT INTO pubblicazioni (NOME, DATAPUBBLICAZIONE, AUTORE, COPERTINARIGIDA, IDTIPO) " +
                  "VALUES ('" + nome + "', '" + data + "', '" + autore + "', " + copertina + ", 1)";

        } else if(tipo == 2) { 
            System.out.println("Casa editrice:");
            String casa = inputStr.nextLine();
            System.out.println("Costo abbonamento:");
            double costo = inputDou.nextDouble();

            sql = "INSERT INTO pubblicazioni (NOME, DATAPUBBLICAZIONE, CASA_EDITRICE, COSTO_ABBONAMENTO, IDTIPO) " +
                  "VALUES ('" + nome + "', '" + data + "', '" + casa + "', " + costo + ", 2)";

        } else if(tipo == 3) { 
            System.out.println("Disegnatore:");
            String disegnatore = inputStr.nextLine();
            System.out.println("A colori? true/false:");
            boolean acolori = inputStr.nextBoolean();

            sql = "INSERT INTO pubblicazioni (NOME, DATAPUBBLICAZIONE, DISEGNATORE, ACOLORI, IDTIPO) " +
                  "VALUES ('" + nome + "', '" + data + "', '" + disegnatore + "', " + acolori + ", 3)";
        }

        conn.comando(sql);
        conn.disconnetti();
        System.out.println("Pubblicazione aggiunta!");
    }

    // --- UPDATE ---
    public void modificaPubblicazione(Scanner inputStr, Scanner inputInt, Scanner inputDou) throws SQLException {
        System.out.println("Inserisci l'ID della pubblicazione da modificare:");
        int id = inputInt.nextInt();
        inputStr.nextLine(); // svuota buffer

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        // Chiedo il tipo per sapere quali campi modificare
        System.out.println("Scegli tipo (1=Libro, 2=Rivista, 3=Fumetto):");
        int tipo = inputInt.nextInt();
        inputStr.nextLine();

        String sql = "";

        System.out.println("Nuovo nome:");
        String nome = inputStr.nextLine();
        System.out.println("Nuova data (YYYY-MM-DD):");
        String data = inputStr.nextLine();

        if(tipo == 1) {
            System.out.println("Nuovo autore:");
            String autore = inputStr.nextLine();
            System.out.println("Copertina rigida? true/false:");
            boolean copertina = inputStr.nextBoolean();

            sql = "UPDATE pubblicazioni SET NOME='" + nome + "', DATAPUBBLICAZIONE='" + data +
                  "', AUTORE='" + autore + "', COPERTINARIGIDA=" + copertina + " WHERE ID=" + id;

        } else if(tipo == 2) {
            System.out.println("Nuova casa editrice:");
            String casa = inputStr.nextLine();
            System.out.println("Nuovo costo abbonamento:");
            double costo = inputDou.nextDouble();

            sql = "UPDATE pubblicazioni SET NOME='" + nome + "', DATAPUBBLICAZIONE='" + data +
                  "', CASA_EDITRICE='" + casa + "', COSTO_ABBONAMENTO=" + costo + " WHERE ID=" + id;

        } else if(tipo == 3) {
            System.out.println("Nuovo disegnatore:");
            String disegnatore = inputStr.nextLine();
            System.out.println("A colori? true/false:");
            boolean acolori = inputStr.nextBoolean();

            sql = "UPDATE pubblicazioni SET NOME='" + nome + "', DATAPUBBLICAZIONE='" + data +
                  "', DISEGNATORE='" + disegnatore + "', ACOLORI=" + acolori + " WHERE ID=" + id;
        }

        conn.comando(sql);
        conn.disconnetti();
        System.out.println("Pubblicazione modificata!");
    }

    // --- DELETE ---
    public void eliminaPubblicazione(Scanner inputStr, Scanner inputInt) throws SQLException {
        System.out.println("Inserisci l'ID della pubblicazione da eliminare:");
        int id = inputInt.nextInt();

        Connessione conn = new Connessione("biblioteca", "root", "");
        conn.connetti();

        String sql = "DELETE FROM pubblicazioni WHERE ID=" + id;
        conn.comando(sql);
        conn.disconnetti();

        System.out.println("Pubblicazione eliminata!");
    }
}
