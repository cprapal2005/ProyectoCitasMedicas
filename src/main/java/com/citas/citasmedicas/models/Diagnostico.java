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
@Table(name = "DIAGNOSTICO")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_medico", nullable = false)
    private Long idMedico;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @Column(name = "id_cita", nullable = false)
    private Long idCita;

    @Column(name = "diagnostico", length = 300, nullable = false)
    private String diagnostico;

    @Column(name = "receta", length = 300)
    private String receta;

    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_cita", referencedColumnName = "id", insertable = false, updatable = false)
    private Cita cita;

    // Constructor, getters, setters y otros métodos según sea necesario
}

