package com.citas.citasmedicas.controllers;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.services.EspecializacionService;
import com.citas.citasmedicas.services.MedicoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;
    private final EspecializacionService especializacionService;

    public MedicoController(MedicoService medicoService, EspecializacionService especializacionService) {
        this.medicoService = medicoService;
        this.especializacionService = especializacionService;
    }

    @PostMapping("/create")
    public Medico addMedico(@RequestBody Medico medico){
        return this.medicoService.addMedico(medico);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicoById(@PathVariable("id") Long id){
        Medico medico = medicoService.getMedicoById(id).get();
        this.medicoService.deleteMedico(medico.getId());
    }

    @GetMapping("/getAllMedicos")
    public List<Medico> getAllMedicos(){
        return medicoService.getAllMedicos();
    }

    @GetMapping("/getMedico/{id}")
    public Medico getMedico(@PathVariable("id") Long id){
        return medicoService.getMedicoById(id).get();
    }

    @PutMapping("update/{id}")
    public Medico updatePersona(@PathVariable("id") Long id, @RequestBody Medico medico){
        return medicoService.update(id, medico);
    }

    @GetMapping("/getMedicosEspecializacion/{id}")
    public List<Medico> getMedicosEspecializacion(@PathVariable("id") Long id){
        if (especializacionService.getEspecializacionById(id) != null) return medicoService.getMedicosEspecializacion(especializacionService.getEspecializacionById(id));
        else return new ArrayList<>();
    }

}
