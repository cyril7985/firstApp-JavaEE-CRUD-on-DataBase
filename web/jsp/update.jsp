<%-- 
    Document   : update
    Created on : 2 mai 2018, 15:27:00
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Update</title>
    </head>
    <body>
        
        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>Modifier les infos d'un pays</h1>
        
        <form action="/RevisionWeb/Update" method="GET">
                <label class="etiquette">Id: </label>
                <input type="text" name="id" value="" />
          
                <label class="etiquette">Nouveau nom du pays  : </label>
                <input type="text" name="nomPays" value="" /> 
                               
        <input type="submit" value="Modifier" name="valider" />
        </form>
        <br>
        
            ${message}
        
    </body>
    
</html>
