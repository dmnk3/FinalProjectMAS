package com.example.projectfinalmas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"przedmiot_id", "zgloszenie_id"})
})
public class PrzedmiotWZgloszeniu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(1)
    private int ilosc;

    //asocjacja z zgloszenie serwisowe i przedmiot
    @ManyToOne
    @JoinColumn(name = "przedmiot_id", nullable = false)
    @NotNull
    private Przedmiot przedmiotUzyty;

    @ManyToOne
    @JoinColumn(name = "zgloszenie_id", nullable = false)
    @NotNull
    private ZgloszenieSerwisowe zgloszenie;
    //
}
