<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%! String nome = "Nicola"; %>
<%! String cognome = "Cradellicchio"; %>

<p>Per spostarmi con un link ho bisogno del tag a</p>
<p>All'interno dei tag posso inserite i loro attributi (come nei metodi)</p>
<a href="dalink.jsp?nome=<%= nome %>&cognome=<%= cognome %>">Vai alla pagina Da Link</a>


<form name ="miaform" action="daform.jsp" method="post">

<p>Inserisci nome:</p><input type="text" name="nome"></input>
<p>Inserisci cognome:</p><input type="text" name="cognome"></input>
<br>
<input type="submit" name="Invia" >

</form>




</body>
</html>