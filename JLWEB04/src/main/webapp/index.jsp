<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! int primovalore; %>
<%! int secondovalore;  %>
<%! int risultato;  %>
<%! String operazione = "attesa";  %>

<%

if (request.getParameter("valore") != null ) {
	
	if (primovalore == 0) {
		primovalore = Integer.parseInt(request.getParameter("valore"));
	} else {
		secondovalore = Integer.parseInt(request.getParameter("valore"));
	}
	
	
}

if (request.getParameter("operazione") != null ) {
	operazione = request.getParameter("operazione");
}



if (operazione.equals("somma")) {
	risultato = primovalore + secondovalore;
} else if (operazione.equals("sottrazione")) {
	risultato = primovalore - secondovalore;
} else if (operazione.equals("moltiplicazione")) {
	risultato = primovalore * secondovalore;
} else if (operazione.equals("divisione")) {
	risultato = primovalore / secondovalore;
}

	
%>

<p>Ciao</p>
<form action="" method="get">
<table border="1px" width="20%">

<tr><td colspan="4">
<input type="text" name="display" value="<%= primovalore %>,<%= secondovalore %>,<%= risultato %>,<%= operazione %>"></input>
</td></tr>

<tr>
<td><a href="index.jsp?valore=7"><img src="img/7.jpg"></a></td>
<td><a href="index.jsp?valore=8"><img src="img/8.jpg"></a></td>
<td><a href="index.jsp?valore=9"><img src="img/9.jpg"></a></td>
<td><a href="index.jsp?operazione=somma"><img src="img/somma.jpg"></a></td>
</tr>
<tr>
<td><a href="index.jsp?valore=4"><img src="img/4.jpg"></a></td>
<td><a href="index.jsp?valore=5"><img src="img/5.jpg"></a></td>
<td><a href="index.jsp?valore=6"><img src="img/6.jpg"></a></td>
<td><a href="index.jsp?operazione=sottrazione"><img src="img/sottrazione.jpg"></a></td>
</tr>
<tr>
<td><a href="index.jsp?valore=1"><img src="img/1.jpg"></a></td>
<td><a href="index.jsp?valore=2"><img src="img/2.jpg"></a></td>
<td><a href="index.jsp?valore=3"><img src="img/3.jpg"></a></td>
<td><a href="index.jsp?operazione=moltiplicazione"><img src="img/moltiplicazione.jpg"></a></td>
</tr>
<tr>
<td></td><td>
<a href="index.jsp?valore=0"><img src="img/0.jpg"></a></td>
<td>=</td>
<td><a href="index.jsp?operazione=divisione"><img src="img/divisione.jpg"></a></td>
</tr>

</table>
</form>

</body>
</html>