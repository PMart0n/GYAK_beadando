package com.example.gyak_beadando.repository;

import com.example.gyak_beadando.entity.Mozi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoziRepository extends CrudRepository<Mozi, Long> {
}