<%-- 
    Document   : mes_encheres
    Created on : 11 mars 2016, 15:19:32
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
            <br/>
            <h2>Mes ench&egrave;res</h2>
            <br/>
            <table>
                <tr>
                    <td><label>Article</label></td>
                    <td><label>Cat&eacute;gorie</label></td>
                    <td><label>Statut de l'article</label></td>
                    <td><label>Description</label></td>
                    <td><label>Prix actuel</label></td>
                    <td><label>Date de vente</label></td>
                    <td><label>Dernier Ench&eacute;risseur</label></td>
                </tr>
                <c:forEach items="${mesArticles}" var="monArticle">
                    <tr>
                        <td>${monArticle.nom}</td>
                        <td>${monArticle.categorie.nom}</td>
                        <td>${monArticle.statutArticle}</td>
                        <td>${monArticle.contenu}</td>
                        <td>${monArticle.prixActuel}</td>
                        <td>${monArticle.dateVente}</td>
                        <td>${monArticle.dernierEncherisseur.login}</td>
                        <td>
                            <c:choose>
                                <c:when test="${sessionScope.login != monArticle.dernierEncherisseur.login && sessionScope.login != monArticle.utilisateur.login && monArticle.statutArticle == 'disponible'}">
                                    <a href="encherir_servlet?idArticle=${monArticle.id}"><input type="button" value=">>Ench&eacute;rir<<" name="encherir"/></a>
                                </c:when>
                                <c:when test="${monArticle.statutArticle == 'remporté' && sessionScope.login.equals(monArticle.dernierEncherisseur.login)}">
                                <a href="choix_paiement_servlet?idArticle=${monArticle.id}"><input type="button" value="Payer" name="payer"/></a>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>   
                </c:forEach>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body> 
</html>
