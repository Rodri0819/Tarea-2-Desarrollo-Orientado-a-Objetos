package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmpleadoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Captura la salida de la consola
        empleado = new Empleado("100", "Perez", "Juanito", "juanito@outlook.com");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut); // Restablece la salida estándar
    }

    @Test
    public void testInvitarReunionVirtual() {
        ReunionVirtual reunionVirtualMock = mock(ReunionVirtual.class);
        when(reunionVirtualMock.getEnlace()).thenReturn("https://meet.example.com/join/12345");

        empleado.invitar(reunionVirtualMock);

        String expectedMessage = "Invitación enviada a Juanito via email: juanito@outlook.com con detalles: Estimado Juanito Perez, está invitado a una reunión virtual en el siguiente enlace: https://meet.example.com/join/12345";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testInvitarReunionPresencial() {
        ReunionPresencial reunionPresencialMock = mock(ReunionPresencial.class);
        when(reunionPresencialMock.getSala()).thenReturn("Sala de Conferencias");

        empleado.invitar(reunionPresencialMock);

        String expectedMessage = "Invitación enviada a Juanito via email: juanito@outlook.com con detalles: Estimado Juanito Perez, está invitado a una reunión presencial en la sala: Sala de Conferencias";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }
}