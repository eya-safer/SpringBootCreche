package com.example.appcreche.controllers;





import com.example.appcreche.models.User;
import com.example.appcreche.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUserss();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }






}