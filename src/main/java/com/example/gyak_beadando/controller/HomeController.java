package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.repository.FilmRepository;
import com.example.gyak_beadando.repository.MoziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired private FilmRepository filmRepo;
    @Autowired private MoziRepository moziRepo;

    // 1. Főoldal: Csak a bemutatkozás
    @GetMapping("/")
    public String fooldal() {
        return "index";
    }

    // 2. Adatbázis oldal: adatok lekérése a táblázathoz
    @GetMapping("/adatbazis")
    public String adatbazisListazas(Model model) {
        model.addAttribute("filmek", filmRepo.findAll());
        model.addAttribute("mozik", moziRepo.findAll());

        return "adatbazis"; //új adatbazis.html fájl
    }
}