package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Mozi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoziRepository extends JpaRepository<Mozi, Long> {
}