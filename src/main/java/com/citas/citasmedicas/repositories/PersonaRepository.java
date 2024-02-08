package com.citas.citasmedicas.repositories;

import com.citas.citasmedicas.models.Persona;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaAuditing
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    Optional<Persona> findByUsername(String usuario);
}
