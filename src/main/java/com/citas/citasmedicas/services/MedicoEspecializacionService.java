package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.MedicoEspecializacion;
import com.citas.citasmedicas.repositories.MedicoEspecializacionRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoEspecializacionService {

    private MedicoEspecializacionRepository respository;

    public Optional<MedicoEspecializacion> getMedicoEspecializacion(Long id){
        return respository.findById(id);
    }

    public List<MedicoEspecializacion> getAllMedicoEspecializaciones(){
        return (List<MedicoEspecializacion>) respository.findAll();
    }

    public void deleteMedicoEspecializacion(Long id){
        respository.deleteById(id);
    }

    public MedicoEspecializacion update(Long id, MedicoEspecializacion medicoEspecializacion){

        Optional<MedicoEspecializacion> entidad = getMedicoEspecializacion(id);

        if (entidad.isPresent()){
            MedicoEspecializacion medicoEspecializacion1 = entidad.get();
            medicoEspecializacion1.setEspecializacion(medicoEspecializacion.getEspecializacion());
            medicoEspecializacion1.setMedico(medicoEspecializacion.getMedico());

            return respository.save(medicoEspecializacion1);
        }
        else{
            return null;
        }

    }

    public MedicoEspecializacion create(MedicoEspecializacion medicoEspecializacion){
        return respository.save(medicoEspecializacion);
    }

}
