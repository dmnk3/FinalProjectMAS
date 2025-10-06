package com.example.projectfinalmas.repositories;

import com.example.projectfinalmas.model.PojazdKlienta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PojazdKlientaRepository extends CrudRepository<PojazdKlienta, Long> {

    List<PojazdKlienta> findByWlascicielId(Long wlascicielId);
}
