package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReunionPresencialTest {

    private ReunionPresencial reunionPresencial;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Empleado organizador;
    private String sala;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(2);
        organizador = new Empleado("007", "Sanchez", "Alexis", "maravilla@chile.com");
        sala = "Sala LABCOM-TM";
        reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion.TECNICA, sala);
    }

    @Test
    void testConstructor() {
        assertEquals(fecha, reunionPresencial.getFecha());
        assertEquals(horaPrevista, reunionPresencial.getHoraPrevista());
        assertEquals(duracionPrevista, reunionPresencial.getDuracionPrevista());
        assertEquals(organizador, reunionPresencial.getOrganizador());
        assertEquals(tipoReunion.TECNICA, reunionPresencial.getTipoReunion());
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testSetSala() {
        String nuevaSala = "Sala A-412";
        reunionPresencial.setSala(nuevaSala);
        assertEquals(nuevaSala, reunionPresencial.getSala());
    }
}
