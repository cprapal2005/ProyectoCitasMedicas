package com.books.booktracker.repositories;

import com.books.booktracker.models.MedicoEspecializacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoEspecializacionRepository extends CrudRepository<MedicoEspecializacion, Long> {
}
