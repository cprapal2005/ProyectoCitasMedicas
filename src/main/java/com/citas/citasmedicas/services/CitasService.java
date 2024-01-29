package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.models.Diagnostico;
import com.citas.citasmedicas.models.Especializacion;
import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.models.MedicoEspecializacion;
import com.citas.citasmedicas.models.Paciente;
import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;
import com.citas.citasmedicas.repositories.CitaRepository;
import com.citas.citasmedicas.repositories.DiagnosticoRepository;
import com.citas.citasmedicas.repositories.EspecializacionRepository;
import com.citas.citasmedicas.repositories.MedicoEspecializacionRepository;
import com.citas.citasmedicas.repositories.MedicoRepository;
import com.citas.citasmedicas.repositories.PacienteRepository;
import com.citas.citasmedicas.repositories.PersonaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService {

    private final PersonaRepository personaRepository;
    private final EspecializacionRepository especializacionRepository;
    private final PacienteRepository pacienteRepository;
    private final CentroMedicoRepository centroMedicoRepository;
    private final MedicoRepository medicoRepository;
    private final MedicoEspecializacionRepository medicoEspecializacionRepository;
    private final CitaRepository citaRepository;
    private final DiagnosticoRepository diagnosticoRepository;

    public CitasService(PersonaRepository personaRepository,
                               EspecializacionRepository especializacionRepository,
                               PacienteRepository pacienteRepository,
                               CentroMedicoRepository centroMedicoRepository,
                               MedicoRepository medicoRepository,
                               MedicoEspecializacionRepository medicoEspecializacionRepository,
                               CitaRepository citaRepository,
                               DiagnosticoRepository diagnosticoRepository) {
        this.personaRepository = personaRepository;
        this.especializacionRepository = especializacionRepository;
        this.pacienteRepository = pacienteRepository;
        this.centroMedicoRepository = centroMedicoRepository;
        this.medicoRepository = medicoRepository;
        this.medicoEspecializacionRepository = medicoEspecializacionRepository;
        this.citaRepository = citaRepository;
        this.diagnosticoRepository = diagnosticoRepository;
    }

    public List<Persona> getAllPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    public List<Especializacion> getAllEspecializaciones() {
        return (List<Especializacion>) especializacionRepository.findAll();
    }

    public List<Paciente> getAllPacientes() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    public List<CentroMedico> getAllCentrosMedicos() {
        return (List<CentroMedico>) centroMedicoRepository.findAll();
    }

    public List<Medico> getAllMedicos() {
        return (List<Medico>) medicoRepository.findAll();
    }

    public List<MedicoEspecializacion> getAllMedicosEspecializaciones() {
        return (List<MedicoEspecializacion>) medicoEspecializacionRepository.findAll();
    }

    public List<Cita> getAllCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    public List<Diagnostico> getAllDiagnosticos() {
        return (List<Diagnostico>) diagnosticoRepository.findAll();
    }

    // Puedes agregar más métodos según sea necesario para realizar operaciones específicas en cada entidad.
}

