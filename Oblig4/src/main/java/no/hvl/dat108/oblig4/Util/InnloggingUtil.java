package no.hvl.dat108.oblig4.Util;

import javax.servlet.http.HttpSession;

public class InnloggingUtil {
    private static boolean erInnlogget;

    public  static void loggUt(HttpSession session) {
        session.invalidate();
        erInnlogget = false;
    }

    public static void loggInn(HttpSession session) {
        erInnlogget = true;
    }

    public static boolean erInnlogget(HttpSession session) {
        return session != null && session.getAttribute("deltaker") != null && erInnlogget;
    }
}
