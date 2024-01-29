package com.books.booktracker.services;

import com.books.booktracker.models.CentroMedico;
import com.books.booktracker.models.Cita;
import com.books.booktracker.models.Diagnostico;
import com.books.booktracker.models.Especializacion;
import com.books.booktracker.models.Medico;
import com.books.booktracker.models.MedicoEspecializacion;
import com.books.booktracker.models.Paciente;
import com.books.booktracker.models.Persona;
import com.books.booktracker.repositories.CentroMedicoRepository;
import com.books.booktracker.repositories.CitaRepository;
import com.books.booktracker.repositories.DiagnosticoRepository;
import com.books.booktracker.repositories.EspecializacionRepository;
import com.books.booktracker.repositories.MedicoEspecializacionRepository;
import com.books.booktracker.repositories.MedicoRepository;
import com.books.booktracker.repositories.PacienteRepository;
import com.books.booktracker.repositories.PersonaRepository;

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

