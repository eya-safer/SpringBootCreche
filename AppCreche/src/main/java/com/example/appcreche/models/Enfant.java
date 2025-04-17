package com.example.appcreche.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Component

public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String age;
    private String remarque;
    private String dateInscrit;

    @ManyToOne
    @JoinColumn(name = "secretaire")
    private Secretaire secretaire;

    @ManyToMany
    @JoinTable(
            name = "enfant_babysitter",
            joinColumns = @JoinColumn(name = "enfant_id"),
            inverseJoinColumns = @JoinColumn(name = "babysitter_id")



    )
    private Set<Babysitter> babysitters = new HashSet<>();


    public Enfant() {

    }
}
