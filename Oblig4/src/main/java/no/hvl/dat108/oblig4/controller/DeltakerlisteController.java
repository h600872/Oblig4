package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import no.hvl.dat108.oblig4.database.DeltakerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("${app.url.deltakerliste}")
public class DeltakerlisteController {

    private final DeltakerService service;

    @Value("Du må være innlogget")
    private String errorMelding;

    public DeltakerlisteController(DeltakerService service) {
        this.service = service;
    }

    @GetMapping
    public String deltakere(Model model, HttpSession session, RedirectAttributes ra) {
        if (!InnloggingUtil.erInnlogget(session)) {
            System.err.println(errorMelding);
            ra.addFlashAttribute("error", errorMelding);
            return "redirect:" + "innlogging";
        }
        model.addAttribute("deltakere", service.hentAlleDeltakere());
        return "deltakerliste";
    }
}
