import java.sql.SQLException;

/**
 * Superclasse astratta: contiene la connessione comune e definisce il contratto CRUD.
 * Attributo connessione è private e accessibile tramite getter/setter.
 */
public abstract class Ristorante {

    // Connessione "globale" per tutte le sottoclassi (incapsulata)
    private Connessione miaConnessione;

    // Setter / Getter (pubblici per permettere uso da sottoclassi tramite instance methods)
    public void setMiaConnessione(Connessione miaConnessione) {
        this.miaConnessione = miaConnessione;
    }

    public Connessione getMiaConnessione() {
        return miaConnessione;
    }

    // METODI ASTRATTI CRUD che le sottoclassi devono implementare
    public abstract void inserisci() throws SQLException;
    public abstract void modifica() throws SQLException;
    public abstract void elimina() throws SQLException;
    public abstract void visualizza() throws SQLException;
}
