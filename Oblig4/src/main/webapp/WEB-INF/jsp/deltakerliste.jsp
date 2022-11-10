<jsp:useBean id="deltaker" scope="session" type="no.hvl.dat108.oblig4.model.Deltaker" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltakerliste</title>
</head>
<body>
<p>Innlogget som: ${deltaker.mobilnummer} / ${deltaker.fornavn}</p>
<h2>Deltakerliste</h2>
<table>
    <tr>
        <th>Kjønn</th>
        <th>Navn</th>
        <th>Mobil</th>
    </tr>

    <c:forEach var="b" items="${deltakere}">
    <tr style="...">
        <td>${b.kjonn.equals("mann") ? "&#9794" : "&#9792"}</td>
        <td>${b.fornavn} ${b.etternavn}</td>
        <td>${b.mobilnummer}</td>
    </tr>
    </c:forEach>

</table>
<br>
<form action="utlogging" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>