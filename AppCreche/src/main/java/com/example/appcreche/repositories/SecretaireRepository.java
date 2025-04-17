package com.example.appcreche.repositories;

import com.example.appcreche.models.Secretaire;
import com.example.appcreche.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SecretaireRepository extends CrudRepository<Secretaire, Long> {

    User findByUsername(String username);

}
