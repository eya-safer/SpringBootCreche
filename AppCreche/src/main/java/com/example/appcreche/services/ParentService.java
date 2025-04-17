package com.example.appcreche.services;

import com.example.appcreche.models.Parent;
import com.example.appcreche.models.Secretaire;
import com.example.appcreche.repositories.ParentRepository;
import com.example.appcreche.repositories.SecretaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ParentService {


    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }


    public List<Parent> getAllParents() {
        return (List<Parent>) parentRepository.findAll();
    }

    public Optional<Parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);}

}
