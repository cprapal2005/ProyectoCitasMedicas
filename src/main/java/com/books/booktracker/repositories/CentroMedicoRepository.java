package com.books.booktracker.repositories;

import com.books.booktracker.models.CentroMedico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroMedicoRepository extends CrudRepository<CentroMedico, Long> {
}
