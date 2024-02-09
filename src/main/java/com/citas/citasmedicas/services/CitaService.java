package com.citas.citasmedicas.services;

import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.models.Paciente;
import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;
import com.citas.citasmedicas.repositories.CitaRepository;
import com.citas.citasmedicas.repositories.PacienteRepository;
import com.citas.citasmedicas.repositories.PersonaRepository;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final CentroMedicoRepository centroRepository;
    private final PacienteRepository pacienteRepository;
    private final PersonaRepository personaRepository;

    public CitaService(PersonaRepository personaRepository, CitaRepository citaRepository, CentroMedicoRepository centroRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.centroRepository = centroRepository;
        this.pacienteRepository = pacienteRepository;
        this.personaRepository = personaRepository;
    }

    @SuppressWarnings("null")
<<<<<<< Updated upstream
    public Cita addCita(Cita cita) throws ResendException {

        Long idCentro = cita.getIdCentroMedico();
        Long idPaciente = cita.getIdPaciente();
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
        Optional<CentroMedico> centro = centroRepository.findById(idCentro);

        Long idPersona = paciente.get().getIdPersona();
        Optional<Persona> persona = personaRepository.findById(idPersona);

        Resend resend = new Resend("re_iYjAAXgq_4DiQkcKYxL4oSe8m8XCTKVNL");

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from("onboarding@resend.dev")
                .to(persona.get().getEmail())
                .subject("Cita médica")
                .html("<p>Ha reservado una cita el día " + cita.getFecha() + ", a la hora " + cita.getHora() + ", en " + centro.get().getNombre() + "</p>")
                .build();

        SendEmailResponse data = resend.emails().send(sendEmailRequest);

=======
    public Cita addCita(Cita cita) {
        //
>>>>>>> Stashed changes
        return citaRepository.save(cita);
    }

    @SuppressWarnings("null")
    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    public List<Cita> getAllCitas() {
        return (List<Cita>) citaRepository.findAll();
    }

    @SuppressWarnings("null")
    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    public Cita updateCita(Long id, Cita updatedCita) {
        @SuppressWarnings("null")
        Optional<Cita> existingCita = citaRepository.findById(id);

        if (existingCita.isPresent()) {
            Cita cita = existingCita.get();
            // Actualizar los campos relevantes de la cita existente
            cita.setFecha(updatedCita.getFecha());
            cita.setHora(updatedCita.getHora());
            // ... Actualizar otros campos según sea necesario

            // Guardar la cita actualizada
            return citaRepository.save(cita);
        } else {
            // Manejar el caso cuando la cita no existe
            return null;
        }
    }

    public Boolean existeCita(Cita buscada){
        Boolean encontrado = false;
        for (Cita cita: citaRepository.findAll()) {
            if (cita.getFecha().equals(buscada.getFecha()) &&
                    cita.getHora().equals(buscada.getHora())) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @SuppressWarnings("null")
    public void deleteCitasByPacienteId(Long pacienteId) {
        citaRepository.findAll().forEach(cita -> {
            if(cita.getIdPaciente()==pacienteId) citaRepository.deleteById(cita.getId());
        });
    }

}

