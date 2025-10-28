import java.sql.SQLException;

/**
 * Gestione CRUD per la tabella piatti (id_piatto, nome_piatto, id_tipo)
 * Usa la connessione fornita dalla superclasse tramite getMiaConnessione().
 */
public class NomiPiatti extends Ristorante {

    // Costruttore: impostiamo la connessione nella superclasse
    public NomiPiatti(Connessione miaConnessione) {
        setMiaConnessione(miaConnessione);
    }

    @Override
    public void inserisci() throws SQLException {
        System.out.println("Inserisci il nome del piatto:");
        String nome = GestionePiatti.inputStr.nextLine();
        System.out.println("Inserisci l'ID del tipo (1-Primo, 2-Secondo, 3-Frutta, 4-Dolce):");
        int tipo = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine(); // pulizia buffer
        String sql = "INSERT INTO piatti (NOMEPIATTO, IDTIPO) VALUES ('" + nome + "', " + tipo + ")";
        getMiaConnessione().comando(sql);
        System.out.println("Piatto inserito.");
    }

    @Override
    public void modifica() throws SQLException {
        visualizza();
        System.out.println("Inserisci l'ID del piatto da modificare:");
        int id = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine();
        System.out.println("Inserisci il nuovo nome del piatto:");
        String nuovoNome = GestionePiatti.inputStr.nextLine();
        System.out.println("Inserisci il nuovo ID tipo:");
        int nuovoTipo = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine();
        String sql = "UPDATE piatti SET NOMEPIATTO = '" + nuovoNome + "', IDTIPO = " + nuovoTipo +
                     " WHERE ID = " + id;
        getMiaConnessione().comando(sql);
        System.out.println("Piatto modificato.");
    }

    @Override
    public void elimina() throws SQLException {
        visualizza();
        System.out.println("Inserisci l'ID del piatto da eliminare:");
        int id = GestionePiatti.inputInt.nextInt();
        GestionePiatti.inputStr.nextLine();
        String sql = "DELETE FROM piatti WHERE ID = " + id;
        getMiaConnessione().comando(sql);
        System.out.println("Piatto eliminato.");
    }

    @Override
    public void visualizza() throws SQLException {
        String sql = "SELECT piatti.ID, piatti.NOMEPIATTO, tipi.TIPO " +
                     "FROM piatti INNER JOIN tipi ON piatti.IDTIPO = tipi.IDTIPO";
        getMiaConnessione().mostramatrice(sql);
    }
}
