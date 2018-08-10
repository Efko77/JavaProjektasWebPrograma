package laikoKontrole.lt.laikas.model;

import laikoKontrole.lt.laikas.model.singleton.Singleton;

import java.util.Scanner;
import java.util.TimerTask;

public class TimerData {
    private String timer;
    private String optradio;

    public void timerRun(){
        Singleton.getInstance().isStarted();
    }


    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }


    public String getOptradio() {
        return optradio;
    }

    public void setOptradio(String optradio) {
        this.optradio = optradio;
    }
}
