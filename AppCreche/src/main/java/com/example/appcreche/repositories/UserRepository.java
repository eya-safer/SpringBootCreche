package com.example.appcreche.repositories;



import com.example.appcreche.models.User;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByEmail(String email);

    User findByUsername(String username);

}
