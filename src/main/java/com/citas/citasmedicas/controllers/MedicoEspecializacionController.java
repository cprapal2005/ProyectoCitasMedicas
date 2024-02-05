package com.citas.citasmedicas.controllers;

import com.citas.citasmedicas.models.MedicoEspecializacion;
import com.citas.citasmedicas.repositories.MedicoEspecializacionRepository;
import com.citas.citasmedicas.services.MedicoEspecializacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicoEspecializacion")
public class MedicoEspecializacionController {

    private MedicoEspecializacionService medicoEspecializacionService;

    @GetMapping("/getAll")
    public List<MedicoEspecializacion> getAll(){
        return medicoEspecializacionService.getAllMedicoEspecializaciones();
    }

    @GetMapping("/getOne/{id}")
    public MedicoEspecializacion getOne(@PathVariable("id") Long id){
        return medicoEspecializacionService.getMedicoEspecializacion(id).get();
    }

    @PutMapping("/update/{id}")
    public MedicoEspecializacion update(@PathVariable("id") Long id, @RequestBody MedicoEspecializacion medicoEspecializacion){
        return medicoEspecializacionService.update(id,medicoEspecializacion);
    }

}
