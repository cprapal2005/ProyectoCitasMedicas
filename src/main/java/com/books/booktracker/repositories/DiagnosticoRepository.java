package com.books.booktracker.repositories;

import com.books.booktracker.models.Diagnostico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends CrudRepository<Diagnostico, Long> {
}
