package com.citas.citasmedicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;
import com.citas.citasmedicas.repositories.MedicoRepository;

@Service
public class CentroMedicoService {

    private final CentroMedicoRepository centroRepository;
    private final MedicoRepository medicoRepository;

    public CentroMedicoService(CentroMedicoRepository centroRepository, MedicoRepository medicoRepository){
        this.centroRepository = centroRepository;
        this.medicoRepository = medicoRepository;
    }

    public CentroMedico addCentroMedico(CentroMedico centro){
        return centroRepository.save(centro);
    }

    public void deleteCentroMedico(Long id){
        CentroMedico centro = centroRepository.findById(id).orElse(null);
        Iterable<Medico> medicos = medicoRepository.findAll();

        for (Medico medico : medicos) {
            
            if (medico.getIdCentroMedico()==centro.getId()) {
                medico.setCentroMedico(centroRepository.findById((long) 1).get());
            }

        }

        centroRepository.deleteById(id);
    }

    public List<CentroMedico> getCentrosMedicos(){
        return (List<CentroMedico>) centroRepository.findAll();
    }

}
