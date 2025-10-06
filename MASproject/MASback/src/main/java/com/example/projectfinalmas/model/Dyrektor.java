package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Dyrektor extends Pracownik{

    @ElementCollection
    @CollectionTable(name = "uzyskaneCertyfikaty", joinColumns = @JoinColumn(name = "dyrektor_id"))
    @Builder.Default
    private Set<String> uzyskaneCertyfikaty = new HashSet<>();

    //konstruktor kopiujacy
    public Dyrektor(Pracownik p, Set<String> uzyskaneCertyfikaty)
    {
        super(p,p.getDatazatrudnienia(), p.getZarobki(), p.getPesel());
        this.uzyskaneCertyfikaty = uzyskaneCertyfikaty;
    }
}
