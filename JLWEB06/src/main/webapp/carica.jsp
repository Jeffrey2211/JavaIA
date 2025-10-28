<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
int litriVerde = (Integer) application.getAttribute("litriVerde");
int litriDiesel = (Integer) application.getAttribute("litriDiesel");

if(request.getParameter("tipo") != null && request.getParameter("litri") != null){
    int aggiunti = Integer.parseInt(request.getParameter("litri"));
    String tipo = request.getParameter("tipo");
    if(tipo.equals("verde")) litriVerde += aggiunti;
    if(tipo.equals("diesel")) litriDiesel += aggiunti;
    application.setAttribute("litriVerde", litriVerde);
    application.setAttribute("litriDiesel", litriDiesel);
}
%>
<table width="100%" border="1">
<tr><td><h1 align="center">Carica Diesel o Verde</h1></td></tr>
<tr><td align="center">
<form method="get">
    Tipo carburante: 
    <select name="tipo">
        <option value="verde">Verde</option>
        <option value="diesel">Diesel</option>
    </select>
    Litri da caricare: <input type="number" name="litri" min="1">
    <input type="submit" value="Carica">
</form>
</td></tr>
<tr><td><h1 align="center">Litri attuali: Verde: <%=litriVerde%>, Diesel: <%=litriDiesel%></h1></td></tr>
<tr><td><h1 align="center"><a href="index.jsp">Torna al menu principale</a></h1></td></tr>
</table>
