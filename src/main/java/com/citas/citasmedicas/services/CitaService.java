package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.repositories.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita addCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    public List<Cita> getAllCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    public Cita updateCita(Long id, Cita updatedCita) {
        Optional<Cita> existingCita = citaRepository.findById(id);

        if (existingCita.isPresent()) {
            Cita cita = existingCita.get();
            // Actualizar los campos relevantes de la cita existente
            cita.setFecha(updatedCita.getFecha());
            cita.setHora(updatedCita.getHora());
            // ... Actualizar otros campos según sea necesario

            // Guardar la cita actualizada
            return citaRepository.save(cita);
        } else {
            // Manejar el caso cuando la cita no existe
            return null;
        }
    }

    public void deleteCitasByPacienteId(Long pacienteId) {
        citaRepository.findAll().forEach(cita -> {
            if(cita.getIdPaciente()==pacienteId) citaRepository.deleteById(cita.getId());
        });
    }

}

