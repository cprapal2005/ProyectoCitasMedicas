package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.Diagnostico;
import com.citas.citasmedicas.repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;

    @Autowired
    public DiagnosticoService(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

    public List<Diagnostico> getAllDiagnosticos() {
        return (List<Diagnostico>) diagnosticoRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Diagnostico> getDiagnosticoById(Long id) {
        return diagnosticoRepository.findById(id);
    }

    @SuppressWarnings("null")
    public Diagnostico saveDiagnostico(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    @SuppressWarnings("null")
    public void deleteDiagnostico(Long id) {
        diagnosticoRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public void deleteDiagnosticoByPersonaId(Long pacienteId) {
        diagnosticoRepository.findAll().forEach(diagnostico -> {
            if(diagnostico.getIdPaciente()==pacienteId) diagnosticoRepository.deleteById(diagnostico.getId());
        });
    }

}

