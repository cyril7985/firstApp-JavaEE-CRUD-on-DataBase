<%-- 
    Document   : villeDelete
    Created on : 14 mai 2018, 10:44:56
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Ville delete</title>
    </head>
    <body>
        
        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>Ville Delete</h1>

        <form action="/RevisionWeb/VilleDelete"  method="GET">
            <label for="Delete">Ville: </label><br><br>
            <select name="listeVille" ><br><br>
                <option value="0">*** Veuillez sélectionner une ville ***</option>
                <c:forEach items="${listeVille}" var="element">
                    <option value="${element.nomVille}">${element.nomVille}</option>
                </c:forEach>
            </select><br><br>
            <input type="submit" value="Supprimer" name="Supprimer" />          
        </form><br><br>
        
        ${message}

    </body>
</html>
