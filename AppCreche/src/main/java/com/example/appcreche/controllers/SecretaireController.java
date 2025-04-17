package com.example.appcreche.controllers;

import com.example.appcreche.models.Secretaire;
import com.example.appcreche.models.User;
import com.example.appcreche.services.SecretaireService;
import com.example.appcreche.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretires")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})

public class SecretaireController {




    private final SecretaireService secretaireService;

    public SecretaireController(SecretaireService secretaireService) {
        this.secretaireService = secretaireService;
    }


    @GetMapping("list")
    public List<Secretaire> getAllSeccretaires() {
        return secretaireService.getAllSecretaires();
    }

    @GetMapping("/{id}")
    public Optional<Secretaire> getSecretaireById(@PathVariable Long id) {
        return secretaireService.getSecretaireById(id);
    }

    @PostMapping("/saveSecretaire")
    public Secretaire saveSecretaire(@RequestBody Secretaire Secretaire) {
        return secretaireService.saveSecretaire(Secretaire);
    }

    @DeleteMapping("/{id}")
    public void deleteSecretaire(@PathVariable Long id) {
        secretaireService.deleteSecretaire(id);
    }






}









