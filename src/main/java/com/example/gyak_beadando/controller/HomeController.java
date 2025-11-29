package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.Eloadas;
import com.example.gyak_beadando.repository.EloadasRepository;
import com.example.gyak_beadando.repository.FilmRepository;
import com.example.gyak_beadando.repository.MoziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired private FilmRepository filmRepo;
    @Autowired private MoziRepository moziRepo;
    @Autowired private EloadasRepository eloadasRepo;

    // 1. Főoldal
    @GetMapping("/")
    public String fooldal() {
        return "index";
    }

    // 2. Adatbázis oldal (Tab-os nézet)
    @GetMapping("/adatbazis")
    public String adatbazisListazas(Model model,
                                    @RequestParam(defaultValue = "filmek") String tab, // Melyik táblát mutassuk?
                                    @RequestParam(defaultValue = "0") int page) {      // Hányadik oldalon vagyunk?

        model.addAttribute("activeTab", tab);

        // Csak azt az adatot kérjük le, amire szükség van!
        switch (tab) {
            case "filmek":
                model.addAttribute("filmek", filmRepo.findAll());
                break;
            case "mozik":
                model.addAttribute("mozik", moziRepo.findAll());
                break;
            case "eloadasok":
                Page<Eloadas> eloadasPage = eloadasRepo.findAll(PageRequest.of(page, 100));
                model.addAttribute("eloadasok", eloadasPage);
                model.addAttribute("currentPage", page);
                break;
        }

        return "adatbazis";
    }
}