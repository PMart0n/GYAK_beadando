package com.example.gyak_beadando.controller;

import com.example.gyak_beadando.entity.Film;
import com.example.gyak_beadando.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/film-kezeles")
public class FilmCrudController {

    @Autowired
    private FilmRepository filmRepo;

    // 1. Listázás (Read)
    @GetMapping
    public String listazas(Model model) {
        model.addAttribute("filmek", filmRepo.findAll());
        return "film_lista"; // Ezt a HTML fájlt fogjuk a következő lépésben létrehozni
    }

    // 2. Új film űrlap (Create)
    @GetMapping("/uj")
    public String ujFilmUrlap(Model model) {
        model.addAttribute("film", new Film());
        return "film_edit"; // Ezt is létrehozzuk majd
    }

    // 3. Mentés (Create & Update)
    @PostMapping("/mentes")
    public String mentes(@ModelAttribute Film film) {
        filmRepo.save(film);
        return "redirect:/film-kezeles";
    }

    // 4. Szerkesztés űrlap betöltése (Update)
    @GetMapping("/szerkesztes/{id}")
    public String szerkesztesUrlap(@PathVariable Long id, Model model) {
        Film film = filmRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hibás Film ID: " + id));
        model.addAttribute("film", film);
        return "film_edit";
    }

    // 5. Törlés (Delete)
    @GetMapping("/torles/{id}")
    public String torles(@PathVariable Long id) {
        try {
            filmRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("Nem törölhető, mert van hozzá kapcsolódó előadás!");
        }
        return "redirect:/film-kezeles";
    }
}