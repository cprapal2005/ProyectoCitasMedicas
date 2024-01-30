package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.services.CitaService;
import com.citas.citasmedicas.services.DiagnosticoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;
    private final DiagnosticoService diagnosticoService;

    public CitaController(CitaService citaService, DiagnosticoService diagnosticoService) {
        this.citaService = citaService;
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping("/create")
    public Cita addCita(@RequestBody Cita cita) {
        return citaService.addCita(cita);
    }

    @GetMapping("/{id}")
    public Optional<Cita> getCitaById(@PathVariable Long id) {
        return citaService.getCitaById(id);
    }

    @GetMapping("/all")
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
    }

    @PutMapping("/update/{id}")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita updatedCita) {
        return citaService.updateCita(id, updatedCita);
    }
}

