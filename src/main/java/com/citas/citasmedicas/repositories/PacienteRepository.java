package com.citas.citasmedicas.repositories;

import com.citas.citasmedicas.models.Paciente;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaAuditing
@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}
