package com.citas.citasmedicas.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", nullable = false)
    private Long idPersona;

    @ManyToOne
    @JoinColumn(name = "id_centro_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private CentroMedico centroMedico;

    // Constructor, getters, setters y otros métodos según sea necesario
}

