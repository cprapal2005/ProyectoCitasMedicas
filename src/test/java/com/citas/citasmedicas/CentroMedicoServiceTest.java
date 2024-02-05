package com.citas.citasmedicas;
import com.citas.citasmedicas.models.CentroMedico;
import com.citas.citasmedicas.repositories.CentroMedicoRepository;
import com.citas.citasmedicas.services.CentroMedicoService;

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

class CentroMedicoServiceTest {

    @Mock
    private CentroMedicoRepository centroRepository;

    @InjectMocks
    private CentroMedicoService centroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCentroMedico() {
        CentroMedico centroMedico = new CentroMedico();
        centroMedico.setNombre("Centro Médico A");
        centroMedico.setCiudad("Ciudad A");

        when(centroRepository.save(centroMedico)).thenReturn(centroMedico);

        CentroMedico result = centroService.addCentroMedico(centroMedico);

        assertNotNull(result);
        assertEquals(centroMedico.getNombre(), result.getNombre());
        assertEquals(centroMedico.getCiudad(), result.getCiudad());

        verify(centroRepository, times(1)).save(centroMedico);
    }

    @Test
    void testDeleteCentroMedico() {
        Long centroId = 1L;

        doNothing().when(centroRepository).deleteById(centroId);

        assertDoesNotThrow(() -> centroService.deleteCentroMedico(centroId));

        verify(centroRepository, times(1)).deleteById(centroId);
    }

    @Test
    void testUpdateCentroMedico() {
        Long centroId = 1L;
        CentroMedico existingCentro = new CentroMedico();
        existingCentro.setNombre("Centro Médico A");
        existingCentro.setCiudad("Ciudad A");
        CentroMedico updatedCentro = new CentroMedico();
        updatedCentro.setNombre("Nuevo Centro Médico");
        updatedCentro.setCiudad("Nueva Ciudad");

        when(centroRepository.findById(centroId)).thenReturn(Optional.of(existingCentro));
        when(centroRepository.save(existingCentro)).thenReturn(existingCentro);

        CentroMedico result = centroService.updateCentroMedico(centroId, updatedCentro);

        assertNotNull(result);
        assertEquals(updatedCentro.getNombre(), result.getNombre());
        assertEquals(updatedCentro.getCiudad(), result.getCiudad());

        verify(centroRepository, times(1)).findById(centroId);
        verify(centroRepository, times(1)).save(existingCentro);
    }

    @Test
    void testUpdateCentroMedicoNotFound() {
        Long centroId = 1L;
        CentroMedico updatedCentro = new CentroMedico();
        updatedCentro.setNombre("Nuevo Centro Médico");
        updatedCentro.setCiudad("Nueva Ciudad");

        when(centroRepository.findById(centroId)).thenReturn(Optional.empty());

        CentroMedico result = centroService.updateCentroMedico(centroId, updatedCentro);

        assertNull(result);

        verify(centroRepository, times(1)).findById(centroId);
        verify(centroRepository, never()).save(any());
    }

    @Test
    void testGetCentrosMedicos() {
        List<CentroMedico> centros = new ArrayList<>();
        CentroMedico centro1 = new CentroMedico();
        centro1.setNombre("Centro Médico A");
        centro1.setCiudad("Ciudad A");
        centros.add(centro1);

        CentroMedico centro2 = new CentroMedico();
        centro2.setNombre("Centro Médico B");
        centro2.setCiudad("Ciudad B");
        centros.add(centro2);

        when(centroRepository.findAll()).thenReturn(centros);

        List<CentroMedico> result = centroService.getCentrosMedicos();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(centros, result);

        verify(centroRepository, times(1)).findAll();
    }
}

