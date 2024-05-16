package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaTest {

    @Test
    @DisplayName("Test creación de Asistencia con asistencia")
    public void test1() {
        Empleado empleado = new Empleado("123", "Fuentealba", "Martin", "martinf@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertTrue(asistencia.isAsistio());
    }

    @Test
    @DisplayName("Test creación de Asistencia sin asistencia")
    public void test2() {
        Empleado empleado = new Empleado("007", "Bonaparte", "Napoleon", "caballoblanco@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, false, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertFalse(asistencia.isAsistio());
    }

    @Test
    @DisplayName("Test setters de Asistencia")
    public void test3() {
        Empleado empleado = new Empleado("123", "Fuentealba", "Martin", "martinf@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        Empleado nuevoEmpleado = new Empleado("007", "Bonaparte", "Napoleon", "caballoblanco@gmail.com");
        asistencia.setEmpleado(nuevoEmpleado);
        asistencia.setHoraLlegada(horaLlegada.plusSeconds(3600));
        asistencia.setAsistio(false);

        assertEquals(nuevoEmpleado, asistencia.getEmpleado());
        assertEquals(horaLlegada.plusSeconds(3600), asistencia.getHoraLlegada());
        assertFalse(asistencia.isAsistio());
    }
}
