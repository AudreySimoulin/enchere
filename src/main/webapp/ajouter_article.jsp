<%-- 
    Document   : ajouter_article
    Created on : 10 mars 2016, 16:54:47
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
            <form method="post" action="ajouter_article_servlet">
                <table>
                    <tr>
                        <td><label>Nom de l'article</label></td>
                        <td><input type="text" name="nom"/></td>
                    </tr>
                    <tr>
                        <td><label>Description</label></td>
                        <td><textarea name="contenu"></textarea></td>
                    </tr>
                    <tr>
                        <td><label>Cat&eacute;gorie</label></td>
                        <td>
                            <select name="categorie">
                                <c:forEach items="${mesCategories}" var="maCategorie">
                                    <option value="${maCategorie.id}">${maCategorie.nom}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Prix de d&eacute;part</label></td>
                        <td><input type="text" name="prixDepart"/></td>
                    </tr>
                </table>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
