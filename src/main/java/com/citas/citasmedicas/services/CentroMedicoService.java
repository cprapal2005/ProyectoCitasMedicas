package com.citas.citasmedicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;

@Service
public class CentroMedicoService {

    private final CentroMedicoRepository centroRepository;

    public CentroMedicoService(CentroMedicoRepository centroRepository){
        this.centroRepository = centroRepository;
    }

    @SuppressWarnings("null")
    public CentroMedico addCentroMedico(CentroMedico centro){
        return centroRepository.save(centro);
    }

    @SuppressWarnings("null")
    public void deleteCentroMedico(Long id){

        try {
            centroRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ": No se puede borrar este centro médico.");
        }


    }

    public CentroMedico updateCentroMedico(Long id, CentroMedico centro){

        // Verificar si el paciente con el id proporcionado existe
        @SuppressWarnings("null")
        Optional<CentroMedico> existingCentro = centroRepository.findById(id);

        if (existingCentro.isPresent()) {
            // Actualizar los campos relevantes del paciente existente
            CentroMedico centroMedico = existingCentro.get();
            centroMedico.setNombre(centro.getNombre());
            centroMedico.setCiudad(centro.getCiudad());
            // Guardar el paciente actualizado
            return centroRepository.save(centroMedico);
        } else {
            // El paciente no existe, puedes manejar esto de acuerdo a tus necesidades
            return null;
        }
    }

    public List<CentroMedico> getCentrosMedicos(){
        return (List<CentroMedico>) centroRepository.findAll();
    }

}
