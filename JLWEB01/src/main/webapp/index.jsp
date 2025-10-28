<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titolo della pagina</title>
</head>
<body>

<h1>Titolo nella pagina</h1>
<h2>Sottotitolo</h2>
<h3>Contenuto della pagina</h3>

<!-- commento in html -->

<%-- commenti JSP su singolo rigo --%>

<%
/*
Commento 
java 
su 
più 
righe
*/
%>

<%! int numero = 5; %>

<% numero += 3; %>

<h1>Il numero che voglio mostrare è <%= numero %></h1>

<%
if (numero > 10) {
%>
	<h2>numero grandea</h2>
<%	
} else {
%>	
	<h2>numero piccoloa</h2>
<% 
} 
%>

<%
if (numero > 10) {
	out.println("<h2>numero grandeb</h2>");
} else {
	out.println("<h2>numero piccolob</h2>");
}
 
%>


</body>
</html>