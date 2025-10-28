<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if(application.getAttribute("litriVerde") == null) application.setAttribute("litriVerde", 50);
if(application.getAttribute("litriDiesel") == null) application.setAttribute("litriDiesel", 50);
int litriVerde = (Integer) application.getAttribute("litriVerde");
int litriDiesel = (Integer) application.getAttribute("litriDiesel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stazione di benzina</title>
</head>
<body>

<table width="100%" border="1">
<tr><td><h1 align="center">Rifornimento</h1></td></tr>
<tr><td><h1 align="center"><a href="mostra.jsp">Mostra litri disponibili</a></h1></td></tr>
<tr><td><h1 align="center"><a href="carica.jsp">Carica Diesel/Verde</a></h1></td></tr>
<tr><td><h1 align="center"><a href="rifornisci.jsp">Rifornimento (calcolo prezzo)</a></h1></td></tr>
<tr><td><h1 align="center">Litri attuali: Verde: <%=litriVerde%>, Diesel: <%=litriDiesel%></h1></td></tr>
</table>

</body>
</html>
