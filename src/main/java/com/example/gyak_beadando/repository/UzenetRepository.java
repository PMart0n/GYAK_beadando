package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Uzenet;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UzenetRepository extends CrudRepository<Uzenet, Long> {
    List<Uzenet> findAllByOrderByIdDesc();
}