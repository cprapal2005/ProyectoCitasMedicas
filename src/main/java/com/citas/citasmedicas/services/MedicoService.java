package com.citas.citasmedicas.services;
import com.citas.citasmedicas.models.Especializacion;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.models.MedicoEspecializacion;
import com.citas.citasmedicas.repositories.MedicoEspecializacionRepository;
import com.citas.citasmedicas.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    private final MedicoEspecializacionRepository medicoEspecializacionRepository;

    public MedicoService(MedicoRepository medicoRepository, MedicoEspecializacionRepository medicoEspecializacionRepository){
        this.medicoRepository = medicoRepository;
        this.medicoEspecializacionRepository = medicoEspecializacionRepository;
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

    public List<Medico> getMedicosEspecializacion(Especializacion especializacion) {
       List<MedicoEspecializacion> listaMedicosEspecializacion = (List<MedicoEspecializacion>) medicoEspecializacionRepository.findAll();
       List<Medico> listaMedicosEspecializados = new ArrayList<Medico>();
       for (MedicoEspecializacion medicoEspecializacion : listaMedicosEspecializacion){
            if (medicoEspecializacion.getIdEspecializacion() == especializacion.getId()){
                Optional<Medico> medico = medicoRepository.findById(medicoEspecializacion.getIdMedico());
                listaMedicosEspecializados.add(medico.get());
            }
       }

       return listaMedicosEspecializados;

    }


}
