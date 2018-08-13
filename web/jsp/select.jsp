<%-- 
    Document   : Select
    Created on : 2 mai 2018, 13:12:38
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Affichage de la table Pays</title>
    </head>
    <body>
         <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        
        <h1>
            
           Affichage de la table Pays 
        </h1>
          
        ${table}
        <br><br>
        
        ${message}
        
        
    </body>
</html>
