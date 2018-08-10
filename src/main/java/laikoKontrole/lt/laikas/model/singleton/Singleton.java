package laikoKontrole.lt.laikas.model.singleton;

import java.util.Date;

public class Singleton {
    private static Singleton firstInstance = null;
    private boolean started = false;
    private int kiekSkyreLaiko = 0;
    private long startTime = 0;

    private Singleton() {
        readData();
    }

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

        startTime =(long) (System.currentTimeMillis()/1000L);


    }

    public String kiekLikoLaiko() {
        // atsakymas = (pradinis laikas + laikas leistas)- dabartinis laikas
        long curentTime =(long) (System.currentTimeMillis()/1000L);
        return (startTime-curentTime+kiekSkyreLaiko)+"s";
    }

    public int getKiekSkyreLaiko() {
        return kiekSkyreLaiko;
    }
}
