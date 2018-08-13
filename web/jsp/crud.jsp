<%-- 
    Document   : crud
    Created on : 15 mai 2018, 15:46:52
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="/RevisionWeb/css/main.css" />
        <title>Crud</title>
    </head>

    <body>
        
        <header>
            <%@ include file="header.jsp" %>
        </header>

        <nav>
            <%@ include file="nav.jsp" %>
        </nav>
        <h1>Le crud!</h1>

        <table border="0" cellspacing="5" cellpadding="3">
            <thead>
                <tr>
                    <th>ID Pays</th>
                    <th>Nom du pays</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>

                <c:forEach items="${listePays}" var="element">
                    <tr>
                        <td>${element.idPays}</td>
                        <td>${element.nomPays}</td>
                        <td><a href="/RevisionWeb/Crud?id=${element.idPays}"><img src="/RevisionWeb/images/loupe.jpg" width="50"/></a> </td>
                    </tr>
                </c:forEach>               

            </tbody> 
        </table>
        <br>

        <form action="/RevisionWeb/Crud"  method="GET">
            <p>
                <label for="idPays">Id du pays: </label><input type="text" name="idPays" value="${idPays}" />
                <label for="nomPays">Nom du pays: </label><input type="text" name="nomPays" value="${nomPays}" />
            </p>

            <input type="submit" value="Ajouter" name="ajouter"/> 
            <input type="submit" value="Supprimer" name="supprimer"/>           
            <input type="submit" value="Modifier" name="modifier"/>

        </form>
        <br>

        ${message}

    </body>
</html>
