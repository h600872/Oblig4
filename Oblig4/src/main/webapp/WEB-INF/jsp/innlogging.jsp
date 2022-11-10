<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="css/simple.css">
        <title>Logg inn</title>
    </head>
    <body>
        <h2>Logg inn</h2>
        <p class="error">${error}</p>
        <form action="innlogging" method="post">
        <fieldset>

                <label for="mobilnummer">Mobilnummer:</label>
                <input id="mobilnummer" type="text" pattern="\d{8}" name="mobilnummer" value="${mobilnummer}" required>

                <label for="passord">Passord:</label>
                <input id="passord" type="password" name="passord" required>

                <br><br>
                <button type="submit">Logg inn</button>
                <br><br>

                <a href="paamelding">Er du ikke påmeldt? Klikk her for å registrere deg</a>
            </fieldset>
        </form>
    </body>
</html>