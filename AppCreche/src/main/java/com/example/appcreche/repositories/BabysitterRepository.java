package com.example.appcreche.repositories;

import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabysitterRepository extends CrudRepository<Babysitter, Long> {



    User findByUsername(String username);











}
