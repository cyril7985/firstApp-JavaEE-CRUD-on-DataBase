<%-- 
    Document   : VilleCrud
    Created on : 16 mai 2018, 16:13:41
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>VilleCrud</title>
    </head>
    <body>
         <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>VilleCrud</h1>
     
        <table border="0" cellspacing="20" >
            <thead>
                <tr>
                    <th>CP</th>
                    <th>Nom ville</th>
                    <th>ID pays</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
               
            <c:forEach items="${listeVille}" var="element">
                <tr>
                        <td>${element.cp}</td>
                        <td>${element.nomVille}</td>
                        <td>${element.idPays}</td>
                        <td><a href="/RevisionWeb/VilleCrud?cp=${element.cp}"><img src="/RevisionWeb/images/loupe.jpg" width="50"/> </a></td>
                    </tr>
                    </c:forEach>
            </tbody>
        </table>
     
        
        <form action="/RevisionWeb/VilleCrud"  method="GET">
            <label for="cpVille">Code postal: </label><input type="text" name="cpVille" value="${cpVille}" />
            <label for="nomVille">Nom de la ville: </label><input type="text" name="nomVille" value="${nomVille}" />
            <label for="pays">Nom du pays: </label>
             <select name="pays" >
                <option value="0">*** Veuillez sélectionner un pays ***</option>
                <c:forEach items="${pays}" var="element">
                    <option value="${element.idPays}" >${element.nomPays}</option>
                </c:forEach>
            </select><br>
            <p> <input type="submit" value="Ajouter" name="ajouter" />
            <input type="submit" value="Supprimer" name="supprimer" />
            <input type="submit" value="Modifier" name="modifier" />  </p>            
            
        </form>
            <a href="/RevisionWeb/controleurPrincipal"> <input type="submit" value="Acceuil" name="acceuil" /></a>
            ${message}
              ${bouton}

        <footer>
            <%@ include file="footer.jsp" %>
        </footer>

    </body>
</html>
