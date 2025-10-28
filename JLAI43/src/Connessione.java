import java.sql.*;

public class Connessione {

    private String stringaconnessione = "jdbc:mysql://localhost:3306/";
    private String nomedatabase;
    private String user;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData rsMeta;

    public Connessione(String nomedatabase, String user, String password) throws SQLException {
        this.nomedatabase = nomedatabase;
        this.user = user;
        this.password = password;
        conn = DriverManager.getConnection(stringaconnessione + nomedatabase, user, password);
        System.out.println("Connesso al database " + nomedatabase);
        stmt = conn.createStatement();
    }

    public ResultSet getSelezione(String sql) throws SQLException {
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public void mostramatrice(String sql) throws SQLException {
        rs = stmt.executeQuery(sql);
        rsMeta = rs.getMetaData();
        int nCol = rsMeta.getColumnCount();
        while(rs.next()) {
            for(int i=1; i<=nCol; i++) {
                System.out.print(rsMeta.getColumnName(i) + ": " + rs.getString(i));
                if(i < nCol) System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public void comando(String sql) throws SQLException {
        stmt.executeUpdate(sql);
    }

}
