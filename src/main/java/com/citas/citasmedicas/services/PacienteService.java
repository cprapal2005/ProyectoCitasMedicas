package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.Paciente;
import com.citas.citasmedicas.repositories.PacienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @SuppressWarnings("null")
    public Paciente addPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @SuppressWarnings("null")
    public Optional<Paciente> getPacienteById(Long id){
        return pacienteRepository.findById(id);
    }

    public List<Paciente> getAllPacientes(){
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @SuppressWarnings("null")
    public void deletePaciente(Long id) {

        pacienteRepository.deleteById(id);
    }

    public Paciente updatePaciente(Long id, Paciente updatedPaciente){
        // Verificar si el paciente con el id proporcionado existe
        @SuppressWarnings("null")
        Optional<Paciente> existingPaciente = pacienteRepository.findById(id);

        if (existingPaciente.isPresent()) {
            // Actualizar los campos relevantes del paciente existente
            Paciente paciente = existingPaciente.get();
            paciente.setFechaNacimiento(updatedPaciente.getFechaNacimiento());
            paciente.setTarjetaSanitaria(updatedPaciente.getTarjetaSanitaria());

            // Guardar el paciente actualizado
            return pacienteRepository.save(paciente);
        } else {
            // El paciente no existe, puedes manejar esto de acuerdo a tus necesidades
            return null;
        }
    }

    // Puedes agregar más métodos según sea necesario, por ejemplo, búsqueda por tarjeta sanitaria, filtrar por fecha de nacimiento, etc.
}
