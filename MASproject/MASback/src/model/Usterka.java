package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usterka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="zgloszenieSerwisowe_id", nullable = false, updatable = false )
    private ZgloszenieSerwisowe zgloszenieSerwisowe;

    @NotBlank(message = "Opis nie moze zostac pusty")
    @Size(min=2, max = 2024)
    private String opis;
}
