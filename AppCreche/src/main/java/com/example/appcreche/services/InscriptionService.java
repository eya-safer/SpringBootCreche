package com.example.appcreche.services;

import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.InscriptionDTO;
import com.example.appcreche.models.Parent;
import com.example.appcreche.models.Secretaire;
import com.example.appcreche.repositories.BabysitterRepository;
import com.example.appcreche.repositories.ParentRepository;
import com.example.appcreche.repositories.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {



    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private SecretaireRepository secretaireRepository;
    @Autowired
    private BabysitterRepository babysitterRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void inscrireUtilisateur(InscriptionDTO inscriptionDTO) {
        if ("parent".equalsIgnoreCase(inscriptionDTO.getRole())) {
            inscrireParent(inscriptionDTO);
        } else if ("babysitter".equalsIgnoreCase(inscriptionDTO.getRole())) {
            inscrireBabysitter(inscriptionDTO);
        }
        else if ("secretaire".equalsIgnoreCase(inscriptionDTO.getRole())) {
            inscrireSecretaire(inscriptionDTO);
        }
        else {
            throw new IllegalArgumentException("Rôle non valide pour l'inscription.");
        }
    }

    private void inscrireParent(InscriptionDTO inscriptionDTO) {
        Parent parent = new Parent(inscriptionDTO.getNom(), inscriptionDTO.getPrenom(),inscriptionDTO.getUsername(),
                inscriptionDTO.getEmail(), passwordEncoder.encode(inscriptionDTO.getPassword()),
                inscriptionDTO.getAdresse(), inscriptionDTO.getTelephone(),
                inscriptionDTO.getSalaire());

        parentRepository.save(parent);
    }

    private void inscrireBabysitter(InscriptionDTO inscriptionDTO) {
        Babysitter babysitter = new Babysitter(inscriptionDTO.getNom(), inscriptionDTO.getPrenom(),inscriptionDTO.getUsername(),
                inscriptionDTO.getEmail(), passwordEncoder.encode(inscriptionDTO.getPassword()),
                inscriptionDTO.getAdresse(), inscriptionDTO.getTelephone(),
            inscriptionDTO.getExperience(),  inscriptionDTO.getSalaire());

        babysitterRepository.save(babysitter);
    }




    private void inscrireSecretaire(InscriptionDTO inscriptionDTO) {
        Secretaire secretaire = new Secretaire(inscriptionDTO.getNom(), inscriptionDTO.getPrenom(),inscriptionDTO.getUsername(),
                inscriptionDTO.getEmail(), passwordEncoder.encode(inscriptionDTO.getPassword()),
                inscriptionDTO.getAdresse(), inscriptionDTO.getTelephone(),
                inscriptionDTO.getExperience(),  inscriptionDTO.getSalaire());

        secretaireRepository.save(secretaire);
    }














}
