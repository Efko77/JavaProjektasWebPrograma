package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.Adresai;
import laikoKontrole.lt.laikas.model.InternetoAdresai;
import laikoKontrole.lt.laikas.model.ItemsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class HistoryController {

    @GetMapping("/list")
    public String countsList(Model model, @RequestBody ItemsVO item) {
        List<Adresai> counts = new ArrayList<>();

        FileWriter writer = null;
        try {
            writer = new FileWriter("data1.txt", true);
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

        model.addAttribute("counts", counts);
        return "list";


    }
}
