package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/utlogging")
public class UtloggingController {

    @PostMapping
    public String utlogging(HttpSession session) {
        InnloggingUtil.loggUt(session);
        return "redirect:" + "innlogging";
    }
}
