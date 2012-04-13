<%-- 
    Document   : viitenakyma
    Created on : 12.4.2012, 14:30:12
    Author     : Kari Korpinen
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viitteet</title>
    </head>
    <body>
        <h1>Viitteet</h1>

        <h2>Lisää viite</h2>
        <form action="lisaa" method="POST">
            Otsake: <input type="text" name="viitenimi"><br/>
            Tekijä: <input type="text" name="author"><br/>
            Kirjan nimi: <input type="text" name="booktitle"><br/>
            Vuosi: <input type="text" name="vuosi"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Viitteet</h2>
        <ul>
             <c:forEach var="viite" items="${viitteet}">
                <li>Otsake : ${viite.viitenimi} <a href="poista/${viite.id}">poista</a></li>
                <li>Tekijä : ${viite.author} Kirjan nimi : ${viite.booktitle} vuosi : ${viite.vuosi}</li>
            </c:forEach>
        </ul>
    </body>
</html>