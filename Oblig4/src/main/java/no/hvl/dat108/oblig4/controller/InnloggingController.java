package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import no.hvl.dat108.oblig4.Util.PassordUtil;
import no.hvl.dat108.oblig4.database.DeltakerService;
import no.hvl.dat108.oblig4.model.Deltaker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("${app.url.innlogging}")
public class InnloggingController {
    private final DeltakerService service;

//    @Value("${app.session.maxTidsInterval}")
//    private int maxTidsInterval;

    public InnloggingController(DeltakerService service) {
        this.service = service;
    }

    @GetMapping
    public String inlogging() {
        return "innlogging";
    }

    @PostMapping
    public String behandleInlogging(@RequestParam String mobilnummer, @RequestParam String passord, RedirectAttributes ra, HttpSession session) {

        if (service.deltakerFinnes(mobilnummer)) {
            Deltaker deltaker = service.hentDeltaker(mobilnummer);

            if (PassordUtil.validerMedSalt(passord, deltaker.getSalt(), deltaker.getPassord())) {
                session.setAttribute("deltaker", deltaker);
                InnloggingUtil.loggInn(session);
                return "redirect:" + "deltakerliste";
            } else {
                ra.addFlashAttribute("error", "Feil passord");
                ra.addFlashAttribute("mobilnummer", mobilnummer);
                return "redirect:" + "innlogging";
            }
        } else {
            ra.addFlashAttribute("mobilnumer", mobilnummer);
            ra.addFlashAttribute("error", "Deltaker ekisterer ikke");
            return "redirect:" + "innlogging";
        }
    }
}

