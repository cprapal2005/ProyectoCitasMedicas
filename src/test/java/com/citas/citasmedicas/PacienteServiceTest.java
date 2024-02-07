package com.citas.citasmedicas;

import com.citas.citasmedicas.models.Paciente;
import com.citas.citasmedicas.repositories.PacienteRepository;
import com.citas.citasmedicas.services.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPaciente() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setFechaNacimiento(new Date("12-12-2000"));
        paciente.setTarjetaSanitaria("TS12345");

        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente result = pacienteService.addPaciente(paciente);

        assertNotNull(result);
        assertEquals(paciente, result);

        verify(pacienteRepository, times(1)).save(paciente);
    }

    @Test
    void testGetPacienteById() {
        Long pacienteId = 1L;
        Paciente paciente = new Paciente();
        paciente.setId(pacienteId);
        paciente.setFechaNacimiento(new Date("12-12-2000"));
        paciente.setTarjetaSanitaria("TS12345");

        when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.of(paciente));

        Optional<Paciente> result = pacienteService.getPacienteById(pacienteId);

        assertTrue(result.isPresent());
        assertEquals(paciente, result.get());

        verify(pacienteRepository, times(1)).findById(pacienteId);
    }

    @Test
    void testGetAllPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente1 = new Paciente();
        paciente1.setId(1L);
        paciente1.setFechaNacimiento(new Date("12-12-2000"));
        paciente1.setTarjetaSanitaria("TS12345");
        pacientes.add(paciente1);

        Paciente paciente2 = new Paciente();
        paciente2.setId(2L);
        paciente2.setFechaNacimiento(new Date("12-12-2000"));
        paciente2.setTarjetaSanitaria("TS67890");
        pacientes.add(paciente2);

        when(pacienteRepository.findAll()).thenReturn(pacientes);

        List<Paciente> result = pacienteService.getAllPacientes();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(pacientes, result);

        verify(pacienteRepository, times(1)).findAll();
    }

    @Test
    void testDeletePaciente() {
        Long pacienteId = 1L;

        doNothing().when(pacienteRepository).deleteById(pacienteId);

        assertDoesNotThrow(() -> pacienteService.deletePaciente(pacienteId));

        verify(pacienteRepository, times(1)).deleteById(pacienteId);
    }

    @Test
    void testUpdatePaciente() {
        Long pacienteId = 1L;
        Paciente existingPaciente = new Paciente();
        existingPaciente.setId(pacienteId);
        existingPaciente.setFechaNacimiento(new Date("12-12-2000"));
        existingPaciente.setTarjetaSanitaria("TS12345");

        Paciente updatedPaciente = new Paciente();
        updatedPaciente.setFechaNacimiento(new Date("10-12-2000"));
        updatedPaciente.setTarjetaSanitaria("TS67890");

        when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.of(existingPaciente));
        when(pacienteRepository.save(existingPaciente)).thenReturn(existingPaciente);

        Paciente result = pacienteService.updatePaciente(pacienteId, updatedPaciente);

        assertNotNull(result);
        assertEquals(updatedPaciente.getFechaNacimiento(), result.getFechaNacimiento());
        assertEquals(updatedPaciente.getTarjetaSanitaria(), result.getTarjetaSanitaria());

        verify(pacienteRepository, times(1)).findById(pacienteId);
        verify(pacienteRepository, times(1)).save(existingPaciente);
    }

    @Test
    void testUpdatePacienteNotFound() {
        Long pacienteId = 1L;
        Paciente updatedPaciente = new Paciente();
        updatedPaciente.setFechaNacimiento(new Date("12-12-2000"));
        updatedPaciente.setTarjetaSanitaria("TS67890");

        when(pacienteRepository.findById(pacienteId)).thenReturn(Optional.empty());

        Paciente result = pacienteService.updatePaciente(pacienteId, updatedPaciente);

        assertNull(result);

        verify(pacienteRepository, times(1)).findById(pacienteId);
        verify(pacienteRepository, never()).save(any());
    }
}
