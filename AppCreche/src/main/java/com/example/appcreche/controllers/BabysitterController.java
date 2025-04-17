package com.example.appcreche.controllers;

import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.Secretaire;
import com.example.appcreche.services.BabysitterService;
import com.example.appcreche.services.SecretaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/babysitters")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})

public class BabysitterController {




    private final BabysitterService babysitterService;

    public BabysitterController(BabysitterService babysitterService) {
        this.babysitterService = babysitterService;
    }


    @GetMapping
    public List<Babysitter> getAllBabysitters() {
        return babysitterService.getAllBabysitters();
    }

    @GetMapping("/{id}")
    public Optional<Babysitter> getBabysitterById(@PathVariable Long id) {
        return babysitterService.getBabysitterById(id);
    }

    @PostMapping("/saveBabySitter")
    public Babysitter savebabysitter(@RequestBody Babysitter babysitter) {
        return babysitterService.saveBabysitter(babysitter);
    }

    @DeleteMapping("/{id}")
    public void deleteSecretaire(@PathVariable Long id) {
        babysitterService.deleteUser(id);
    }




}
