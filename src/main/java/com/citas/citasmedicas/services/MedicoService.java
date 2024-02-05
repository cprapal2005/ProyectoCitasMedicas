package com.citas.citasmedicas.services;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    @SuppressWarnings("null")
    public Medico addMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    @SuppressWarnings("null")
    public void deleteMedico(Long id){
        medicoRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public Optional<Medico> getMedicoById(Long id){
        return medicoRepository.findById(id);
    }

    public List<Medico> getAllMedicos(){
        return (List<Medico>) medicoRepository.findAll();
    }

    public Medico update(Long id, Medico medico){

        Optional<Medico> entidad = getMedicoById(id);

        if (entidad.isPresent()){
            Medico medico1 = entidad.get();
            medico1.setPersona(medico.getPersona());
            medico1.setCentroMedico(medico.getCentroMedico());

            return medicoRepository.save(medico1);
        }
        else{
            return null;
        }

    }


}
