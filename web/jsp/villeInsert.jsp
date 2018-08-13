<%--
    Document : Accueil.jsp
    Author : pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Accueil.jsp</title>
    </head>

    <body>

        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>

        <article id="articleAccueil">
          
            
            <%-- 
    Document   : villeInsert
    Created on : 3 mai 2018, 14:35:16
    Author     : Administrateur
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VilleInsert</title>
    </head>
    <body>
        <h1>Ajouter une ville</h1>

        <form action="/RevisionWeb/VilleInsert"  method="GET">
            <label for=" cp">CP </label> <br>
            <input type="text" name="cp" value="" size="20px" /><br>
            <label for="ville">Ville </label> <br>
            <input type="text" name="ville" value="" size="30px" /><br>
            <label for="pays">Pays </label> <br>
            <select name="pays" >
                <option value="0">*** Veuillez sélectionner un pays ***</option>
                <c:forEach items="${listePays}" var="element">
                    <option value="${element.idPays}">${element.nomPays}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Ajouter" name="ajouter" />

        </form><br>

        ${message}
   
    </body>
</html>

            
            
            
            
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