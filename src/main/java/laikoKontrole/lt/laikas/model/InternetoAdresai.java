package laikoKontrole.lt.laikas.model;


import java.net.MalformedURLException;
import java.net.URL;

public class InternetoAdresai {
    private String adresai = "";

    public InternetoAdresai(String adresai) {
        this.adresai = adresai;
    }


    public String getAdresai() {
        return adresai;
    }

    public void setAdresai(String adresai) {
        this.adresai = adresai;
    }


    public static String getDomainName(String url) throws MalformedURLException {
        if (!url.startsWith("http") && !url.startsWith("https")) {
            url = "http://" + url;
        }
        URL netUrl = new URL(url);
        String host = netUrl.getHost();
        if (host.startsWith("www")) {
            host = host.substring("www".length() + 1);
        }
        return host;
    }
}