<%-- 
    Document   : ajouter_categorie
    Created on : 10 mars 2016, 16:54:19
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
            <form method="post" action="ajouter_categorie_servlet">
                <table>
                    <tr>
                        <td><label>Nom de la cat&eacute;gorie</label></td>
                        <td><input type="text" name="nom"/></td>
                    </tr>
                </table>
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
