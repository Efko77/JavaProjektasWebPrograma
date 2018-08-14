package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.Adresai;
import laikoKontrole.lt.laikas.model.ItemsVO;
import laikoKontrole.lt.laikas.model.LoginData;
import laikoKontrole.lt.laikas.model.TimerData;
import laikoKontrole.lt.laikas.model.singleton.Singleton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @PostMapping("/home")
    public String getPage(@ModelAttribute LoginData login, Model model, HttpServletResponse response) {
        if (login.getPassword().equals("mano")) {

            response.addCookie(new Cookie("isLoggedIn", "true"));
            model.addAttribute("started", Singleton.getInstance().isStarted());
            model.addAttribute("skirtaLaiko", Singleton.getInstance().getKiekSkyreLaiko());
            model.addAttribute("list", Singleton.getInstance().getList());
            //parodykAdresulentele(model);
            uzpildykTimerioDuomenis(model);

            return "home";
        }
        return "redirect:/";
    }

    @GetMapping("/home")
    public String getNormalPage(@CookieValue(value = "isLoggedIn", defaultValue = "false") String isLoggedIn, Model model) {
        if (isLoggedIn.equals("true")) {

            model.addAttribute("started", Singleton.getInstance().isStarted());
            model.addAttribute("likoLaiko", Singleton.getInstance().kiekLikoLaiko());
            model.addAttribute("paused", Singleton.getInstance().getPaused());
            model.addAttribute("tekstas", Singleton.getInstance().getList());
            model.addAttribute("blokuoti", Singleton.getInstance().addDelete());
            uzpildykTimerioDuomenis(model);
            return "home";
        }
        return "redirect:/";

    }



    public void uzpildykTimerioDuomenis(Model model) {
        if (!Singleton.getInstance().isStarted()) {
            model.addAttribute("loginTime", new TimerData());
        }
    }

   /* public void parodykAdresulentele(Model model) {
        if (!Singleton.getInstance().getList()) {
            model.addAttribute("list", new HistoryController());
        }
    }*/


}
