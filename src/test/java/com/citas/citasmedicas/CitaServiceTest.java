package com.citas.citasmedicas;

import com.citas.citasmedicas.models.Cita;
import com.citas.citasmedicas.repositories.CitaRepository;
import com.citas.citasmedicas.services.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaServiceTest {

    @Mock
    private CitaRepository citaRepository;

    @InjectMocks
    private CitaService citaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCitaByIdNotFound() {
        Long citaId = 1L;

        // Configurar el repositorio para devolver Optional vacío cuando se busque por el ID proporcionado
        when(citaRepository.findById(citaId)).thenReturn(Optional.empty());

        // Intentar obtener una cita con un ID que sabemos que no existe
        Optional<Cita> result = citaService.getCitaById(citaId);

        // La aserción fallará porque se esperaba un Optional vacío
        assertFalse(result.isPresent());

        verify(citaRepository, times(1)).findById(citaId);
    }

}
