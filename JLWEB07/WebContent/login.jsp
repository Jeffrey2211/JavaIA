<%@ page import="dati.Connessione,java.sql.*,java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form di Login</title>
<link rel="stylesheet" href="index.css">
</head>
<body>

<%

Connessione miaconnessione = new Connessione("dbristorazione", "root", "");
miaconnessione.connetti();
%>


<!-- DIV è UN TAG GENERICO A CUI POSSIAMO DARE IMPOSTAZIONI GRAFICHE -->
<div class="container">
<h1>Login</h1>
<form action="" method="post"> <!-- puntiamo con action e passiamo nasconto -->
<label for="email">E-mail</label>
<input type="email" id="email" name="email" required>
<label for="password">Password</label>
<input type="password" id="password" name="password" required>
<button type="submit">Login</button>
</form>
</div>
</body>
</html>