package com.example.gyak_beadando.controller;
import com.example.gyak_beadando.entity.Film;
import com.example.gyak_beadando.entity.Mozi;
import com.example.gyak_beadando.repository.FilmRepository;
import com.example.gyak_beadando.repository.MoziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired private FilmRepository filmRepo;
    @Autowired private MoziRepository moziRepo;

    // Összes film lekérdezése JSON-ban
    // Elérhető: http://localhost:8000/api/filmek
    @GetMapping("/filmek")
    public Iterable<Film> getFilmek() {
        return filmRepo.findAll();
    }

    // Egy adott film lekérdezése ID alapján
    // Elérhető: http://localhost:8000/api/filmek/1
    @GetMapping("/filmek/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        return filmRepo.findById(id);
    }

    // Összes mozi lekérdezése JSON-ban
    // Elérhető: http://localhost:8000/api/mozik
    @GetMapping("/mozik")
    public Iterable<Mozi> getMozik() {
        return moziRepo.findAll();
    }
}