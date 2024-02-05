package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.Paciente;
import com.citas.citasmedicas.services.CitaService;
import com.citas.citasmedicas.services.DiagnosticoService;
import com.citas.citasmedicas.services.PacienteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;
    private final CitaService citaService;
    private final DiagnosticoService diagnosticoService;

    public PacienteController(PacienteService pacienteService, CitaService citaService, DiagnosticoService diagnosticoService) {
        this.pacienteService = pacienteService;
        this.citaService = citaService;
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping("/create")
    public Paciente addPaciente(@RequestBody Paciente paciente) {
        return this.pacienteService.addPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id) {
        return this.pacienteService.getPacienteById(id);
    }

    @GetMapping("/all")
    public List<Paciente> getAllPacientes() {
        return this.pacienteService.getAllPacientes();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePaciente(@PathVariable("id") Long id) {
        this.diagnosticoService.deleteDiagnosticoByPersonaId(id);
        this.citaService.deleteCitasByPacienteId(id);
        this.pacienteService.deletePaciente(id);
    }

    @PutMapping("/update/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente updatedPaciente) {
        return this.pacienteService.updatePaciente(id, updatedPaciente);
    }

    // Puedes agregar más métodos según sea necesario
}
