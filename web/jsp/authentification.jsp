<%-- 
    Document   : authentification
    Created on : 19 mai 2018, 15:12:10
    Author     : cyril
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Authentification</title>
    </head>
    <body>
        
        <header>
            <%@ include file="header.jsp" %>
        </header>
         <nav>
            <%@ include file="nav.jsp" %>
        </nav>

        <h1>Identification</h1>
        
         <form action="/RevisionWeb/AuthentificationValidation" method="GET">
                <label class="etiquette">Pseudo : </label>
                <input type="text" name="pseudo" value="" />
                <br>
                <label class="etiquette">Mot de passe : </label>
                <input type="password" name="mdp" value="" /> 
                <br>
                <label class="etiquette">&nbsp;</label>
                <a href="/jsp/acceuil.jsp"><input type="submit" value="Valider" name="valider" /></a>
                    
                
            </form>
        <article id="articleAccueil">
            
            <label class="messageOrange">
                ${message}
            </label>
            <br><br>
            <img src="/RevisionWeb/images/web.jpg" alt="Photo" title="Photo" width="300"/>
        </article>


         <footer>
            <%@ include file="footer.jsp" %>
        </footer>
    </body>
</html>
