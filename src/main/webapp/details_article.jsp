<%-- 
    Document   : details_article
    Created on : 11 mars 2016, 10:44:52
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
            Cat&eacute;gorie : ${monArticle.categorie.nom} <br/>
            Nom : ${monArticle.nom} <br/>
            Statut de l'article : ${monArticle.statutArticle} <br/>
            Description : ${monArticle.contenu} <br/>
            Prix de d&eacute;part : ${monArticle.prixDepart} <br/>
            Prix actuel : ${monArticle.prixActuel} <br/>
            Date limite : ${monArticle.dateVente} <br/>
            Vendeur : ${monArticle.utilisateur.login} <br/>
            Dernier Ench&eacute;risseur : ${monArticle.dernierEncherisseur.login}
            <br/>
            <br/>
            <c:if test="${monArticle.dernierEncherisseur.login == null || sessionScope.login != monArticle.dernierEncherisseur.login && sessionScope.login != monArticle.utilisateur.login}">
            <a href="encherir_servlet?idArticle=${monArticle.id}"><input type="button" value=">>Ench&eacute;rir<<" name="encherir"/></a>
            </c:if>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
