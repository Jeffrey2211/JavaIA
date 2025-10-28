<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestione Squadra</title>
<link rel="stylesheet" href="index.css">
</head>
<body>

<h2>Gestione Squadra di Calcio</h2>

<form method="get" action="index.jsp">
    <button type="submit" name="azione" value="GIOCATORI">Mostra GIOCATORI</button>
    <button type="submit" name="azione" value="RUOLI">Mostra RUOLI</button>
    <button type="submit" name="azione" value="RIEPILOGO">Riepilogo</button>
</form>

<hr>

<%
String azione = request.getParameter("azione");

try {
    String url = "jdbc:mysql://localhost:3306/dbsquadradicalcio";
    String dbUser = "root";
    String dbPass = "";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
    Statement st = conn.createStatement();
    ResultSet rs = null;

    // --- GIOCATORI ---
    if ("GIOCATORI".equals(azione)) {
        out.println("<h3>GIOCATORI</h3>");
        rs = st.executeQuery("SELECT ID, NOME, COGNOME, NUMERO FROM GIOCATORI");
        out.println("<table><thead><tr><th>ID</th><th>NOME</th><th>COGNOME</th><th>NUMERO</th><th>Azioni</th></tr></thead><tbody>");
        while (rs.next()) {
            int id = rs.getInt("ID");
            out.println("<tr>");
            out.println("<td>" + id + "</td>");
            out.println("<td>" + rs.getString("NOME") + "</td>");
            out.println("<td>" + rs.getString("COGNOME") + "</td>");
            out.println("<td>" + rs.getInt("NUMERO") + "</td>");
            out.println("<td><a href='index.jsp?azione=MODIFICA_GIOCATORE&id=" + id + "'>Modifica</a> | "
                      + "<a href='index.jsp?azione=ELIMINA_GIOCATORE&id=" + id + "'>Elimina</a></td>");
            out.println("</tr>");
        }
        out.println("</tbody></table>");
        out.println("<br><form method='get' action='index.jsp'><input type='hidden' name='azione' value='AGGIUNGI_GIOCATORE'><button type='submit'>➕ Aggiungi Giocatore</button></form>");
    }

    // --- RUOLI ---
    else if ("RUOLI".equals(azione)) {
        out.println("<h3>RUOLI</h3>");
        rs = st.executeQuery("SELECT ID, RUOLO FROM RUOLI");
        out.println("<table><thead><tr><th>ID</th><th>RUOLO</th><th>Azioni</th></tr></thead><tbody>");
        while (rs.next()) {
            int id = rs.getInt("ID");
            out.println("<tr>");
            out.println("<td>" + id + "</td>");
            out.println("<td>" + rs.getString("RUOLO") + "</td>");
            out.println("<td><a href='index.jsp?azione=MODIFICA_RUOLO&id=" + id + "'>Modifica</a> | "
                      + "<a href='index.jsp?azione=ELIMINA_RUOLO&id=" + id + "'>Elimina</a></td>");
            out.println("</tr>");
        }
        out.println("</tbody></table>");
        out.println("<br><form method='get' action='index.jsp'><input type='hidden' name='azione' value='AGGIUNGI_RUOLO'><button type='submit'>➕ Aggiungi Ruolo</button></form>");
    }

    // --- RIEPILOGO ---
    /* ===================== RIEPILOGO ===================== */
    else if ("RIEPILOGO".equals(azione)) {
        out.println("<h3>RIEPILOGO (GIOCATORI + RUOLI)</h3>");

        String sql = "SELECT g.ID, g.NOME, g.COGNOME, g.NUMERO, r.RUOLO "
                   + "FROM GIOCATORI g "
                   + "INNER JOIN RUOLI r ON g.IDRUOLO = r.ID";

        PreparedStatement psRie = null;
        ResultSet rsRie = null;
        try {
            psRie = conn.prepareStatement(sql);
            rsRie = psRie.executeQuery();

            out.println("<table><thead><tr><th>ID</th><th>NOME</th><th>COGNOME</th><th>NUMERO</th><th>RUOLO</th></tr></thead><tbody>");

            boolean trovato = false;
            while (rsRie.next()) {
                trovato = true;
                out.println("<tr>");
                out.println("<td>" + rsRie.getInt("ID") + "</td>");
                out.println("<td>" + rsRie.getString("NOME") + "</td>");
                out.println("<td>" + rsRie.getString("COGNOME") + "</td>");
                out.println("<td>" + rsRie.getInt("NUMERO") + "</td>");
                out.println("<td>" + rsRie.getString("RUOLO") + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody></table>");

            if (!trovato) {
                out.println("<p style='color:orange'>Nessun risultato trovato. Controlla che GIOCATORI.IDRUOLO corrisponda a RUOLI.ID e che ci siano righe in entrambe le tabelle.</p>");
            // debug rapido (opzionale)
            try (Statement stDebug = conn.createStatement()) {
                ResultSet r1 = stDebug.executeQuery("SELECT COUNT(*) AS c FROM GIOCATORI");
                if (r1.next()) out.println("<p style='color:gray'>Giocatori totali: " + r1.getInt("c") + "</p>");
                r1.close();
                ResultSet r2 = stDebug.executeQuery("SELECT COUNT(*) AS c FROM RUOLI");
                if (r2.next()) out.println("<p style='color:gray'>Ruoli totali: " + r2.getInt("c") + "</p>");
                r2.close();
            } catch (Exception dbg) { /* ignoro debug error */ }
        }
    } catch (Exception ex) {
        out.println("<p style='color:red'>Errore durante il riepilogo: " + ex.getMessage() + "</p>");
    } finally {
        if (rsRie != null) try { rsRie.close(); } catch (Exception ignore) {}
        if (psRie != null) try { psRie.close(); } catch (Exception ignore) {}
    }
}


    // --- AGGIUNGI GIOCATORE ---
    else if ("AGGIUNGI_GIOCATORE".equals(azione)) {
        if ("POST".equals(request.getMethod())) {
            String nome = request.getParameter("NOME");
            String cognome = request.getParameter("COGNOME");
            int numero = Integer.parseInt(request.getParameter("NUMERO"));
            PreparedStatement ps = conn.prepareStatement("INSERT INTO GIOCATORI (NOME, COGNOME, NUMERO) VALUES (?, ?, ?)");
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setInt(3, numero);
            ps.executeUpdate();
            ps.close();
            response.sendRedirect("index.jsp?azione=GIOCATORI");
        } else {
%>
<h3>Aggiungi Nuovo Giocatore</h3>
<form method="post" action="index.jsp?azione=AGGIUNGI_GIOCATORE">
    NOME: <input type="text" name="NOME" required><br>
    COGNOME: <input type="text" name="COGNOME" required><br>
    NUMERO: <input type="number" name="NUMERO" required><br>
    <button type="submit">Salva</button>
</form>
<%
        }
    }

    // --- AGGIUNGI RUOLO ---
    else if ("AGGIUNGI_RUOLO".equals(azione)) {
        if ("POST".equals(request.getMethod())) {
            String ruolo = request.getParameter("RUOLO");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO RUOLI (RUOLO) VALUES (?)");
            ps.setString(1, ruolo);
            ps.executeUpdate();
            ps.close();
            response.sendRedirect("index.jsp?azione=RUOLI");
        } else {
%>
<h3>Aggiungi Nuovo Ruolo</h3>
<form method="post" action="index.jsp?azione=AGGIUNGI_RUOLO">
    RUOLO: <input type="text" name="RUOLO" required><br>
    <button type="submit">Salva</button>
</form>
<%
        }
    }

    // --- ELIMINA GIOCATORE ---
    else if ("ELIMINA_GIOCATORE".equals(azione)) {
        int id = Integer.parseInt(request.getParameter("id"));
        PreparedStatement ps = conn.prepareStatement("DELETE FROM GIOCATORI WHERE ID = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        response.sendRedirect("index.jsp?azione=GIOCATORI");
    }

    // --- ELIMINA RUOLO ---
    else if ("ELIMINA_RUOLO".equals(azione)) {
        int id = Integer.parseInt(request.getParameter("id"));
        PreparedStatement ps = conn.prepareStatement("DELETE FROM RUOLI WHERE ID = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        response.sendRedirect("index.jsp?azione=RUOLI");
    }

    // --- MODIFICA GIOCATORE ---
    else if ("MODIFICA_GIOCATORE".equals(azione)) {
        int id = Integer.parseInt(request.getParameter("id"));
        if ("POST".equals(request.getMethod())) {
            String nome = request.getParameter("NOME");
            String cognome = request.getParameter("COGNOME");
            int numero = Integer.parseInt(request.getParameter("NUMERO"));
            PreparedStatement ps = conn.prepareStatement("UPDATE GIOCATORI SET NOME=?, COGNOME=?, NUMERO=? WHERE ID=?");
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setInt(3, numero);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
            response.sendRedirect("index.jsp?azione=GIOCATORI");
        } else {
            rs = st.executeQuery("SELECT * FROM GIOCATORI WHERE ID=" + id);
            if (rs.next()) {
%>
<h3>Modifica Giocatore</h3>
<form method="post" action="index.jsp?azione=MODIFICA_GIOCATORE&id=<%=id%>">
    NOME: <input type="text" name="NOME" value="<%=rs.getString("NOME")%>" required><br>
    COGNOME: <input type="text" name="COGNOME" value="<%=rs.getString("COGNOME")%>" required><br>
    NUMERO: <input type="number" name="NUMERO" value="<%=rs.getInt("NUMERO")%>" required><br>
    <button type="submit">Salva</button>
</form>
<%
            }
        }
    }

    // --- MODIFICA RUOLO ---
    else if ("MODIFICA_RUOLO".equals(azione)) {
        int id = Integer.parseInt(request.getParameter("id"));
        if ("POST".equals(request.getMethod())) {
            String ruolo = request.getParameter("RUOLO");
            PreparedStatement ps = conn.prepareStatement("UPDATE RUOLI SET RUOLO=? WHERE ID=?");
            ps.setString(1, ruolo);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            response.sendRedirect("index.jsp?azione=RUOLI");
        } else {
            rs = st.executeQuery("SELECT * FROM RUOLI WHERE ID=" + id);
            if (rs.next()) {
%>
<h3>Modifica Ruolo</h3>
<form method="post" action="index.jsp?azione=MODIFICA_RUOLO&id=<%=id%>">
    RUOLO: <input type="text" name="RUOLO" value="<%=rs.getString("RUOLO")%>" required><br>
    <button type="submit">Salva</button>
</form>
<%
            }
        }
    }

    if (rs != null) rs.close();
    st.close();
    conn.close();

} catch (Exception e) {
    out.println("<p>Errore: " + e.getMessage() + "</p>");
}

if (azione != null) {
    out.println("<hr><form method='get' action='index.jsp'><button type='submit'>Torna al menu</button></form>");
}
%>

</body>
</html>
