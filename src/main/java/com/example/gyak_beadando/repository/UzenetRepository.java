package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Uzenet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzenetRepository extends CrudRepository<Uzenet, Long> {
    // Ide jöhetnek majd egyedi lekérdezések, pl. findAllByOrderByIdDesc()
}