package com.example.appcreche.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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


public class Babysitter extends User {


    private String experience;

    private String salaire;

    @ManyToMany(mappedBy = "babysitters")
    private Set<Enfant> enfants = new HashSet<>();

    public Babysitter() {

    }

    public Babysitter(String nom, String prenom, String username, String email, String password, String adresse, String telephone, String experience, String salaire) {

        super(nom, prenom, username, email, password, adresse, telephone);
        this.experience = experience;
        this.salaire = salaire;
    }
}
