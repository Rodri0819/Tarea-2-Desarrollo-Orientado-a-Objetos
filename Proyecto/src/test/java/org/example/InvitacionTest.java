package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;

public class InvitacionTest {

    @Mock
    private Invitable destinatario;
    @Mock
    private Reunion reunion;
    private Invitacion invitacion;
    private Instant horaEnvio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        horaEnvio = Instant.now();
        when(reunion.getOrganizador()).thenReturn(new Empleado("008", "Vidal", "Arturo", "kingarturo@gmail.com"));
        invitacion = new Invitacion(destinatario, reunion, horaEnvio);
    }

    @Test
    public void testGetters() {
        assertEquals(destinatario, invitacion.getDestinatario(), "El destinatario debe coincidir con el establecido en setUp");
        assertEquals(reunion, invitacion.getReunion(), "La reunión debe coincidir con la establecida en setUp");
        assertEquals(horaEnvio, invitacion.getHoraEnvio(), "La hora de envío debe coincidir con la establecida en setUp");
    }

    @Test
    public void testSetters() {
        Invitable newDestinatario = mock(Invitable.class);
        Reunion newReunion = mock(Reunion.class);
        Instant newHoraEnvio = Instant.now();

        invitacion.setDestinatario(newDestinatario);
        assertEquals(newDestinatario, invitacion.getDestinatario(), "El destinatario debe haber sido actualizado");

        invitacion.setReunion(newReunion);
        assertEquals(newReunion, invitacion.getReunion(), "La reunión debe haber sido actualizada");

        invitacion.setHoraEnvio(newHoraEnvio);
        assertEquals(newHoraEnvio, invitacion.getHoraEnvio(), "La hora de envío debe haber sido actualizada");
    }
}
