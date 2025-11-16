package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.Film;
import com.example.gyak_beadando.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class DiagramController {

    @Autowired
    private FilmRepository filmRepo;

    @GetMapping("/diagram")
    public String diagramOldal(Model model) {
        // összes film
        Iterable<Film> filmek = filmRepo.findAll();

        // Összeszámoljuk (Év -> Darabszám)
        Map<Integer, Integer> statisztika = new HashMap<>();
        for (Film f : filmek) {
            Integer ev = f.getEv();

            statisztika.put(ev, statisztika.getOrDefault(ev, 0) + 1);
        }

        //  évek növekvő sorrendbe
        Map<Integer, Integer> rendezettStat = new TreeMap<>(statisztika);

        //  adatokat  HTML-nek két külön listában
        //
        model.addAttribute("evek", rendezettStat.keySet());
        model.addAttribute("darabszamok", rendezettStat.values());

        return "diagram";
    }
}