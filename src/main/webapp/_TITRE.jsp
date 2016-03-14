<%-- 
    Document   : _TITRE
    Created on : 10 mars 2016, 16:04:05
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="titre"> </div>

<div class="connexion">
    <c:choose>
        <c:when test="${sessionScope.login==null}">
            <a href="inscription.jsp">Inscription</a>
            <a href="connexion.jsp">Se Connecter</a>
        </c:when>
        <c:otherwise>
            Bonjour ${sessionScope.login} !
            <br/>
            <a href="mes_articles_servlet">Mes articles</a>
            <br/>
            <a href="mes_encheres_servlet">Mes ench&egrave;res</a>
            <br/>
            <a href="deconnexion_servlet">D&eacute;connexion</a>
        </c:otherwise>
    </c:choose>

</div>


