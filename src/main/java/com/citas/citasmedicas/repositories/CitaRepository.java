package com.citas.citasmedicas.repositories;

import com.citas.citasmedicas.models.Cita;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaAuditing
@Repository
public interface CitaRepository extends CrudRepository<Cita, Long> {
}
