package com.example.projectfinalmas.model;

import com.example.projectfinalmas.enums.TypPrzedmiotu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Pattern(regexp = "NARZEDZIE|CZESC", message = "Nieprawidlowy typ")
    private TypPrzedmiotu typ;
    private double cenaDetaliczna;


    //asocjacja z magazynem
    @ManyToOne
    @JoinColumn(name = "magazyn_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Magazyn lokalizacja;
    //

    //asocjacja z przedmiot w zgloszeniu
    @OneToMany(mappedBy = "przedmiotUzyty", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PrzedmiotWZgloszeniu> wZgloszeniu;
    //
}
