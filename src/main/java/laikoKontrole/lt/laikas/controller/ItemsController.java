package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.ItemsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class ItemsController {

    @GetMapping("/items")
    @ResponseBody

    public String getAll() {
        String result = "";
        FileReader reader = null;
        try {
            reader = new FileReader("data1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(reader);
        String prefix = "";
        while (sc.hasNext()) {

            result += prefix + sc.nextLine();
            prefix = "\n";
        }


        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    @PostMapping("/items/add")
    @ResponseBody
    public String addItem(@RequestBody ItemsVO item) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("data2.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write("\n" + item.done + " " + item.title);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAll();
    }


    @GetMapping("/items/delete/{eilNr}")
    @ResponseBody
    public String deleteItem(@PathVariable(value = "eilNr") int eilNr) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("data1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(reader);
        String result = "";
        String prefix = "";
        int i = 0;
        while (sc.hasNext()) {
            if (i == eilNr) {
                sc.nextLine();
            } else {
                result += prefix + sc.nextLine();
                prefix = "\n";
            }
            i++;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter("data1.txt");
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getAll();
    }
}
