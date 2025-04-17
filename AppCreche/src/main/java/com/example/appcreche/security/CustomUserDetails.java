package com.example.appcreche.security;


import com.example.appcreche.models.Babysitter;
import com.example.appcreche.models.Parent;
import com.example.appcreche.models.Secretaire;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

    private Object user;
 public CustomUserDetails(Object user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Déterminer le rôle en fonction du type d'utilisateur
        if (user instanceof Secretaire) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_SECRETAIRE"));
        } else if (user instanceof Parent) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_PARENT"));
        } else if (user instanceof Babysitter) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_BABYSITTER"));
        } else {
            throw new IllegalArgumentException("Type d'utilisateur non pris en charge: " + user.getClass().getName());
        }
    }
    @Override
    public String getPassword() {
        if (user instanceof Secretaire) {
            return ((Secretaire) user).getPassword();
        } else if (user instanceof Parent) {
            return ((Parent) user).getPassword();
        } else if (user instanceof Babysitter) {
            return ((Babysitter) user).getPassword();
        } else {
            throw new IllegalArgumentException("Type d'utilisateur non pris en charge: " + user.getClass().getName());
        }
    }

    @Override
    public String getUsername() {
        if (user instanceof Secretaire) {
            return ((Secretaire) user).getUsername();
        } else if (user instanceof Parent) {
            return ((Parent) user).getUsername();
        } else if (user instanceof Babysitter) {
            return ((Babysitter) user).getUsername();
        } else {
            throw new IllegalArgumentException("Type d'utilisateur non pris en charge: " + user.getClass().getName());
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}