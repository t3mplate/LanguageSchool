package ru.mirea.cursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cart {
    @GetMapping("/cart")
    public String revpage() {
        return ("cart");
    }
}
