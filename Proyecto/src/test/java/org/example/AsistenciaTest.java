package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/*  assertEquals(expected, actual); Si los valores no son iguales, la prueba falla
    assertTrue(condition); Si la condición es false, la prueba falla
    assertFalse(condition);Si la condición es true, la prueba falla
    assertNotNull(object); Si el objeto es null, la prueba falla
    assertNull(object); Si el objeto no es null, la prueba falla

 */
public class AsistenciaTest {

    @Test
    @DisplayName("Test creación de Asistencia con asistencia")
    public void test1() {
        Empleado empleado = new Empleado("12345", "Doe", "John", "john.doe@example.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertTrue(asistencia.isAsistio());
    }

    @Test
    @DisplayName("Test creación de Asistencia sin asistencia")
    public void test2() {
        Empleado empleado = new Empleado("67890", "Smith", "Jane", "jane.smith@example.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, false, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertFalse(asistencia.isAsistio());
    }

    @Test
    @DisplayName("Test setters de Asistencia")
    public void test3() {
        Empleado empleado = new Empleado("12345", "Doe", "John", "john.doe@example.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        Empleado nuevoEmpleado = new Empleado("67890", "Smith", "Jane", "jane.smith@example.com");
        asistencia.setEmpleado(nuevoEmpleado);
        asistencia.setHoraLlegada(horaLlegada.plusSeconds(3600));
        asistencia.setAsistio(false);

        assertEquals(nuevoEmpleado, asistencia.getEmpleado());
        assertEquals(horaLlegada.plusSeconds(3600), asistencia.getHoraLlegada());
        assertFalse(asistencia.isAsistio());
    }
}
