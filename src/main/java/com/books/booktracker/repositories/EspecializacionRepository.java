package com.books.booktracker.repositories;

import com.books.booktracker.models.Especializacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecializacionRepository extends CrudRepository<Especializacion, Long> {
}
