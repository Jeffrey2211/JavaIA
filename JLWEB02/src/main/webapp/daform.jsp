<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Sei nella pagina Da Form</p>

<p>Il tuo nome � <%= request.getParameter("nome") %></p>
<p>Il tuo cognome � <%= request.getParameter("cognome") %></p>



</body>
</html>