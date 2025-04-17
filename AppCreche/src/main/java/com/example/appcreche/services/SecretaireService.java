package com.example.appcreche.services;

import com.example.appcreche.models.Secretaire;
import com.example.appcreche.models.User;
import com.example.appcreche.repositories.SecretaireRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class SecretaireService {

    private final SecretaireRepository secretaireRepository;

    public SecretaireService(SecretaireRepository secretaireRepository) {
        this.secretaireRepository = secretaireRepository;
    }


    public List<Secretaire> getAllSecretaires() {
        return (List<Secretaire>) secretaireRepository.findAll();
    }

    public Optional<Secretaire> getSecretaireById(Long id) {
        return secretaireRepository.findById(id);
    }

    public Secretaire saveSecretaire(Secretaire secretaire) {
        return secretaireRepository.save(secretaire);
    }

    public void deleteSecretaire(Long id) {
        secretaireRepository.deleteById(id);}






}
