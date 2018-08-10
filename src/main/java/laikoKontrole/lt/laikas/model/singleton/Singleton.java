package laikoKontrole.lt.laikas.model.singleton;

public class Singleton {
    private static Singleton firstInstance = null;
    private boolean started = false;

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
}
