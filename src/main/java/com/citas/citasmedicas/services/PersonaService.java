package com.citas.citasmedicas.services;
import org.springframework.stereotype.Service;
import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @SuppressWarnings("null")
    public Persona addPerson(Persona persona){
        return personaRepository.save(persona);
    }

    @SuppressWarnings("null")
    public void deletePerson(Long id){
        personaRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public Optional<Persona> getPersonById(Long id){ return personaRepository.findById(id);}

    public List<Persona> getAllPersonas(){
        return (List<Persona>)personaRepository.findAll();
    }

     public Persona update(Long id, Persona persona){

        Optional<Persona> entidad = getPersonById(id);

        if (entidad.isPresent()){
            Persona persona1 = entidad.get();
            persona1.setNombre(persona.getNombre());
            persona1.setApellido1(persona.getApellido1());
            persona1.setApellido2(persona.getApellido2());
            persona1.setDni(persona.getDni());
            persona1.setTelf(persona.getTelf());
            persona1.setEmail(persona.getEmail());
            persona1.setUsuario(persona.getUsuario());
            persona1.setContraseña(persona.getContraseña());
            

            return personaRepository.save(persona1);
        }
        else{
            return null;
        }

    }



}
