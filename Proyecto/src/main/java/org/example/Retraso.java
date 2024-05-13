package org.example;

import java.time.Instant;

class Retraso {
    private Empleado empleado;
    private Instant horaLlegada;

    public Retraso(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }
}
