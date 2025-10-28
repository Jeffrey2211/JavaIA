import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JAVA NON HA NATIVE DELLE CLASSI PER LE CONNESSIONI AI DATABASE
 * MA ONLINE SI TROVANO DIVERSE LIBRERIE GRATUITE PER GESTIRE
 * LE VARIE CONNESSIONI AD OGNI TIPO DI DATABASE
 * PER I NOSTRI ESEMPI DI CONNESSIONE A MYSQL SERVE UNA LIBRERIA
 * SPECIFICA PER CONNESSIONE A DATABASE MYSQL
 */

/*
 * LA LIBRERIA VA MESSA IN UNA SPECIFICA CARTELLA
 * E VA DETTO AL PROGETTO DI AGGIUNGERLA COME LIBRERIA
 * DISPONIBILE AL PROGRAMMA
 */


public class GestioneTeam {

	public static void main(String[] args) throws SQLException {
		
		//COSA SERVE PER CONNETTERCI AD UN DATABASE QUANDO ABBIAMO LA LIBRERIA?
		
		//UNA VARIABILE DI TIPO CONNESSIONE
		Connection connessione;
		
		//CREATO IL TUBO... HO BISOGNO DI DEFINIRE 
		//VERSO CHI E COME MI VOGLIO COLLEGARE
		
		/*
		 * QUALE PROTOCOLLO
		 * QUALE DATABASE
		 * VERSO QUALE SERVER
		 * SU CHE PORTA
		 * COME SI CHIAMA IL DATABASE
		 * CON QUALE UTENTE
		 * CON QUALE PASSWORD
		 */
		
		/*
		 * LE LIBRERIE PER FARE QUESTO USANO LE STRINGHE DI CONNESSIONE
		 * DOVE IN UN UNICA STRINGA METTONO I PRIMI 5 ELEMENTI
		 * IN PI� DOVR� DIRE QUALE E' L'UTENTE E QUALE E' LA PASSWORD
		 */
		
		String stringaconnessione = "jdbc:mysql://localhost:3306/pallavolo";
		String utente = "root";
		String password = "";
		
		//MA CHI PASSA QUESTE INFORMAZIONI ALLA CONNESSIONE?
		
		connessione = DriverManager.getConnection(stringaconnessione, utente, password);
		System.out.println("Connesso");
		
		/*
		 * PROVIAMO A FARE IL CRUD
		 * SAPPIAMO CHE ABBIAMO 2 TIPI DI QUERY
		 * DI SELEZIONE
		 * DI COMANDO
		 */
		
		Statement omino; //IL FACTOTUM CHE FA IL LAVORO SPORCO!!
		//METTO L'OMINO DENTRO LA CONNESSIONE CON IL CREATE STATEMENT
		omino = connessione.createStatement();
		
		String sql = "Select giocatori.id, giocatori.nome, giocatori.cognome, " + 
		"giocatori.ingaggio, ruoli.ruolo from " + 
		"giocatori inner join ruoli on ruoli.id = giocatori.idruolo"; 
		
		ResultSet matrice;
		
		matrice = omino.executeQuery(sql);
		
		/*
		 * MATRICE E' ORA A TUTTI GLI EFFETTI UN FILE SULLA RAM
		 * MA QUANTO E' GRANDE?? COME SI LEGGE? DOVE FINISCE??
		 * 
		 * BOF (BEGIN OF FILE)
		 * 0100111110
		 * 0001110011
		 * 0001111100
		 * EOF (END OF FILE)
		 * 
		 * QUANDO UN FILE E' VUOTO ALLORA BOF = EOF
		 * 
		 */
		
		while (matrice.next()) {  //LEGGO FINO A QUANDO POSSO FARE NEXT
			
			System.out.print(matrice.getString("ID"));
			System.out.print(" - ");
			System.out.print(matrice.getString("NOME"));
			System.out.print(" - ");
			System.out.print(matrice.getString("COGNOME"));
			System.out.print(" - ");
			System.out.print(matrice.getString("INGAGGIO"));
			System.out.print(" - ");
			System.out.println(matrice.getString("RUOLO"));
			
			
		}
		
		
		/*
		 * E PER LE QUERY DI COMANDO??
		 * IN REALT� E' ANCORA PI� SEMPLICE
		 * SAR� SEMPRE L'OMINO A FARE IL LAVORO, MA ESSENDO DIRETTO
		 * SULLE TABELLE NON CI SAR� NESSUN RITORNO
		 * E QUINDI NESSUN RESULTSET
		 */
		
		
		
		String comandosql = "Insert into Ruoli (ruolo) values ('libero')";
		
		//ATTENZIONE EXECUTEUPDATE NONVUOL DIRE
		//FAI UNA MODIFICA SULLA TABELLA
		//MA MODIFICA IL SUO STATO ATTRAVERSO UN COMANDO
		//CHE PU� ESSERE DI INSERT, UPDATE O DELETE
		omino.executeUpdate(comandosql);
		
		
		comandosql = "Update Ruoli set ruolo = 'Centrale' where ID = 3";
		omino.executeUpdate(comandosql);
		
		
		comandosql = "delete from Ruoli where ID = 3";
		omino.executeUpdate(comandosql);
		
		
		
		
		

	}

}
