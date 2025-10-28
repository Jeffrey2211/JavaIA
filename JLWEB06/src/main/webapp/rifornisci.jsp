<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
int litriVerde = (Integer) application.getAttribute("litriVerde");
int litriDiesel = (Integer) application.getAttribute("litriDiesel");
double prezzoVerde = 1.85;
double prezzoDiesel = 1.60;

double totale = 0;
int litri = 0;

if(request.getParameter("tipo") != null && request.getParameter("litri") != null){
    String tipo = request.getParameter("tipo");
    litri = Integer.parseInt(request.getParameter("litri"));
    if(tipo.equals("verde") && litri <= litriVerde){
        totale = litri * prezzoVerde;
        litriVerde -= litri;
        application.setAttribute("litriVerde", litriVerde);
    } else if(tipo.equals("diesel") && litri <= litriDiesel){
        totale = litri * prezzoDiesel;
        litriDiesel -= litri;
        application.setAttribute("litriDiesel", litriDiesel);
    } else {
        totale = -1; // litri insufficienti
    }
}
%>
<table width="100%" border="1">
<tr><td><h1 align="center">Rifornimento</h1></td></tr>
<tr><td align="center">
<form method="get">
    Tipo carburante: 
    <select name="tipo">
        <option value="verde">Verde</option>
        <option value="diesel">Diesel</option>
    </select>
    Litri da rifornire: <input type="number" name="litri" min="1">
    <input type="submit" value="Calcola prezzo">
</form>
</td></tr>

<% if(request.getParameter("tipo") != null){ %>
    <% if(totale == -1){ %>
        <tr><td align="center"><h2>Litri insufficienti!</h2></td></tr>
    <% } else { %>
        <tr><td align="center"><h2>Prezzo totale: euro<%=totale%></h2></td></tr>
    <% } %>
<% } %>

<tr><td align="center"><h3>Litri rimanenti: Verde: <%=litriVerde%>, Diesel: <%=litriDiesel%></h3></td></tr>
<tr><td align="center"><a href="index.jsp">Torna al menu principale</a></td></tr>
</table>
