class PassordValidator {

    sjekkPassordStyrke(id) {
        const pass = document.getElementById(id)
        if (pass) {
            pass.addEventListener("input", checkValidity)

            function checkValidity() {

                if (pass.validity.valid) {

                    const value = pass.value
                    if (value.length >= 8) {
                        pass.classList.remove("mediumPassord")
                    } else {
                        pass.classList.add("mediumPassord")
                    }
                }
            }

            return () => pass.removeEventListener("input", checkValidity)
        }
    }

    sammenlignPassord(felt1, felt2) {
        const pass = document.getElementById(felt1)
        const repetertPass = document.getElementById(felt2)
        if (pass && repetertPass) {
            pass.addEventListener("input", sammenlign)
            repetertPass.addEventListener("input", sammenlign)

            function sammenlign() {
                if (pass.value === repetertPass.value) {
                    repetertPass.setCustomValidity("")
                } else {
                    repetertPass.setCustomValidity("Gjentatt passord feil")
                }
            }

            return () => {
                pass.removeEventListener("input", sammenlign)
                repetertPass.removeEventListener("input", sammenlign)
            }
        }
    }
}
new PassordValidator().sjekkPassordStyrke("passord")
new PassordValidator().sammenlignPassord("passord", "passordRepetert")
