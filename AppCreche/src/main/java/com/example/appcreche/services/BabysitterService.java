package com.example.appcreche.services;

import com.example.appcreche.models.Babysitter;

import com.example.appcreche.repositories.BabysitterRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BabysitterService   {

    private final BabysitterRepository babysitterRepositorie;

    public BabysitterService(BabysitterRepository babysitterRepositorie) {
        this.babysitterRepositorie = babysitterRepositorie;
    }


    public List<Babysitter> getAllBabysitters() {
        return (List<Babysitter>) babysitterRepositorie.findAll();
    }

    public Optional<Babysitter> getBabysitterById(Long id) {
        return babysitterRepositorie.findById(id);
    }

    public Babysitter saveBabysitter(Babysitter babysitter) {
        return babysitterRepositorie.save(babysitter);
    }

    public void deleteUser(Long id) {
        babysitterRepositorie.deleteById(id);}



}


