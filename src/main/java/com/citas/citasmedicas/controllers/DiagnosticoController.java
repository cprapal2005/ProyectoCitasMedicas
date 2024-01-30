package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.Diagnostico;
import com.citas.citasmedicas.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    @Autowired
    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @GetMapping("all")
    public List<Diagnostico> getAllDiagnosticos() {
        return diagnosticoService.getAllDiagnosticos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostico> getDiagnosticoById(@PathVariable Long id) {
        Optional<Diagnostico> diagnostico = diagnosticoService.getDiagnosticoById(id);
        return diagnostico.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Diagnostico> saveDiagnostico(@RequestBody Diagnostico diagnostico) {
        Diagnostico savedDiagnostico = diagnosticoService.saveDiagnostico(diagnostico);
        return new ResponseEntity<>(savedDiagnostico, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnostico(@PathVariable Long id) {
        diagnosticoService.deleteDiagnostico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

