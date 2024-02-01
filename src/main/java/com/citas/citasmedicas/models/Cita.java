package com.citas.citasmedicas.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CITA")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_medico", nullable = false)
    private Long idMedico;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_centro_medico", nullable = false)
    private Long idCentroMedico;

    @Column(name = "planta", length = 2, nullable = false)
    private String planta;

    @Column(name = "sala", length = 2, nullable = false)
    private String sala;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hora;

    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_centro_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private CentroMedico centroMedico;

    // Constructor, getters, setters y otros métodos según sea necesario
}

