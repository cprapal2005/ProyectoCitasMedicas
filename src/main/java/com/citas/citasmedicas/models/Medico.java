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
    @JoinColumn(name = "id_persona", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_centro_medico", referencedColumnName = "id", insertable = false, updatable = false)
    private CentroMedico centroMedico;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "id_centro_medico", nullable = false)
    private Long idCentroMedico;

    // Constructor, getters, setters y otros métodos según sea necesario


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public CentroMedico getCentroMedico() {
        return centroMedico;
    }

    public void setCentroMedico(CentroMedico centroMedico) {
        this.centroMedico = centroMedico;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdCentroMedico() {
        return idCentroMedico;
    }

    public void setIdCentroMedico(Long idCentroMedico) {
        this.idCentroMedico = idCentroMedico;
    }
}

