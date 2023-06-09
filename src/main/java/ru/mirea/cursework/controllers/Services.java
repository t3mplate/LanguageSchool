package ru.mirea.cursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Services {
    @GetMapping("/main")
    public String homepage(){
        return ("index");
    }

}
