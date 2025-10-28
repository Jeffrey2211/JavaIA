import java.sql.SQLException;

/**
 * Gestione CRUD per la tabella tipi (id_tipo, nome_tipo)
 * Usa la connessione fornita dalla superclasse tramite getMiaConnessione().
 */
public class TipiPiatti extends Ristorante {

    // Costruttore
    public TipiPiatti(Connessione miaConnessione) {
        setMiaConnessione(miaConnessione);
    }

    @Override
    public void inserisci() throws SQLException {
        System.out.println("Inserisci il nuovo tipo di piatto (Primo, Secondo, Frutta, Dolce):");
        String tipo = GestionePiatti.inputStr.nextLine();
        String sql = "INSERT INTO tipi (TIPO) VALUES ('" + tipo + "')";
        getMiaConnessione().comando(sql);
        System.out.println("Tipo inserito.");
    }

    @Override
    public void modifica() throws SQLException {
        visualizza();
        System.out.println("Inserisci l'ID del tipo da modificare:");
        int id = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine();
        System.out.println("Inserisci il nuovo nome del tipo:");
        String nuovoTipo = GestionePiatti.inputStr.nextLine();
        String sql = "UPDATE tipi SET TIPO = '" + nuovoTipo + "' WHERE ID = " + id;
        getMiaConnessione().comando(sql);
        System.out.println("Tipo modificato.");
    }

    @Override
    public void elimina() throws SQLException {
        visualizza();
        System.out.println("Inserisci l'ID del tipo da eliminare:");
        int id = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine();
        String sql = "DELETE FROM tipi WHERE ID = " + id;
        getMiaConnessione().comando(sql);
        System.out.println("Tipo eliminato.");
    }

    @Override
    public void visualizza() throws SQLException {
        String sql = "SELECT * FROM tipi";
        getMiaConnessione().mostramatrice(sql);
    }
}
