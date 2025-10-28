<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
int litriVerde = (Integer) application.getAttribute("litriVerde");
int litriDiesel = (Integer) application.getAttribute("litriDiesel");
%>
<table width="100%" border="1">
<tr><td><h1 align="center">Litri Disponibili</h1></td></tr>
<tr><td><h1 align="center">Verde: <%=litriVerde%> litri</h1></td></tr>
<tr><td><h1 align="center">Diesel: <%=litriDiesel%> litri</h1></td></tr>
<tr><td><h1 align="center"><a href="index.jsp">Torna al menu principale</a></h1></td></tr>
</table>
