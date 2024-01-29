package com.books.booktracker.controllers;

import com.books.booktracker.models.CentroMedico;
import com.books.booktracker.models.Cita;
import com.books.booktracker.models.Diagnostico;
import com.books.booktracker.models.Especializacion;
import com.books.booktracker.models.Medico;
import com.books.booktracker.models.MedicoEspecializacion;
import com.books.booktracker.models.Paciente;
import com.books.booktracker.models.Persona;
import com.books.booktracker.services.CitasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CitasMedicasController {

    private final CitasService citasMedicasService;

    public CitasMedicasController(CitasService citasMedicasService) {
        this.citasMedicasService = citasMedicasService;
    }

    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return citasMedicasService.getAllPersonas();
    }

    @GetMapping("/especializaciones")
    public List<Especializacion> getAllEspecializaciones() {
        return citasMedicasService.getAllEspecializaciones();
    }

    @GetMapping("/pacientes")
    public List<Paciente> getAllPacientes() {
        return citasMedicasService.getAllPacientes();
    }

    @GetMapping("/centrosMedicos")
    public List<CentroMedico> getAllCentrosMedicos() {
        return citasMedicasService.getAllCentrosMedicos();
    }

    @GetMapping("/medicos")
    public List<Medico> getAllMedicos() {
        return citasMedicasService.getAllMedicos();
    }

    @GetMapping("/medicosEspecializaciones")
    public List<MedicoEspecializacion> getAllMedicosEspecializaciones() {
        return citasMedicasService.getAllMedicosEspecializaciones();
    }

    @GetMapping("/citas")
    public List<Cita> getAllCitas() {
        return citasMedicasService.getAllCitas();
    }

    @GetMapping("/diagnosticos")
    public List<Diagnostico> getAllDiagnosticos() {
        return citasMedicasService.getAllDiagnosticos();
    }

    // Puedes agregar más métodos según sea necesario para realizar operaciones específicas en cada entidad.
}

