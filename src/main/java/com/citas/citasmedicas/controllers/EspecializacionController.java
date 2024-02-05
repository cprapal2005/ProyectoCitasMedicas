package com.citas.citasmedicas.controllers;
import com.citas.citasmedicas.models.Especializacion;
import com.citas.citasmedicas.services.EspecializacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especializacion")
public class EspecializacionController {

    private final EspecializacionService especializacionService;

    public EspecializacionController(EspecializacionService especializacionService) {
        this.especializacionService = especializacionService;
    }

    @PostMapping("/create")
    public Especializacion addEspecializacion(@RequestBody Especializacion especializacion){
        return this.especializacionService.addEspecializacion(especializacion);
    }

    @GetMapping("/getAllEspecializaciones")
    public List<Especializacion> getAllEspecializaciones(){
        return especializacionService.getAllEspecializaciones();
    }

    @GetMapping("/getEspecializacion/{id}")
    public Especializacion getEspecializacionById(@PathVariable("id") Long id){
        return especializacionService.getEspecializacionById(id);
    }



}

