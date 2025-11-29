package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.repository.FilmRepository;
import com.example.gyak_beadando.repository.MoziRepository;
import com.example.gyak_beadando.repository.UzenetRepository;
import com.example.gyak_beadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private MoziRepository moziRepository;

    @Autowired
    private UzenetRepository uzenetRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String adminHome(Model model) {

        long filmCount = filmRepository.count();
        long moziCount = moziRepository.count();
        long uzenetCount = uzenetRepository.count();
        long userCount = userRepository.count();

        model.addAttribute("filmCount", filmCount);
        model.addAttribute("moziCount", moziCount);
        model.addAttribute("uzenetCount", uzenetCount);
        model.addAttribute("userCount", userCount);

        return "admin";
    }
}