package com.citas.citasmedicas;

import com.citas.citasmedicas.models.Persona;
import com.citas.citasmedicas.repositories.PersonaRepository;
import com.citas.citasmedicas.services.PersonaService;
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

class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPerson() {
        Persona persona = new Persona();
        persona.setId(1L);
        persona.setNombre("John");
        persona.setApellido1("Doe");
        // Establece otros atributos según sea necesario

        when(personaRepository.save(persona)).thenReturn(persona);

        Persona result = personaService.addPerson(persona);

        assertNotNull(result);
        assertEquals(persona, result);

        verify(personaRepository, times(1)).save(persona);
    }

    @Test
    void testUpdate() {
        Long personaId = 1L;
        Persona existingPersona = new Persona();
        existingPersona.setId(personaId);
        existingPersona.setNombre("John");
        existingPersona.setApellido1("Doe");
        // Establece otros atributos según sea necesario

        Persona updatedPersona = new Persona();
        updatedPersona.setNombre("Jane");
        updatedPersona.setApellido1("Doe");
        // Actualiza otros atributos según sea necesario

        when(personaRepository.findById(personaId)).thenReturn(Optional.of(existingPersona));
        when(personaRepository.save(existingPersona)).thenReturn(existingPersona);

        Persona result = personaService.update(personaId, updatedPersona);

        assertNotNull(result);
        assertEquals(updatedPersona.getNombre(), result.getNombre());
        assertEquals(updatedPersona.getApellido1(), result.getApellido1());
        // Compara otros atributos actualizados según sea necesario

        verify(personaRepository, times(1)).findById(personaId);
        verify(personaRepository, times(1)).save(existingPersona);
    }

    @Test
    void testUpdateNotFound() {
        Long personaId = 1L;
        Persona updatedPersona = new Persona();
        updatedPersona.setNombre("Jane");
        updatedPersona.setApellido1("Doe");
        // Establece otros atributos según sea necesario

        when(personaRepository.findById(personaId)).thenReturn(Optional.empty());

        Persona result = personaService.update(personaId, updatedPersona);

        assertNull(result);

        verify(personaRepository, times(1)).findById(personaId);
        verify(personaRepository, never()).save(any());
    }

    @Test
    void testDeletePerson() {
        Long personaId = 1L;

        doNothing().when(personaRepository).deleteById(personaId);

        assertDoesNotThrow(() -> personaService.deletePerson(personaId));

        verify(personaRepository, times(1)).deleteById(personaId);
    }

    @Test
    void testGetPersonById() {
        Long personaId = 1L;
        Persona persona = new Persona();
        persona.setId(personaId);
        persona.setNombre("John");
        persona.setApellido1("Doe");
        // Establece otros atributos según sea necesario

        when(personaRepository.findById(personaId)).thenReturn(Optional.of(persona));

        Optional<Persona> result = personaService.getPersonById(personaId);

        assertTrue(result.isPresent());
        assertEquals(persona, result.get());

        verify(personaRepository, times(1)).findById(personaId);
    }

    @Test
    void testGetAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona persona1 = new Persona();
        persona1.setId(1L);
        persona1.setNombre("John");
        persona1.setApellido1("Doe");
        // Establece otros atributos según sea necesario
        personas.add(persona1);

        Persona persona2 = new Persona();
        persona2.setId(2L);
        persona2.setNombre("Jane");
        persona2.setApellido1("Doe");
        // Establece otros atributos según sea necesario
        personas.add(persona2);

        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> result = personaService.getAllPersonas();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(personas, result);

        verify(personaRepository, times(1)).findAll();
    }
}
