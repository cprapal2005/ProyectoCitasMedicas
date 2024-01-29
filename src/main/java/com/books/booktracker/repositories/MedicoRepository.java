package com.books.booktracker.repositories;

import com.books.booktracker.models.Medico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {
}
