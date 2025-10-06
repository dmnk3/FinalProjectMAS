package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Serwisant extends Pracownik{

    @NotNull
    private int iloscNaprawionychSamochodow;

    //asocjacja z udzial w naprawie

    @OneToMany(mappedBy = "serwisantWNaprawie", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<UdzialWNaprawie> serwisy;

    //konstruktor kopiujacy
    public Serwisant(Pracownik p, int iloscNaprawionychSamochodow)
    {
        super(p,p.getDatazatrudnienia(), p.getZarobki(), p.getPesel());
        this.iloscNaprawionychSamochodow = iloscNaprawionychSamochodow;
    }
}
