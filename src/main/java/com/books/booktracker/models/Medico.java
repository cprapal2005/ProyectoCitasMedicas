package com.books.booktracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "id_centro_medico", nullable = false)
    private Long idCentroMedico;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_centro_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private CentroMedico centroMedico;

    // Constructor, getters, setters y otros métodos según sea necesario
}

