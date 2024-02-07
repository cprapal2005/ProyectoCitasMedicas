package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.Persona;

import com.citas.citasmedicas.services.PersonaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @DeleteMapping("/delete")
    public void deleteCentroMedico(@RequestBody Long id){
        this.personaService.deletePerson(id);
    }

    @GetMapping("/getAll")
    public List<Persona> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @GetMapping("/getPersonaId/{id}")
    public Persona getPersonaId(@PathVariable("id") Long id){
        return personaService.getPersonById(id).get();
    }

    @PutMapping("update/{id}")
    public Persona updatePersona(@PathVariable("id") Long id, @RequestBody Persona persona){
        return personaService.update(id, persona);
    }
}


