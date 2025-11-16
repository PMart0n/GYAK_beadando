package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Eloadas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EloadasRepository extends CrudRepository<Eloadas, Long> {
}