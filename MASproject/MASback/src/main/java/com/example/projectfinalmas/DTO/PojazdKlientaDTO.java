package com.example.projectfinalmas.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PojazdKlientaDTO {
    private Long id;
    private String marka;
    private String model;
    private int przebieg;
    private String nrRejestracyjny;

    public PojazdKlientaDTO(Long id, String marka, String model, int przebieg, String nrRejestracyjny) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.przebieg = przebieg;
        this.nrRejestracyjny = nrRejestracyjny;
    }

    public Long getId() {
        return id;
    }
    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getPrzebieg() {
        return przebieg;
    }
}
