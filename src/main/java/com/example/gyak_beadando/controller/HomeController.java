package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.repository.FilmRepository;
import com.example.gyak_beadando.repository.MoziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Repository lekeres
    @Autowired private FilmRepository filmRepo;
    @Autowired private MoziRepository moziRepo;

    // lefutn http://localhost:8000 oldal
    @GetMapping("/")
    public String fooldal(Model model) {

        model.addAttribute("filmek", filmRepo.findAll());
        model.addAttribute("mozik", moziRepo.findAll());

        return "index";
    }
}