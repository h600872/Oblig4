package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("${app.url.paameldt}")
class PaameldtController {



    @Value("${app.message.paameldt}")
    private String errorMelding;

    @GetMapping
    public String paameldingSkjema(HttpSession session, RedirectAttributes ra) {
        if (!InnloggingUtil.erInnlogget(session)) {
            System.err.println("Ikke innlogget");
            ra.addFlashAttribute("error", errorMelding);
            return "redirect:" + "innlogging";
        }
        return "paameldt";
    }
}
