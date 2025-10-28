<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pizze</title>
</head>
<body>

<%
String [] pizze = {"Margherita", "Capricciosa", "Divola", "Caprese"};
double [] prezzipizze = {5, 4.5, 6, 4.8};
%>

<table width = "100%" border =1 >
<tr><td><h1 align="center">Elenco Pizze</h1></td></tr>

<%
for (int i = 0; i < pizze.length; i++) {
%>	
	<tr><td><h1 align="center"><a href="comanda.jsp?voce=<%= pizze[i] %>&prezzo=<%= prezzipizze[i] %>"><%= pizze[i] %> <%= prezzipizze[i] %> euro</a></h1></td></tr>
<%	
}
%>
<tr><td><h1 align="center"><a href="index.jsp">Torna a menu principale</a></h1></td></tr>
</table>




</body>
</html>