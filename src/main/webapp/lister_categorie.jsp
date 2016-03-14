<%-- 
    Document   : lister_categorie
    Created on : 10 mars 2016, 16:53:36
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
            <a href="ajouter_categorie.jsp"><input type="button" name="ajouterCategorie" value="Ajouter une cat&eacute;gorie"/></a>
            <br/>
            <br/>
            <c:forEach items="${mesCategories}" var="maCategorie">
                ${maCategorie.nom}
                <a href="lister_article_servlet?idCategorie=${maCategorie.id}">Voir les articles</a>
                <a href="supprimer_categorie_servlet?idCategorie=${maCategorie.id}"><input type="button" name="supprimer" value="supprimer"/></a>
                <br/>
            </c:forEach>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
