package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.Persona;

import com.citas.citasmedicas.services.PersonaService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/create")
    public Persona addPerson(@RequestBody Persona persona){
        return this.personaService.addPerson(persona);
    }

    @GetMapping("/getOne/{id}")
    public Persona getPersonByID(@PathVariable("id") Long id){
        return personaService.getPersonById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonByID(@PathVariable("id") Long id){
        personaService.deletePerson(id);
    }
}


