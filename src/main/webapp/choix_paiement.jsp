<%-- 
    Document   : choix_paiement
    Created on : 14 mars 2016, 14:46:12
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
            <a href="payer_paypals_servlet"><img src="Images/paypal.jpg" alt=""/></a>
            <a href="payer_cb_servlet"><img src="Images/Logo_CB.png" alt=""/></a>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
