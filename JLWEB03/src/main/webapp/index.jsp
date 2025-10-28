<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
/*
A DIFFERENZA DI UN PROGETTO JAVA CHE HA UNA SUA ISTANZA PROGRAMMA DI BASE
CHE VIENE CREATA QUANDO VIENE ESEGUITO IL METODO MAIN
PER UNA PAGINA JSP QUESTA E' UN ELEMENTO A SE STANTE
PUò COLLOQUIARE CON ALTRE PAGINE, MA NON C'è UN ELEMENTO PROGRAMMA 
DI BASE CHE POSSO CONTENERE INFORMAZIONI CONDIVISIBILI PER TUTTE LE PAGINE
COME RISOLVIAMO? 
LE PAGINE ATTIVE QUANDO APRONO UN COLLOQUI CON IL SERVER CREANO UNA SESSIONE
SU QUESTA SESSIONE POSSIAMO CREARE DELLE VARIABILE
UNA SESSIONE VIENE CHIUSA QUANDO VIENE CHIUSA LA PAGINA WEB 
CON TUTTE LE SUE SCHEDE
*/
%>



<%! int numero = 3; %>

<% session.setAttribute("nome", "Nicola"); %>


<a href="secondapagina.jsp">Vai alla seconda pagina</a>

<a href="logout.jsp">Cancella variabile di sessione</a>


</body>
</html>