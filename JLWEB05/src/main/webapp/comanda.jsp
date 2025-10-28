<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

<%
double totale = 0;
%>


<%! ArrayList<String> comanda = new ArrayList<String>();  %>
<%! ArrayList prezzicomanda = new ArrayList();  %>

<%
if (request.getParameter("voce") != null) {
	
	comanda.add(request.getParameter("voce"));
	prezzicomanda.add(Double.parseDouble(request.getParameter("prezzo")));
	
}

%>

<%
if (request.getParameter("svuota") != null) {
	
	comanda.clear();
	prezzicomanda.clear();
	
}

%>


<table width = "100%" border =1 >
<tr><td><h1 align="center">Riepilogo Comanda</h1></td></tr>

<%
for (int i = 0; i < comanda.size(); i++) {
%>	
	<tr><td><h1 align="center"> <%= comanda.get(i) %> euro <%= prezzicomanda.get(i) %></h1></td></tr>
	
<%	
    totale += Double.parseDouble(prezzicomanda.get(i).toString());
    //totale = totale + prezzicomanda.get(i);
}
%>
<tr><td><h1 align="center">Totale comanda <%=totale %> euro</h1></td></tr>

<tr><td><h1 align="center"><a href="index.jsp">Torna a menu principale</a></h1></td></tr>
<tr><td><h1 align="center"><a href="comanda.jsp?svuota=si">Svuota Comanda</a></h1></td></tr>
</table>

</body>
</html>