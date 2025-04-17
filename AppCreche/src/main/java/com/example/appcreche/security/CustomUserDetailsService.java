package com.example.appcreche.security;


import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.Parent;
import com.example.appcreche.models.Secretaire;
import com.example.appcreche.models.User;

import com.example.appcreche.repositories.BabysitterRepository;
import com.example.appcreche.repositories.ParentRepository;
import com.example.appcreche.repositories.SecretaireRepository;
import com.example.appcreche.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SecretaireRepository secretaireRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private BabysitterRepository babysitterRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Recherchez d'abord dans la table Secretaire
        UserDetails userDetails = loadUserByUsernameFromSecretaire(username);
        // Si l'utilisateur n'est pas trouvé dans la table Secretaire, vérifier dans la table Parent
        if (userDetails == null) {
            userDetails = loadUserByUsernameFromParent(username);
        }
        // Si l'utilisateur n'est pas trouvé dans la table Parent, vérifier dans la table Babysitter
        if (userDetails == null) {
            userDetails = loadUserByUsernameFromBabysitter(username);
        }
        // Si l'utilisateur n'est trouvé dans aucune des tables, lancer une exception
        if (userDetails == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur: " + username);
        }
        return userDetails;
    }

    public UserDetails loadUserByUsernameFromSecretaire(String username) throws UsernameNotFoundException {
        Secretaire secretaire = (Secretaire) secretaireRepository.findByUsername(username);
        if (secretaire == null) {
            return null;
        }
        return new CustomUserDetails(secretaire);
    }

    public UserDetails loadUserByUsernameFromParent(String username) throws UsernameNotFoundException {
        Parent parent = (Parent) parentRepository.findByUsername(username);
        if (parent == null) {
            return null;
        }
        return new CustomUserDetails(parent);
    }

    public UserDetails loadUserByUsernameFromBabysitter(String username) throws UsernameNotFoundException {
        Babysitter babysitter = (Babysitter) babysitterRepository.findByUsername(username);
        if (babysitter == null) {
            return null;
        }
        return new CustomUserDetails(babysitter);
    }
}







