<%-- 
    Document   : tableInterne
    Created on : 3 mai 2018, 12:39:56
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Table interne</title>
    </head>
    <body>
        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>

        <h1>Affichage d'une partie d'une table</h1>
        <br>
        
        ${resultat}<br><br>
        
        ${message}
        
    </body>
</html>
