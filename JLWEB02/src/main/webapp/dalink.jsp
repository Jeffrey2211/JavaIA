<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Sei ora nella pagina Da Link</p>

<% String nome = request.getParameter("nome"); %>
<% String cognome = request.getParameter("cognome"); %>

<p>Ciao <%= nome %> <%= cognome %></p>


</body>
</html>