package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.ProxyList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Controller
public class HistoryController {
    protected TextField textField;
    protected TextArea textArea;
    private final static String newline = "\n";




    // button.addActionListener(new ActionListener(){

    public void actionPerfomed(ActiveEvent event) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();
        //textArea.setCaretPosition(textArea.getDocument().getLenght());

    }


/*

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView getdata() {

            ProxyList<proxyAdress> list = getList();

            //return back to index.jsp
            ModelAndView model = new ModelAndView("index");
            model.addObject("lists", list);

            return model;

        }

        private ProxyList<String> getList() {

            ProxyList<String> list = new Arr<String>();
            list.add("List A");

            return list;

        }*/
}
