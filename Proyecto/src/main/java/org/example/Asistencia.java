package org.example;

import java.time.Instant;

public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private boolean asistio;

    public Asistencia(Empleado empleado, boolean asistio, Instant horaLlegada) {
        this.empleado = empleado;
        this.asistio = asistio;
        this.horaLlegada = horaLlegada;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public boolean getAsistio() {
        return asistio;
    }
}