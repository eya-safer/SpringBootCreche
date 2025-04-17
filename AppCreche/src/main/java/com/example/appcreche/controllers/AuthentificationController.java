package com.example.appcreche.controllers;

import com.example.appcreche.models.*;
import com.example.appcreche.security.CustomUserDetails;
import com.example.appcreche.security.CustomUserDetailsService;
import com.example.appcreche.security.JwtUtil;
import com.example.appcreche.services.InscriptionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private InscriptionService inscriptionService;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest loginRequest) {
        try {
            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(loginRequest.getUsername());

            if (userDetails != null && passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
                final String jwt = jwtUtil.generateToken(userDetails.getUsername());

                String role = userDetails.getAuthorities().iterator().next().getAuthority();
                User user = (User) userDetails.getUser();

                LoginRequest loginResponse = new LoginRequest(jwt, user, role);

                return ResponseEntity.ok(loginResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PostMapping("/registre")
    public ResponseEntity<String> inscrireUtilisateur(@RequestBody InscriptionDTO inscriptionDTO) {
        inscriptionService.inscrireUtilisateur(inscriptionDTO);
        return ResponseEntity.ok("Inscription réussie.");


    }


}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 class LoginRequest {
    private String jwt;
    private Long id;
    private String nom;
    private String password;
    private String prenom;
    private String username;
    private String email;
    private String role;
    private String adresse;
    private String telephone;
    private String experience;
    private String salaire;
    private String fidelite;

    public LoginRequest(String jwt, User user, String role) {
        this.jwt = jwt;
        this.id = user.getId();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = role;
        this.adresse = user.getAdresse();
        this.telephone = user.getTelephone();

        if (user instanceof Secretaire) {
            this.experience = ((Secretaire) user).getExperience();
            this.salaire = ((Secretaire) user).getSalaire();
        } else if (user instanceof Babysitter) {
            this.experience = ((Babysitter) user).getExperience();
            this.salaire = ((Babysitter) user).getSalaire();
        } else if (user instanceof Parent) {
            this.fidelite = ((Parent) user).getFidelite();
        }
    }
}