package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.repositories.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @SuppressWarnings("null")
    public Cita addCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @SuppressWarnings("null")
    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    public List<Cita> getAllCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    @SuppressWarnings("null")
    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    public Cita updateCita(Long id, Cita updatedCita) {
        @SuppressWarnings("null")
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

    public Boolean existeCita(Cita buscada){
        Boolean encontrado = false;
        for (Cita cita: citaRepository.findAll()) {
            if (cita.getFecha().equals(buscada.getFecha()) &&
                    cita.getHora().equals(buscada.getHora())) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @SuppressWarnings("null")
    public void deleteCitasByPacienteId(Long pacienteId) {
        citaRepository.findAll().forEach(cita -> {
            if(cita.getIdPaciente()==pacienteId) citaRepository.deleteById(cita.getId());
        });
    }

}

