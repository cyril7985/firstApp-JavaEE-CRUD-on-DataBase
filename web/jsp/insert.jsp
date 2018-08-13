<%-- 
    Document   : insert
    Created on : 2 mai 2018, 14:50:00
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Insert</title>
    </head>
    <body>
        
         <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>Rajouter un pays</h1>

        <form action="/RevisionWeb/InsertValidation" method="GET">
            <label class="etiquette">Id: </label>
            <input type="text" name="id" value="" />
            <br>
            <label class="etiquette">Nom_du_pays : </label>
            <input type="text" name="nomPays" value="" /> 
            <br>

            <input type="submit" value="Valider" name="valider" />
            <br>
            ${message}
    </body>
</form>


</html>
