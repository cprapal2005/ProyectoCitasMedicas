package com.citas.citasmedicas;
import com.citas.citasmedicas.models.Diagnostico;
import com.citas.citasmedicas.repositories.DiagnosticoRepository;
import com.citas.citasmedicas.services.DiagnosticoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DiagnosticoServiceTest {

    @Mock
    private DiagnosticoRepository diagnosticoRepository;

    @InjectMocks
    private DiagnosticoService diagnosticoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDiagnosticos() {
        List<Diagnostico> diagnosticos = new ArrayList<>();
        Diagnostico diag1 = new Diagnostico();
        diag1.setId(1L);
        diag1.setDiagnostico("Diagnóstico A");
        diag1.setIdPaciente(1L);
        diagnosticos.add(diag1);

        Diagnostico diag2 = new Diagnostico();
        diag2.setId(2L);
        diag2.setDiagnostico("Diagnóstico B");
        diag2.setIdPaciente(1L);
        diagnosticos.add(diag2);

        when(diagnosticoRepository.findAll()).thenReturn(diagnosticos);

        List<Diagnostico> result = diagnosticoService.getAllDiagnosticos();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(diagnosticos, result);

        verify(diagnosticoRepository, times(1)).findAll();
    }

    @Test
    void testGetDiagnosticoById() {
        Long diagnosticoId = 1L;
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(diagnosticoId);
        diagnostico.setDiagnostico("Diagnóstico A");
        diagnostico.setIdPaciente(1L);

        when(diagnosticoRepository.findById(diagnosticoId)).thenReturn(Optional.of(diagnostico));

        Optional<Diagnostico> result = diagnosticoService.getDiagnosticoById(diagnosticoId);

        assertTrue(result.isPresent());
        assertEquals(diagnostico, result.get());

        verify(diagnosticoRepository, times(1)).findById(diagnosticoId);
    }

    @Test
    void testSaveDiagnostico() {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(1L);
        diagnostico.setDiagnostico("Diagnóstico A");
        diagnostico.setIdPaciente(1L);

        when(diagnosticoRepository.save(diagnostico)).thenReturn(diagnostico);

        Diagnostico result = diagnosticoService.saveDiagnostico(diagnostico);

        assertNotNull(result);
        assertEquals(diagnostico, result);

        verify(diagnosticoRepository, times(1)).save(diagnostico);
    }

    @Test
    void testDeleteDiagnostico() {
        Long diagnosticoId = 1L;

        doNothing().when(diagnosticoRepository).deleteById(diagnosticoId);

        assertDoesNotThrow(() -> diagnosticoService.deleteDiagnostico(diagnosticoId));

        verify(diagnosticoRepository, times(1)).deleteById(diagnosticoId);
    }

    @Test
    void testDeleteDiagnosticoByPersonaId() {
        Long pacienteId = 1L;
        Diagnostico diag1 = new Diagnostico();
        diag1.setId(1L);
        diag1.setDiagnostico("Diagnóstico A");
        diag1.setIdPaciente(pacienteId);

        Diagnostico diag2 = new Diagnostico();
        diag2.setId(2L);
        diag2.setDiagnostico("Diagnóstico B");
        diag2.setIdPaciente(pacienteId);

        List<Diagnostico> diagnosticos = List.of(diag1, diag2);

        when(diagnosticoRepository.findAll()).thenReturn(diagnosticos);
        doNothing().when(diagnosticoRepository).deleteById(anyLong());

        assertDoesNotThrow(() -> diagnosticoService.deleteDiagnosticoByPersonaId(pacienteId));

        verify(diagnosticoRepository, times(1)).deleteById(diag1.getId());
        verify(diagnosticoRepository, times(1)).deleteById(diag2.getId());
    }
}

