package com.citas.citasmedicas;

import com.citas.citasmedicas.models.MedicoEspecializacion;
import com.citas.citasmedicas.repositories.MedicoEspecializacionRepository;
import com.citas.citasmedicas.services.MedicoEspecializacionService;
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

class MedicoEspecializacionServiceTest {

    @Mock
    private MedicoEspecializacionRepository medicoEspecializacionRepository;

    @InjectMocks
    private MedicoEspecializacionService medicoEspecializacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMedicoEspecializacion() {
        Long medicoEspecializacionId = 1L;
        MedicoEspecializacion medicoEspecializacion = new MedicoEspecializacion();
        medicoEspecializacion.setId(medicoEspecializacionId);

        when(medicoEspecializacionRepository.findById(medicoEspecializacionId)).thenReturn(Optional.of(medicoEspecializacion));

        Optional<MedicoEspecializacion> result = medicoEspecializacionService.getMedicoEspecializacion(medicoEspecializacionId);

        assertTrue(result.isPresent());
        assertEquals(medicoEspecializacion, result.get());

        verify(medicoEspecializacionRepository, times(1)).findById(medicoEspecializacionId);
    }

    @Test
    void testGetAllMedicoEspecializaciones() {
        List<MedicoEspecializacion> medicoEspecializaciones = new ArrayList<>();
        MedicoEspecializacion medicoEspecializacion1 = new MedicoEspecializacion();
        medicoEspecializacion1.setId(1L);
        medicoEspecializaciones.add(medicoEspecializacion1);

        MedicoEspecializacion medicoEspecializacion2 = new MedicoEspecializacion();
        medicoEspecializacion2.setId(2L);
        medicoEspecializaciones.add(medicoEspecializacion2);

        when(medicoEspecializacionRepository.findAll()).thenReturn(medicoEspecializaciones);

        List<MedicoEspecializacion> result = medicoEspecializacionService.getAllMedicoEspecializaciones();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(medicoEspecializaciones, result);

        verify(medicoEspecializacionRepository, times(1)).findAll();
    }

    @Test
    void testDeleteMedicoEspecializacion() {
        Long medicoEspecializacionId = 1L;

        doNothing().when(medicoEspecializacionRepository).deleteById(medicoEspecializacionId);

        assertDoesNotThrow(() -> medicoEspecializacionService.deleteMedicoEspecializacion(medicoEspecializacionId));

        verify(medicoEspecializacionRepository, times(1)).deleteById(medicoEspecializacionId);
    }


}
