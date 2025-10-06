package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Klient extends Osoba{

    public Klient(){}
    @NotNull(message = "data urodzenia nie moze byc null")
    private Date dataurodzenia;


    //asocjacja z pojazd klienta
    @OneToMany(mappedBy = "wlasciciel")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PojazdKlienta> posiadaneSamochody = new HashSet<>();
    //


    //asocjacja z lista zyczen
    @OneToMany(mappedBy = "klientObject", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ListaZyczen> listaZyczenSet = new HashSet<>();
    //

    public Klient(Osoba o, Date dataurodzenia)
    {
        super(o);
        this.dataurodzenia = dataurodzenia;
    }
}
