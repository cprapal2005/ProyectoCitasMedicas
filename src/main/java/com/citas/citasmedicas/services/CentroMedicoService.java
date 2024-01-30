package com.citas.citasmedicas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;

@Service
public class CentroMedicoService {
    private final CentroMedicoRepository centroRepository;

    public CentroMedicoService(CentroMedicoRepository centroRepository){
        this.centroRepository = centroRepository;
    }

    public CentroMedico addCentroMedico(CentroMedico centro){
        return centroRepository.save(centro);
    }

    public void deleteCentroMedico(Long id){
        centroRepository.deleteById(id);
    }

    public List<CentroMedico> getCentrosMedicos(){
        return (List<CentroMedico>) centroRepository.findAll();
    }

}
