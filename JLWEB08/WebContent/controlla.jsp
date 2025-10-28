<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
/*
Connessione miaconnessione = new Connessione("dbristorazione", "root", "");
miaconnessione.connetti();
*/
try {
Connection conn;
String stringaconnessione = "jdbc:mysql://localhost:3306/";
String nomedatabase = "dbristorazione";
String user = "root";
String password = "";
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(stringaconnessione + nomedatabase, user, password);

out.println("Connesso");

Statement omino;
ResultSet matrice;

omino = conn.createStatement();


matrice = omino.executeQuery("Select * from utenti where utente = '" + request.getParameter("utente") + "' and password = '" + request.getParameter("password") + "'");



	if (matrice.next()) {
		
		String redirectURLok = "tabella.jsp";
		response.sendRedirect(redirectURLok);
		
	} else {
	
		String redirectURLko = "login.jsp?errore=credenziali";
		response.sendRedirect(redirectURLko);	
		
	}

}catch ( Exception e) {
	
	out.print("Errore" + e);
		
}//fine try-catch

%>    
    
