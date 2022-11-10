package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import no.hvl.dat108.oblig4.database.DeltakerService;
import no.hvl.dat108.oblig4.model.Deltaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("${app.url.paamelding}")
public class PaameldingController {

    private final DeltakerService service;
    private String mobFinnes = "Mobilnummer finnes allerede i databasen!";

    // Virker på samme måte som @Autowired
    public PaameldingController(DeltakerService service) {
        this.service = service;
    }

    @GetMapping
    public String paamelding(Model model) {
        model.addAttribute("deltaker", new Deltaker());
        return "paamelding";
    }

    @PostMapping
    public String postPaamelding(@Valid @ModelAttribute("deltaker") Deltaker deltaker,
                                 BindingResult bs,
                                 HttpSession session, RedirectAttributes ra) {
        if (bs.hasErrors()) {
            System.err.println("Error" + bs.getAllErrors());
            return "paamelding";
        }

        // Hvis mobilnummer finnes, ikke godta
        if (service.deltakerFinnes(deltaker)) {
            ra.addFlashAttribute("Mobilnummer", mobFinnes);
            return "redirect:" + "paamelding";
        }
        System.out.println(deltaker);
        service.leggTilDeltaker(deltaker);
        session.setAttribute("deltaker", deltaker);
        InnloggingUtil.loggInn(session);

        return "redirect:" + "paameldt";
    }

}

