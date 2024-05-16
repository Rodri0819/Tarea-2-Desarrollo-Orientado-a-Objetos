package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;

public class RetrasoTest {

    @Test
    public void testCalculoDuracionRetraso() {
        Instant horaInicio = Instant.parse("2024-05-03T10:15:30.00Z");
        Instant horaLlegada = Instant.parse("2024-05-03T10:25:30.00Z"); // Duracion de 10 minutos
        Empleado empleado = new Empleado("007", "Sanchez", "Alexis", "maravilla@chile.com");

        Retraso retraso = new Retraso(empleado, horaLlegada, horaInicio);
        Duration duracionEsperada = Duration.between(horaInicio, horaLlegada);

        assertEquals(duracionEsperada, retraso.getDuracionRetraso());
    }

    @Test
    public void testToString() {
        Instant horaInicio = Instant.parse("2024-05-03T10:15:30.00Z");
        Instant horaLlegada = Instant.parse("2024-05-03T10:25:30.00Z");
        Empleado empleado = new Empleado("007", "Sanchez", "Alexis", "maravilla@chile.com");

        Retraso retraso = new Retraso(empleado, horaLlegada, horaInicio);
        String expectedString = "Retraso{duracionRetraso=PT10M}";

        assertEquals(expectedString, retraso.toString());
    }
}
