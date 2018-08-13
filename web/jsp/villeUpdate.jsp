<%-- 
    Document   : villeUpdate
    Created on : 14 mai 2018, 13:16:55
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Modifier les paramètres d'une ville</h1>

        <form action="/RevisionWeb/VilleUpdate"  method="GET">
            <label for="listeVille">Ville: </label><br><br>

            <select name="listeVilles" ><br><br>                
                <option value="0">*** Veuillez sélectionner une ville ***</option>
                <c:forEach items="${listeVille}" var="element">
                    <option value="${element.cp}">${element.nomVille}</option>
                </c:forEach>
            </select><br><br>

            <input type="submit" value="Sélectionner" /> 
            <input type="hidden" name="action" value="selectionner" />
        </form>
        <br><br>
        
        <form action="/RevisionWeb/VilleUpdate"  method="GET">
        <!--        <label for="cp"> Code postal :</label><input type="text" name="cp" value="${cp}" />-->
            <label for="nom_ville"> Nom de la ville :</label><input type="text" name="nom_ville" value="${nom_ville}" />
            <label for="site"> Site internet :</label><input type="text" name="site" value="${site}" />
            <label for="photo"> Photo :</label><input type="text" name="photo" value="${photo}"/>
            <label for="id_pays"> Pays :</label><input type="text" name="id_pays" value="${id_pays}" />
            <br><br>
            <input type="submit" value="Valider les modifications" /> 
            <input type="hidden" name="action" value="validerModification" />
            <input type="hidden" name="cp" value="${cp}" />
        </form>
        <!--            <label for="nouveauCp">Nouveau code postal: </label>
                    <input type="text" name="nouveauCp" value="" /> <br><br>
        
                    <label for="nouveauNom">Nouveau nom de la ville: </label>
                    <input type="text" name="nouveauNom" value="" /> <br> <br>        
        
        
                    <label for="nouveauSite">Nouveau site internet: </label>
                    <input type="text" name="nouveauSite" value="" /> <br>  <br>       
        
        
                    <label for="nouvellePhoto">Nouvelle photo: </label>
                    <input type="text" name="nouvellePhoto" value="" /><br><br>
        
                    <label for="nouvelId">Nouvel id: </label>
                    <input type="text" name="nouvelId" value="" /><br><br>-->
        <br><br>

        ${message}

    </body>
</html>
