<%-- 
    Document   : lister_article
    Created on : 11 mars 2016, 10:10:48
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon site d'ench&egrave;res</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <br/>
            <c:forEach items="${mesArticles}" var="monArticle">
                ${monArticle.nom}
                <a href="details_article_servlet?idArticle=${monArticle.id}">D&eacute;tails</a>
                <br/>
            </c:forEach>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
