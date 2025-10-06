package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PojazdKlienta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Min(0)
    private int przebieg;

    @NotBlank(message = "nr rejestracyjny jest wymagany")
    private String nrRejestracyjny;

    //asocjacja z klient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient wlasciciel;
    //

    //asocjacja ze zgloszenie serwisowe
    @OneToMany(mappedBy = "pojazdWSerwisie")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ZgloszenieSerwisowe> serwisy = new HashSet<>();


    //Atrybut zlozony
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pojazd_id", nullable = false)
    private Pojazd pojazd;

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public Long getId() {
        return id;
    }
}
