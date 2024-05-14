package org.example;

import java.time.Duration;
import java.time.Instant;

class Retraso extends Asistencia {
    private Duration duracionRetraso;

    public Retraso(Empleado empleado, Instant horaLlegada, Instant horaInicio) {
        super(empleado, true, horaLlegada);
        this.duracionRetraso = Duration.between(horaInicio, horaLlegada);
    }

    public Duration getDuracionRetraso() {
        return duracionRetraso;
    }
}
