package com.citas.citasmedicas;

import com.citas.citasmedicas.models.Medico;
import com.citas.citasmedicas.repositories.MedicoRepository;
import com.citas.citasmedicas.services.MedicoService;
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

class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteMedico() {
        Long medicoId = 1L;

        doNothing().when(medicoRepository).deleteById(medicoId);

        assertDoesNotThrow(() -> medicoService.deleteMedico(medicoId));

        verify(medicoRepository, times(1)).deleteById(medicoId);
    }

}

