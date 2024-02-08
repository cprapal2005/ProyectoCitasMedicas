package com.citas.citasmedicas.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citas.citasmedicas.Jwt.JwtService;
import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.PersonaRepository;


@Service
public class AuthService {

    private final PersonaRepository personaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(PersonaRepository personaRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.personaRepository = personaRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user= (UserDetails) personaRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        AuthResponse auth = new AuthResponse();

        auth.setToken(jwtService.getToken(user));

        return auth;

    }

    public AuthResponse register(RegisterRequest request) {
        Persona persona = new Persona();

        persona.setUsername(request.getUsername());
        persona.setPassword(passwordEncoder.encode(request.getPassword()));
        persona.setApellido1(request.getApellido1());
        persona.setApellido2(request.getApellido2());
        persona.setNombre(request.getNombre());
        persona.setDni(request.getDni());
        persona.setTelf(request.getTelf());
        persona.setEmail(request.getEmail());

        personaRepository.save(persona);

        AuthResponse auth = new AuthResponse();

        auth.setToken(jwtService.getToken((UserDetails) persona));

        return auth;

    }

}
