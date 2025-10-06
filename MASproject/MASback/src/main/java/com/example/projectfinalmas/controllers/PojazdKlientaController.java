package com.example.projectfinalmas.controllers;

import com.example.projectfinalmas.DTO.HistoriaSerwisowaDTO;
import com.example.projectfinalmas.DTO.PojazdKlientaDTO;
import com.example.projectfinalmas.services.PojazdKlientaService;
import com.example.projectfinalmas.services.ZgloszenieSerwisoweService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klienci")
@CrossOrigin(origins = "http://localhost:3000")
public class PojazdKlientaController {
    private final PojazdKlientaService pojazdKlientaService;
    private final ZgloszenieSerwisoweService zgloszenieSerwisoweService;

    public PojazdKlientaController(PojazdKlientaService pojazdKlientaService, ZgloszenieSerwisoweService zgloszenieSerwisoweService)
    {
        this.pojazdKlientaService = pojazdKlientaService;
        this.zgloszenieSerwisoweService = zgloszenieSerwisoweService;
    }

    @GetMapping("/{klientId}/pojazdy")
    public List<PojazdKlientaDTO> getPojazdyKlienta(@PathVariable Long klientId) {
        return pojazdKlientaService.getAllByKlientId(klientId);
    }


    @GetMapping("/{klientId}/pojazdy/{pojazdId}/historia")
    public List<HistoriaSerwisowaDTO> getHistoriaPojazdu(@PathVariable Long klientId, @PathVariable Long pojazdId) {
        return zgloszenieSerwisoweService.findByPojazdWSerwisie_Id(pojazdId);
    }
}