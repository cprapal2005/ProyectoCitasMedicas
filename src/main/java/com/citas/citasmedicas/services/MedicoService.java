package com.citas.citasmedicas.services;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    public Medico addMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id){
        medicoRepository.deleteById(id);
    }


}
