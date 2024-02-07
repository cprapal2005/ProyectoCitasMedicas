package com.citas.citasmedicas.services;
import com.citas.citasmedicas.models.Especializacion;
import com.citas.citasmedicas.repositories.EspecializacionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecializacionService {

    private final EspecializacionRepository espRepository;

    public EspecializacionService(EspecializacionRepository espRepository){
        this.espRepository = espRepository;
    }

    @SuppressWarnings("null")
    public Especializacion addEspecializacion(Especializacion especializacion){
        return espRepository.save(especializacion);
    }

    public List<Especializacion> getAllEspecializaciones(){
        return (List<Especializacion>) espRepository.findAll();
    }

    @SuppressWarnings("null")
    public Especializacion getEspecializacionById(Long id){
        return espRepository.findById(id).get();
    }

}
