package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

class ReunionTest {

    private Reunion reunion;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;


    @BeforeEach
    void setUp() {
        organizador = new Empleado("444", "Pérez", "Juan", "juanito@gmail.com");
        empleado1 = new Empleado("100", "Bizama", "Ana", "anabizama@mamita.com");
        empleado2 = new Empleado("017", "Medel", "Gary", "pitbull@gmail.cl");
        empleado3 = new Empleado("020", "Aranguiz", "Charles", "charles@thebest.com");

        reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organizador, tipoReunion.TECNICA, "https://meet.example.com/join/12345");
        reunion.agregarParticipante(organizador);
        reunion.agregarParticipante(empleado1);
        reunion.agregarParticipante(empleado2);
        reunion.agregarParticipante(empleado3);
        reunion.iniciar();
    }

    @Test
    void testIniciarReunion() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());
        System.out.println("Hora de inicio: " + reunion.getHoraInicio());
    }

    @Test
    void testFinalizarReunion() {
        reunion.iniciar();
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());
        System.out.println("Hora de fin: " + reunion.getHoraFin());
    }

    @Test
    void testAgregarParticipante() {
        Empleado nuevoParticipante = new Empleado("004", "Isla", "Mauricio", "huaso@chile.com");
        reunion.agregarParticipante(nuevoParticipante);
        System.out.println(reunion.getParticipantes().contains(nuevoParticipante));
        assertTrue(reunion.getParticipantes().contains(nuevoParticipante));
    }

    @Test
    void testMarcarAsistencia() {
        reunion.iniciar();
        reunion.marcarAsistencia(empleado1, Instant.now());
        assertTrue(reunion.getAsistencias().stream().anyMatch(a -> a.getEmpleado().equals(empleado1) && a.isAsistio()));
    }

    @Test
    void testObtenerAusencias() {
        // Solo marcar asistencia para algunos empleados
        reunion.marcarAsistencia(organizador, Instant.now()); //Evidentemente el organizador no puede estar ausente
        reunion.marcarAsistencia(empleado1, Instant.now());
        reunion.marcarAsistencia(empleado2, Instant.now().plusSeconds(10)); //Suponer que este llega tarde y se cuenta como retraso

        List<Empleado> ausentes = reunion.obtenerAusencias();
        assertTrue(ausentes.contains(empleado3), "Debe incluir a los empleados que no han marcado asistencia");
        assertFalse(ausentes.contains(empleado1), "No debe incluir a los empleados que sí han marcado asistencia");
        assertFalse(ausentes.contains(empleado2), "No debe incluir a los empleados que han llegado tarde pero han marcado asistencia");
        assertEquals(1, ausentes.size(), "Solo debe haber un empleado ausente");
    }
}
