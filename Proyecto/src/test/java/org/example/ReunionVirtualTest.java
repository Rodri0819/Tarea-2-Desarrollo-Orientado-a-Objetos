package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReunionVirtualTest {

    private ReunionVirtual reunionVirtual;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Empleado organizador;
    private String enlace;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(1);
        organizador = new Empleado("001", "Bravo", "Claudio", "bravo@capi.cl");
        enlace = "https://meet.example.com/join/12345";
        reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion.TECNICA, enlace);
    }

    @Test
    void testConstructor() {
        assertEquals(fecha, reunionVirtual.getFecha());
        assertEquals(horaPrevista, reunionVirtual.getHoraPrevista());
        assertEquals(duracionPrevista, reunionVirtual.getDuracionPrevista());
        assertEquals(organizador, reunionVirtual.getOrganizador());
        assertEquals(tipoReunion.TECNICA, reunionVirtual.getTipoReunion());
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testSetEnlace() {
        String nuevoEnlace = "https://meet.example.com/join/51551";
        reunionVirtual.setEnlace(nuevoEnlace);
        assertEquals(nuevoEnlace, reunionVirtual.getEnlace());
    }
}
