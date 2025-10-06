package com.example.projectfinalmas.model;

import com.example.projectfinalmas.enums.SkrzynieBiegow;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ogloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private Pojazd pojazd;

    private double cena;

    private String opis;

    private Date dataUtworzenia;

    @ElementCollection
    @CollectionTable(name = "wyposazenie", joinColumns = @JoinColumn(name = "ogloszenie_id"))
    @Builder.Default
    private Set<String> wyposazenie = new HashSet<>();

    private int wyswietleniaOgloszenia;

    private Date rokProdukcji;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Pattern(regexp = "AUTOMATYCZNA|MANUALNA", message = "Nieprawidlowa skrzynia biegow")
    private SkrzynieBiegow skrzyniaBiegow;

    private int przebieg;

    private String kolor;

    private int iloscWlasicieli;

    private String status;

    //asocjacja z sprzedawca
    @ManyToOne
    @JoinColumn(name = "sprzedawca_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Sprzedawca wystawia;
    //

    //asocjacja z lista zyczen
    @OneToMany(mappedBy = "ogloszenieObject", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ListaZyczen> listaZyczenSet;
    //

    //Atrybut zlozony
    @ManyToOne
    @JoinColumn(name = "pojazd_id", nullable = false)
    private Pojazd pojazd;

}
