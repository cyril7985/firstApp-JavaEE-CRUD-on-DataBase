<%-- 
    Document   : delete
    Created on : 2 mai 2018, 15:13:59
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Delete</title>
    </head>
    <body>
        
        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>Supprimer un pays</h1>
        
         <form action="/RevisionWeb/Delete" method="GET">
                <label class="etiquette">Id: </label>
                <input type="text" name="id" value="" />
                                
                <br>
               
        <input type="submit" value="Valider" name="valider" />
    
     </form>
        
        <p>
            ${message}
            
        </p>
                
        
        
        
        
        
        
    </body>
</html>
