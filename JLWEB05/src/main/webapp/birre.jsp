<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Birre</title>
</head>
<body>

<%
String [] birre = {"Nastro Azzurro", "Tuborg", "Peroni", "Raffo"};
double [] prezzibirre = {5, 4.5, 6, 4.8};
%>

<table width = "100%" border =1 >
<tr><td><h1 align="center">Elenco Birre</h1></td></tr>
<%
for (int i = 0; i < birre.length; i++) {
%>	
	<tr><td><h1 align="center"><a href="comanda.jsp?voce=<%= birre[i] %>&prezzo=<%= prezzibirre[i] %>"><%= birre[i] %> <%= prezzibirre[i] %> euro</a></h1></td></tr>
<%	
}
%>
<tr><td><h1 align="center"><a href="index.jsp">Torna a menu principale</a></h1></td></tr>
</table>


</body>
</html>