package com.example.appcreche.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Component

public class Parent extends User {


    private String fidelite;


    public Parent(String nom, String prenom, String username, String email, String password, String adresse, String telephone,  String fidelite) {
        super(nom, prenom, username, email, password, adresse, telephone);
        this.fidelite = fidelite;


    }

    public Parent() {

    }


}
