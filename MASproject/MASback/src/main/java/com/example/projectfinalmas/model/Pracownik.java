package com.example.projectfinalmas.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Pracownik extends Osoba{

    @NotNull
    private Date datazatrudnienia;

    @Nullable
    private Date datazwolnienia;

    @Min(4666)
    private double zarobki;

    @NotBlank(message = "pesel jest wymagany")
    private String pesel;

    //konstruktor kopiujacy z klasy abstrakycjnej osoba
    public Pracownik(Osoba o, Date datazatrudnienia, double zarobki, String pesel) {
        super(o);
        this.datazatrudnienia = datazatrudnienia;
        this.zarobki = zarobki;
        this.pesel = pesel;
    }

    public Date getDatazatrudnienia() {
        return datazatrudnienia;
    }

    public Date getDatazwolnienia() {
        return datazwolnienia;
    }

    public double getZarobki() {
        return zarobki;
    }

    public String getPesel() {
        return pesel;
    }
}
