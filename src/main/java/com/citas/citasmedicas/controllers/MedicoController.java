package com.citas.citasmedicas.controllers;


import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.services.MedicoService;
import com.citas.citasmedicas.services.PersonaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/create")
    public Persona addPerson(@RequestBody Persona persona){
        return this.personaService.addPerson(persona);
    }

}
