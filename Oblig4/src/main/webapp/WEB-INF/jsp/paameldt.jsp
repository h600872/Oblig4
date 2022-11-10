<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="deltaker" scope="session" type="no.hvl.dat108.oblig4.model.Deltaker" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
    <p>Påmeldingen er mottatt for</p>

    <p>${deltaker.fornavn}</p>
    <p>${deltaker.etternavn}</p>
    <p>${deltaker.kjonn}</p>
    <p>${deltaker.mobilnummer}</p>

    <a href="deltakerliste">Gå til deltakerlisten</a>
</body>
</html>