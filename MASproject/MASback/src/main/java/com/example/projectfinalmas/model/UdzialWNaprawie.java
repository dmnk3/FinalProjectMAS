package com.example.projectfinalmas.model;

import com.example.projectfinalmas.enums.RolaWNaprawie;
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
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"serwisant_id", "zgloszenieSerwisowe_id"})
})
public class UdzialWNaprawie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Pattern(regexp = "GLOWNY_MECHANIK|POMOCNIK", message = "Nieprawidlowa rola")
    private RolaWNaprawie rola;
    @NotNull
    private double czasPracy;

    //asocjacja z serwisant i zgloszsenie serwisowe

    @ManyToOne
    @JoinColumn(name = "serwisant_id", nullable = false)
    @NotNull
    private Serwisant serwisantWNaprawie;

    @ManyToOne
    @JoinColumn(name = "zgloszenieSerwisowe_id", nullable = false)
    @NotNull
    private ZgloszenieSerwisowe naprawa;
}
