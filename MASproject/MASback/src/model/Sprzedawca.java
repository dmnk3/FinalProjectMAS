package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sprzedawca extends Pracownik{

    @NotNull
    private int iloscSprzedanychSamochodow;


    //asocjacja z ogloszenie
    @OneToMany(mappedBy = "wystawia")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Ogloszenie> dodaneOgloszenia = new HashSet<>();
    //
    //konstruktor kopiujacy
    public Sprzedawca(Pracownik p, int iloscSprzedanychSamochodow)
    {
        super(p,p.getDatazatrudnienia(), p.getZarobki(), p.getPesel());
        this.iloscSprzedanychSamochodow = iloscSprzedanychSamochodow;
    }
}
