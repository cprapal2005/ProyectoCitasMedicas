package com.citas.citasmedicas.controllers;


import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.services.MedicoService;
import com.citas.citasmedicas.services.PersonaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    private final PersonaService personaService;

    public MedicoController(MedicoService medicoService,PersonaService personaService) {
        this.medicoService = medicoService;
        this.personaService = personaService;
    }

    @PostMapping("/create")
    public Medico addMedico(@RequestBody Medico medico){
        return this.medicoService.addMedico(medico);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicoById(@PathVariable("id") Long id){
        Medico medico = medicoService.getMedicoById(id);
        this.medicoService.deleteMedico(medico.getId());
    }

}
