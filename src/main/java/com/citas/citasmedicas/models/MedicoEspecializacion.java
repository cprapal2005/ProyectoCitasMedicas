package com.citas.citasmedicas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MEDICO_ESPECIALIZACION")
public class MedicoEspecializacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_medico", nullable = false)
    private Long idMedico;

    @Column(name = "id_especializacion", nullable = false)
    private Long idEspecializacion;

    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especializacion", referencedColumnName = "id", insertable = false, updatable = false)
    private Especializacion especializacion;

    // Constructor, getters, setters y otros métodos según sea necesario
}