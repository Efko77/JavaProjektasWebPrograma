package laikoKontrole.lt.laikas.controller;

import laikoKontrole.lt.laikas.model.singleton.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class LaikasApplication {

        public static void main(String[] args) {
            SpringApplication.run(LaikasApplication.class, args);
            Singleton.getInstance();
        }
    }

