package com.example.projectfinalmas.repositories;

import com.example.projectfinalmas.model.ZgloszenieSerwisowe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZgloszenieSerwisoweRepository extends CrudRepository<ZgloszenieSerwisowe, Long> {
    List<ZgloszenieSerwisowe> findByPojazdWSerwisie_Id(Long pojazdId);
}
