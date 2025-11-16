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

    // 2. Adatbázis oldal (Lapozással)
    @GetMapping("/adatbazis")
    public String adatbazisListazas(Model model, @RequestParam(defaultValue = "0") int page) {
        // Filmek és Mozik (ezekből nincs sok, mehet mind)
        model.addAttribute("filmek", filmRepo.findAll());
        model.addAttribute("mozik", moziRepo.findAll());

        // ELŐADÁSOK LAPOZÁSA:

        Page<Eloadas> eloadasPage = eloadasRepo.findAll(PageRequest.of(page, 100));

        model.addAttribute("eloadasok", eloadasPage);
        model.addAttribute("currentPage", page);

        return "adatbazis";
    }
}