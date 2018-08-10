package laikoKontrole.lt.laikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class HistoryController {


    private ArrayList<String> narsyklesDuomenys;


    public ArrayList<String> getList() {
        return narsyklesDuomenys;
    }

    private void readData(String proxy) {

        narsyklesDuomenys = new ArrayList<>();

        FileReader reader = null;

        try {
            reader = new FileReader(proxy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(reader);

        while (sc.hasNext()) {
            String adresai = sc.next();
            narsyklesDuomenys.add(sc.next());

        }

        sc.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
