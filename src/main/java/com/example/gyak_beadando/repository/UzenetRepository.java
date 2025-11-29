package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Uzenet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UzenetRepository extends JpaRepository<Uzenet, Long> {
    List<Uzenet> findAllByOrderByIdDesc();
}