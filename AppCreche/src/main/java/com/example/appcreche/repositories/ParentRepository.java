package com.example.appcreche.repositories;

import com.example.appcreche.models.Parent;
import com.example.appcreche.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository  extends CrudRepository<Parent, Long> {


    User findByUsername(String username);










}
