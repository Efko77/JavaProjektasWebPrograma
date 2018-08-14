package laikoKontrole.lt.laikas.model.singleton;

//import laikoKontrole.lt.laikas.model.ProxyServer;

import laikoKontrole.lt.laikas.controller.HistoryController;

public class Singleton {
    public static HistoryController getInstance;
    private static Singleton firstInstance = null;
    private boolean started = false;

    private long kiekSkyreLaiko = 0;
    private long startTime = 0;


    /*private Singleton() {

        ProxyServer myProxy = new ProxyServer(8085);
        myProxy.listen();
        readData();
    }*/

    private void readData() {
    }

    public static Singleton getInstance() {
        if (firstInstance == null)
            firstInstance = new Singleton();
        return firstInstance;
    }

    private boolean login = false;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }


    public void startCounting(int i) {
        started = true;
        kiekSkyreLaiko = i;

        // isiminti kada pradeta naudoti date
        //laiko skaiciavimas
        startTime = (long) (System.currentTimeMillis() / 1000L);


    }

    public String kiekLikoLaiko() {
        // atsakymas = (pradinis laikas + laikas leistas)- dabartinis laikas
        long curentTime = (long) (System.currentTimeMillis() / 1000L);
        if (paused) {
            startTime = curentTime;
        }
        long likoLaiko = startTime - curentTime + kiekSkyreLaiko;
        if (likoLaiko <= 0) {
            started = false;
        }
        return (startTime - curentTime + kiekSkyreLaiko) + "s";
    }

    public long getKiekSkyreLaiko() {
        return kiekSkyreLaiko;
    }


    private boolean paused;

    public boolean getPaused() {
        return paused;
    }

    public void pauseTimer() {
        paused = true;
        long curentTime = (long) (System.currentTimeMillis() / 1000L);
        kiekSkyreLaiko = startTime - curentTime + kiekSkyreLaiko;

    }

    public void unpauseTimer() {
        paused = false;
    }



    public boolean getList() {
        return false;
    }
}