<%--
    Document : Accueil.jsp
    Author : pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>Accueil</h1>
            <br>
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