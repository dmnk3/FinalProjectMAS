package com.example.projectfinalmas.model;

import com.example.projectfinalmas.enums.RodzajPojazdu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pojazd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "marka jest wymagana")
    private String marka;

    @NotBlank(message = "model jest wymagany")
    private String model;

    @NotBlank(message = "rodzaj jest wymagany")
    @Enumerated(EnumType.STRING)
    @Pattern(regexp = "COUPE|SEDAN|SUV|PICKUP|KOMBI", message = "niepoprawny rodzaj pojazdu")
    private RodzajPojazdu rodzaj;

    @NotBlank(message = "silnik jest wymagany")
    private String silnik;

    @NotNull
    private int iloscmiejsc;

    @NotNull
    private double pojemnoscBagaznika;

    @NotNull
    private double dlugosc;

    @NotNull
    private double szerokosc;

    @NotNull
    private double wysokosc;

    @NotNull
    private double przeswit;

    public String getModel() {
        return model;
    }

    public String getMarka() {
        return marka;
    }
}
