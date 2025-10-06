package com.example.projectfinalmas.services;

import com.example.projectfinalmas.DTO.HistoriaSerwisowaDTO;
import com.example.projectfinalmas.repositories.ZgloszenieSerwisoweRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZgloszenieSerwisoweService {
    private final ZgloszenieSerwisoweRepository repository;

    public ZgloszenieSerwisoweService(ZgloszenieSerwisoweRepository repository)
    {
        this.repository = repository;
    }

    public List<HistoriaSerwisowaDTO> findByPojazdWSerwisie_Id(Long pojazdId) {
        return repository.findByPojazdWSerwisie_Id(pojazdId).stream()
                .map(z -> new HistoriaSerwisowaDTO(z.getStatus().toString(), z.getOpis()))
                .collect(Collectors.toList());
    }
}
