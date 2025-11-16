package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Eloadas;
import org.springframework.data.jpa.repository.JpaRepository; // Ez az új import
import org.springframework.stereotype.Repository;

@Repository
public interface EloadasRepository extends JpaRepository<Eloadas, Long> {
    // A JpaRepository már  tud lapozni!
}