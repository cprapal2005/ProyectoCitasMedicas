package com.citas.citasmedicas.services;

import org.springframework.stereotype.Service;

import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.PersonaRepository;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public Persona addPerson(Persona persona){
        return personaRepository.save(persona);
    }

    public void deletePerson(Long id){
        personaRepository.deleteById(id);
    }

    public Persona getPersonById(Long id){ return personaRepository.findById(id).get();}

    public List<Persona> getAllPersonas(){
        return (List<Persona>)personaRepository.findAll();
    }

}
