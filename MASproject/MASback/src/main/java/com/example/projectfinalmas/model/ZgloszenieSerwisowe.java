package com.example.projectfinalmas.model;

import com.example.projectfinalmas.enums.StatusZgloszenia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZgloszenieSerwisowe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Pattern(regexp = "NOWE|ODRZUCONE|ZAAKCEPTOWANE|ANULOWANE|W_TRAKCIE|OCZEKUJACE_NA_CZESCI|ZAKONCZONE", message = "Nieprawidlowy status zgloszenia")
    private StatusZgloszenia status;

    @NotBlank
    private String opis;


    //asocjacja z Usterka
    @OneToMany(mappedBy = "zgloszenieSerwisowe", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Usterka> usterki = new HashSet<>();
    //

    //asocjacja z pojazdklienta
    @ManyToOne
    @JoinColumn(name = "pojazdKlienta_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PojazdKlienta pojazdWSerwisie;
    //

    //asocjacja z udzial w naprawie
    @OneToMany(mappedBy = "naprawa", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<UdzialWNaprawie> serwisanci;
    //

    //asocjacja z przedmiot w zgloszeniu
    @OneToMany(mappedBy = "zgloszenie", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PrzedmiotWZgloszeniu> przedmiotyWykorzystane;
    //


    public String getOpis() {
        return opis;
    }

    public StatusZgloszenia getStatus() {
        return status;
    }
}
