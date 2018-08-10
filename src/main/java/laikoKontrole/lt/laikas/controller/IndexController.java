package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("loginData", new LoginData());
        return "index";
    }



}
