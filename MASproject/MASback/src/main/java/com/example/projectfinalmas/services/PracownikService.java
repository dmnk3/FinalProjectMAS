package com.example.projectfinalmas.services;

import com.example.projectfinalmas.model.Dyrektor;
import com.example.projectfinalmas.model.Pracownik;
import com.example.projectfinalmas.model.Serwisant;
import com.example.projectfinalmas.model.Sprzedawca;
import com.example.projectfinalmas.repositories.DyrektorRepository;
import com.example.projectfinalmas.repositories.PracownikRepository;
import com.example.projectfinalmas.repositories.SerwisantRepository;
import com.example.projectfinalmas.repositories.SprzedawcaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PracownikService {
    private final PracownikRepository pracownikRepository;
    private final SerwisantRepository serwisantRepository;
    private final SprzedawcaRepository sprzedawcaRepository;
    private final DyrektorRepository dyrektorRepository;

    public PracownikService(PracownikRepository pracownikRepository, SerwisantRepository serwisantRepository, SprzedawcaRepository sprzedawcaRepository, DyrektorRepository dyrektorRepository) {
        this.pracownikRepository = pracownikRepository;
        this.serwisantRepository = serwisantRepository;
        this.sprzedawcaRepository = sprzedawcaRepository;
        this.dyrektorRepository = dyrektorRepository;
    }

    @Transactional
    public Serwisant zmienNaSerwisant(Long idPracownika, int iloscNapraw){
        Pracownik stary = pracownikRepository.findById(idPracownika).orElseThrow(() -> new RuntimeException("Nie ma takiego pracownika"));
        Serwisant nowy = new Serwisant(stary,iloscNapraw);
        pracownikRepository.delete(stary);
        return serwisantRepository.save(nowy);
    }

    @Transactional
    public Sprzedawca zmienNaSprzedawca(Long idPracownika, int iloscSprzedanych){
        Pracownik stary = pracownikRepository.findById(idPracownika).orElseThrow(() -> new RuntimeException("Nie ma takiego pracownika"));
        Sprzedawca nowy = new Sprzedawca(stary,iloscSprzedanych);
        pracownikRepository.delete(stary);
        return sprzedawcaRepository.save(nowy);
    }

    @Transactional
    public Dyrektor zmienNaDyrektor(Long idPracownika, Set<String> certyfikaty){
        Pracownik stary = pracownikRepository.findById(idPracownika).orElseThrow(() -> new RuntimeException("Nie ma takiego pracownika"));
        Dyrektor nowy = new Dyrektor(stary, certyfikaty);
        pracownikRepository.delete(stary);
        return dyrektorRepository.save(nowy);
    }
}
