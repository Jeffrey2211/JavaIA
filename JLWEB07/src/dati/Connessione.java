import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connessione {
	
	//ATTRIBUTI
	private String stringaconnessione = "jdbc:mysql://localhost:3306/";
	private String nomedatabase;
	private String user;
	private String password;
	private String sqlselezione;
	private String sqlcomando;
	private Connection conn;
	private Statement omino;
	private ResultSet matrice;
	private ResultSetMetaData metadatamatrice;
	
	
	
	//COSTRUTTORI
	public Connessione (String nomedatabase, String user, String password) throws SQLException {
		
		this.nomedatabase = nomedatabase;
		this.user = user;
		this.password = password;
		
	}
	
	
	public void connetti () throws SQLException {
		
		conn = DriverManager.getConnection(stringaconnessione + nomedatabase, user, password);
		//System.out.println("Connesso");
		
		//CREO L'OMINO PER I LAVORI FUTURI
		omino = conn.createStatement();
		
	}
	
    public void disconnetti () throws SQLException {
    	
    	conn.close();
    	//System.out.println("Disconnesso");
		
	}
	
	
	
	
	//GETTER AND SETTER
	
	
	//METODI
	public ResultSet getSelezione (String sqlselezione) throws SQLException {
		
		//mi prendo il comando
		this.sqlselezione = sqlselezione;
		//LO ESEGUO E INIZIALIZZO LA MATRICE
		matrice = omino.executeQuery(sqlselezione);
		//RESTITUISCO LA MATRICE
		return matrice;
		
	}
	
	
	public ResultSet getMatrice () {
		return matrice;
	}
	
	
	/*
	public void mostramatrice (String sqlselezione) throws SQLException {
		
		//mi prendo il comando
		this.sqlselezione = sqlselezione;
		//LO ESEGUO E INIZIALIZZO LA MATRICE
		matrice = omino.executeQuery(sqlselezione);
		
		metadatamatrice = matrice.getMetaData();
		
		int numerocampi = metadatamatrice.getColumnCount();
		
		while (matrice.next()) {
			
			for (int i = 1; i <= numerocampi; i++) {
				
				//MI PRENDO IL NOME DEL CAMPO
				System.out.print(metadatamatrice.getColumnName(i) + ": ");
				//MI PRENDO IL VALORE DEL CAMPO
				System.out.print(matrice.getString(i));
				if (i < numerocampi) {
					System.out.print(" - "); //SEPARO I CAMPI TRANNE L'ULTIMO
				}
			}
			System.out.println(); //VADO A CAPO
			
			
		}
		
	}
	
	*/
	
	public void comando (String sqlcomando) throws SQLException {
		
		this.sqlcomando = sqlcomando;
		omino.executeUpdate(sqlcomando);
		
		
	}
	
	

}
