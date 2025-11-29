package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.Uzenet;
import com.example.gyak_beadando.repository.UzenetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KapcsolatController {

    @Autowired
    private UzenetRepository uzenetRepository;

    @GetMapping("/kapcsolat")
    public String kapcsolatPage() {
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat-kuld")
    public String kapcsolatKuldes(@RequestParam String kuldoNeve,
                                  @RequestParam String email,
                                  @RequestParam String szoveg,
                                  Model model) {

        // Szerver oldali validáció
        if (kuldoNeve.isEmpty() || email.isEmpty() || szoveg.isEmpty()) {
            model.addAttribute("error", "Minden mező kitöltése kötelező!");
            return "kapcsolat";
        }

        // Mentés az adatbázisba
        Uzenet u = new Uzenet(kuldoNeve, email, szoveg);
        uzenetRepository.save(u);

        model.addAttribute("success", "Üzenet sikeresen elküldve!");
        return "kapcsolat";
    }

    @GetMapping("/uzenetek")
    public String uzenetek(Model model) {

        // Legújabb üzenetek elöl
        var lista = uzenetRepository.findAllByOrderByIdDesc();

        model.addAttribute("uzenetek", lista);
        return "uzenetek";
    }
}