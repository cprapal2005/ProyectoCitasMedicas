package com.books.booktracker.repositories;

import com.books.booktracker.models.Cita;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Long> {
}
