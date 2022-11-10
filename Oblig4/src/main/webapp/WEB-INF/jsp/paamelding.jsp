<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <script src="js/password-validator.js" defer></script>
    <title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<p style="color:#ff0000">${redirectMessage}</p>
<form id="deltakerFormBean" action="paamelding" method="post" modelAttribute="deltaker">
    <fieldset>
        <label for="fornavn">Fornavn</label>
        <input id="fornavn" name="fornavn" title="Må inneholde stor forbokstav og være mellom 2 og 20 bokstaver langt"
               pattern="\s*\p{Lu}\p{Ll}+\s*" placeholder="Fyll inn fornavn"
               required="required" type="text" value=""  />

        <br>
        <label for="etternavn">Etternavn</label>
        <input id="etternavn" name="etternavn" title="Må inneholde stor forbokstav og være mellom 2 og 20 bokstaver langt"
               pattern="\s*\p{Lu}\p{Ll}+\s*" placeholder="Fyll inn etternavn"
               required="required" type="text" value=""/>

        <br>
        <span style="color: red">${Mobilnummer}</span>
        <label for="mobilnummer">Mobilnummer (8 siffer)</label>
        <input id="mobilnummer" name="mobilnummer" title="Må ha 8 siffer"
               pattern="\d{8}" placeholder="Fyll inn telefonnummer" type="text" value="" required />


        <br>
        <label for="passord">Passord</label>
        <input id="passord" name="passord" title="Må være minst 6 tegn"
               minlength="6" placeholder="Velg et passord" type="password"
               required="required" value="" onfocus="sjekkPassordStyrke()"/>

        <br>
        <label for="passordRepetert">Passord repetert</label>
        <input id="passordRepetert" name="passordRepetert" title="Må være lik passord"
               minlength="6" placeholder="Gjenta passord" type="password"
               required />

        <br>
        <label>Kjønn:
            <input id="kjonn1" name="kjonn" checked="checked" type="radio" value="mann"/>Mann
            <input id="kjonn2" name="kjonn" type="radio" value="kvinne"/>Kvinne
        </label>
        <br><br><button type="submit">Meld meg på</button>
    </fieldset>
</form>
</body>
</html>