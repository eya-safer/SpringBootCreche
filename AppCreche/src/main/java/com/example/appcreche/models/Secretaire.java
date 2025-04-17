package com.example.appcreche.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor



public class Secretaire extends User {



    private String experience;

    private String salaire;


    @OneToMany(mappedBy = "id")
    private List<Enfant> enfants;



    public Secretaire() {

    }





    public Secretaire(String nom, String prenom, String username, String email, String password, String adresse, String telephone, String experience, String salaire) {
        super(nom, prenom, username, email, password, adresse, telephone);
        this.experience = experience;
        this.salaire = salaire;
    }

}
