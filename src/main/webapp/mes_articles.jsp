<%-- 
    Document   : mes_articles
    Created on : 11 mars 2016, 14:27:32
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
            <a href="ajouter_article_servlet"><input type="button" name="ajouterArticle" value="Ajouter un article"/></a>
            <br/>
            <br/>
            <h2>Mes articles en vente</h2>
            <br/>
            <table>
                <tr>
                    <td><label>Article</label></td>
                    <td><label>Cat&eacute;gorie</label></td>
                    <td><label>Statut de l'article</label></td>
                    <td><label>Description</label></td>
                    <td><label>Prix de d&eacute;part</label></td>
                    <td><label>Prix actuel</label></td>
                    <td><label>Date de vente</label></td>
                </tr>
                <c:forEach items="${mesArticles}" var="monArticle">
                    <tr>
                        <td>${monArticle.nom}</td>
                    <td>${monArticle.categorie.nom}</td>
                    <td>${monArticle.statutArticle}</td>
                    <td>${monArticle.contenu}</td>
                    <td>${monArticle.prixDepart}</td>
                    <td>${monArticle.prixActuel}</td>
                    <td>${monArticle.dateVente}</td>
                    <td><a href="supprimer_article_servlet?idArticle=${monArticle.id}"><input type="button" name="supprimer" value="supprimer"/></a></td>
                 </tr>   
                </c:forEach>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
