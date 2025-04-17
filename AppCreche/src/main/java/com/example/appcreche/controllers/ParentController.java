package com.example.appcreche.controllers;

import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.Parent;
import com.example.appcreche.services.BabysitterService;
import com.example.appcreche.services.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ParentController {




    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }


    @GetMapping("/{id}")
    public Optional<Parent> getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @PostMapping("/saveParent")
    public Parent saveParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }




















}
