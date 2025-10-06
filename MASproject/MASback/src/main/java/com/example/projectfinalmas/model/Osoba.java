package com.example.projectfinalmas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "email jest wymagany")
    @Size(min = 2, max = 255)
    private String email;

    @NotBlank(message = "imie jest wymagane")
    @Size(min = 2, max = 255)
    private String imie;

    @NotBlank(message = "nazwisko jest wymagane")
    @Size(min = 2, max = 255)
    private String nazwisko;

    @NotBlank(message = "nr telefonu jest wymagany")
    @Size(max = 9)
    private String nrtelefonu;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrtelefonu() {
        return nrtelefonu;
    }

    public Osoba(Osoba o) {
        this.id = o.id;
        this.email = o.email;
        this.imie = o.imie;
        this.nazwisko = o.nazwisko;
        this.nrtelefonu = o.nrtelefonu;
    }
    public Osoba(){}
}
