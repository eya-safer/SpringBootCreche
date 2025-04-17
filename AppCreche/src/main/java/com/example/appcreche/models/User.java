package com.example.appcreche.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private String adresse;
    private String telephone;

    // Constructeurs, getters et setters
    public User() {
    }

    public User(String nom, String prenom,String username , String email, String password, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.telephone = telephone;
    }



}