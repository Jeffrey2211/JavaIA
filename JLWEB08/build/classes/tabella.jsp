<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%     
Connection conn;
String stringaconnessione = "jdbc:mysql://localhost:3306/";
String nomedatabase = "dbristorazione";
String user = "root";
String password = "";
Statement omino;
ResultSet matrice = null;

try {

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(stringaconnessione + nomedatabase, user, password);
out.println("Connesso");
omino = conn.createStatement();
matrice = omino.executeQuery("Select * from pietanze");

}catch ( Exception e) {
	
	out.print("Errore" + e);
		
}//fine try-catch    
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="responsive.css">
<title>Insert title here</title>
</head>
<body>

<table>
      <thead>
        <tr>
          <th>ID</th>
          <th>NOME</th>
          <th>TIPO</th>
          <th>PREZZO</th>
          <th>TEMPISTICA</th>
        </tr>
      <thead>
      <tbody>
      
      <%
	while (matrice.next()) {
		%>
		        <tr>
          <td><%= matrice.getString(1) %></td>
          <td><%= matrice.getString(2) %></td>
          <td><%= matrice.getString(3) %></td>
          <td><%= matrice.getString(4) %></td>
          <td><%= matrice.getString(5) %></td>
        </tr>

      <% } %>
      
      
      

      </tbody>
    <table/>

</body>
</html>