package com.citas.citasmedicas.repositories;

import com.citas.citasmedicas.models.Especializacion;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaAuditing
@Repository
public interface EspecializacionRepository extends CrudRepository<Especializacion, Long> {
}
