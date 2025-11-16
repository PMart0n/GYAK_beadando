package com.example.gyak_beadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KapcsolatController {

    // Űrlap megjelenítése
    @GetMapping("/kapcsolat")
    public String kapcsolatOldal() {
        return "kapcsolat";
    }

    // Beérkezett üzenetek listázása (Csak belépett felhasználóknak lesz)
    @GetMapping("/uzenetek")
    public String uzenetekListazasa() {
        return "uzenetek";
    }
}