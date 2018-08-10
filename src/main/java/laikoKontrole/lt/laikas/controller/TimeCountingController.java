package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.LoginData;
import laikoKontrole.lt.laikas.model.TimerData;
import laikoKontrole.lt.laikas.model.singleton.Singleton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


@Controller
public class TimeCountingController {


    @PostMapping("/startTimer")
    public String index(Model model, @ModelAttribute TimerData loginTime) {
            // singletone isiminti kada buvo pradetas laikas
        // singletone isiminti kiek laikob leista
        Singleton.getInstance().startCounting(Integer.parseInt(loginTime.getOptradio()));



        return "redirect:/home";
    }

    private String timer;

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }



    /*private void countTimer(){

        Timer timer = new Timer();
        int counter= 0;
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                timeLeft.setText(Integer.toString(counter));
                counter--;
                if (counter==-1){
                    timer.cancel();
                }else {
                    return --counter;
                }
            }
        };
        timer.scheduleAtFixedRate(task,1000,1000);
    }*/


    /*private void countTimer() {
        final int[] count = {0};
        int delay = 1000;
        ActionListener pushTimerButon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {


                if (count[0] > 0) {
                    count[0]--;
                }
            }
        };
        new Timer(delay, pushTimerButon).start();

    }*/






    /*
    public void countTimer() {
        Scanner sc = new Scanner(v);

        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new String();
        int interval = Integer.parseInt(secs);
        System.out.println(secs);
        //TimerTask tasknew=new TimeScheduleFixedRate();
        Timer timer =new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval(interval));

            }
        }, delay, period);
    }

    public final int setInterval(int interval) {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }*/

}
