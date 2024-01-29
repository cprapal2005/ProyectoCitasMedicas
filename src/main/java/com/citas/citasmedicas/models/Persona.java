package com.citas.citasmedicas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido1", length = 50, nullable = false)
    private String apellido1;

    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Column(name = "dni", length = 9, unique = true, nullable = false)
    private String dni;

    @Column(name = "telf", length = 9, nullable = false)
    private String telf;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "usuario", length = 50, unique = true, nullable = false)
    private String usuario;

    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;

    // Constructor, getters, setters y otros métodos según sea necesario
}
