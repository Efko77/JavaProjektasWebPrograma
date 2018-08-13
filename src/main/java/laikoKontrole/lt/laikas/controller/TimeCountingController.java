package laikoKontrole.lt.laikas.controller;


import laikoKontrole.lt.laikas.model.TimerData;
import laikoKontrole.lt.laikas.model.singleton.Singleton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class TimeCountingController {


    @PostMapping("/startTimer")
    public String index(Model model, @ModelAttribute TimerData loginTime) {
            // singletone isiminti kada buvo pradetas laikas
        // singletone isiminti kiek laikob leista
        Singleton.getInstance().startCounting(Integer.parseInt(loginTime.getOptradio()));



        return "redirect:/home";
    }

    @GetMapping("/pauseTimer")
    public String indexPause() {
        Singleton.getInstance().pauseTimer();
        return "redirect:/home";
    }

    @GetMapping("/resumeTimer")
    public String indexResume() {
        Singleton.getInstance().unpauseTimer();
        return "redirect:/home";
    }

    /*@GetMapping("/historyList")
    public String indexhistory() {
        Singleton.getInstance().getList();
        return "redirect:/home";
    }*/





    private String timer;

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }





}
