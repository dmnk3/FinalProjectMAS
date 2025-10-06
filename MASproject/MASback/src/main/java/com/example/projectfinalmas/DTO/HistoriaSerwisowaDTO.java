package com.example.projectfinalmas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class HistoriaSerwisowaDTO {
    private String status;
    private String opis;

    public HistoriaSerwisowaDTO(String status, String opis) {
        this.status = status;
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public String getStatus() {
        return status;
    }
}
