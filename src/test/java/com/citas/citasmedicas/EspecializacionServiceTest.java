package com.citas.citasmedicas;

import com.citas.citasmedicas.models.Especializacion;
import com.citas.citasmedicas.repositories.EspecializacionRepository;
import com.citas.citasmedicas.services.EspecializacionService;
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

class EspecializacionServiceTest {

    @Mock
    private EspecializacionRepository espRepository;

    @InjectMocks
    private EspecializacionService espService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEspecializacion() {
        Especializacion especializacion = new Especializacion();
        especializacion.setId(1L);
        especializacion.setNombre("Especialización A");

        when(espRepository.save(especializacion)).thenReturn(especializacion);

        Especializacion result = espService.addEspecializacion(especializacion);

        assertNotNull(result);
        assertEquals(especializacion, result);

        verify(espRepository, times(1)).save(especializacion);
    }

    @Test
    void testGetAllEspecializaciones() {
        List<Especializacion> especializaciones = new ArrayList<>();
        Especializacion esp1 = new Especializacion();
        esp1.setId(1L);
        esp1.setNombre("Especialización A");
        especializaciones.add(esp1);

        Especializacion esp2 = new Especializacion();
        esp2.setId(2L);
        esp2.setNombre("Especialización B");
        especializaciones.add(esp2);

        when(espRepository.findAll()).thenReturn(especializaciones);

        List<Especializacion> result = espService.getAllEspecializaciones();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(especializaciones, result);

        verify(espRepository, times(1)).findAll();
    }

    @Test
    void testGetEspecializacionById() {
        Long especializacionId = 1L;
        Especializacion especializacion = new Especializacion();
        especializacion.setId(especializacionId);
        especializacion.setNombre("Especialización A");

        when(espRepository.findById(especializacionId)).thenReturn(Optional.of(especializacion));

        Especializacion result = espService.getEspecializacionById(especializacionId);

        assertNotNull(result);
        assertEquals(especializacion, result);

        verify(espRepository, times(1)).findById(especializacionId);
    }
}
