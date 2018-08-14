package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.Adresai;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class HistoryController {

    // private static HistoryController firstInstance = null;


    public String count="";

    public void getList() {

        FileReader reader = null;
        try {
            reader = new FileReader("data1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(reader);

        while (sc.hasNext()) {

            count += sc.nextLine() + "\n";
        }


        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

