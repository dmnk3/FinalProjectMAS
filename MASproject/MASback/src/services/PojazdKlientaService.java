package com.example.projectfinalmas.services;

import com.example.projectfinalmas.DTO.PojazdKlientaDTO;
import com.example.projectfinalmas.model.PojazdKlienta;
import com.example.projectfinalmas.repositories.PojazdKlientaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PojazdKlientaService {
    private final PojazdKlientaRepository repository;

    public PojazdKlientaService(PojazdKlientaRepository pojazdKlientaRepository)
    {
        this.repository = pojazdKlientaRepository;
    }

    public static PojazdKlientaDTO toDTO(PojazdKlienta pojazdKlienta)
    {
        return new PojazdKlientaDTO(
                pojazdKlienta.getId(),
                pojazdKlienta.getPojazd().getMarka(),
                pojazdKlienta.getPojazd().getModel(),
                pojazdKlienta.getPrzebieg(),
                pojazdKlienta.getNrRejestracyjny()
        );
    }

    public List<PojazdKlientaDTO> getAllByKlientId(Long klientId)
    {
        return repository.findByWlascicielId(klientId).stream()
                .map(PojazdKlientaService::toDTO)
                .collect(Collectors.toList());
    }
}
