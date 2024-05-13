package org.example;

import java.time.Instant;

class Retraso extends Asistencia {
    private Instant horaLlegada;

    public Retraso(Empleado empleado, Instant horaLlegada) {
        super(empleado, true);  // Asumimos que el empleado ha asistido si llega tarde.
        this.horaLlegada = horaLlegada;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public boolean esRetraso(Instant horaInicio) {
        return horaLlegada.isAfter(horaInicio);
    }
}
