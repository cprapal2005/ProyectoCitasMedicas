package com.citas.citasmedicas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.services.CentroMedicoService;

@RestController
@RequestMapping("/centro_medico")
public class CentroMedicoController {

    private final CentroMedicoService centroService;

    public CentroMedicoController(CentroMedicoService centroService) {
        this.centroService = centroService;
    }

    @PostMapping("/create")
    public CentroMedico addCentroMedico(@RequestBody CentroMedico centro){
        return this.centroService.addCentroMedico(centro);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCentro(@PathVariable("id") Long id){
        this.centroService.deleteCentroMedico(id);
    }

    @PutMapping("/update/{id}")
    public CentroMedico updateCentro(@PathVariable("id") Long id, @RequestBody CentroMedico centro) {
        return this.centroService.updateCentroMedico(id, centro);
    }

    @GetMapping("/get/{id}")
    public Optional<CentroMedico> getAllCentroMedico(@PathVariable("id") Long id) {
        return this.centroService.getCentroMedico(id);
    }

    @GetMapping("/all")
    public List<CentroMedico> getAllCentrosMedicos() {
        return centroService.getCentrosMedicos();
    }

}
