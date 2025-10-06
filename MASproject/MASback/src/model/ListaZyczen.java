package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"klient_id", "ogloszenie_id"})
})
public class ListaZyczen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dataDodania;

    //asocjacja z klient i ogloszenie
    @ManyToOne
    @JoinColumn(name = "klient_id", nullable = false)
    @NotNull
    private Klient klientObject;

    @ManyToOne
    @JoinColumn(name = "ogloszenie_id", nullable = false)
    @NotNull
    private Ogloszenie ogloszenieObject;
}
