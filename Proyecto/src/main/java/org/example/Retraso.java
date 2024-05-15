package org.example;

import java.time.Duration;
import java.time.Instant;

class Retraso extends Asistencia {
    private Duration duracionRetraso;

    public Retraso(Empleado empleado, Instant horaLlegada, Instant horaInicio) {
        super(empleado, true, horaLlegada);
        this.duracionRetraso = Duration.between(horaInicio, horaLlegada);
    }

    //toString
    @Override
    public String toString() {
        return "Retraso{" +
                "duracionRetraso=" + duracionRetraso +
                '}';
    }
    //Getters y Setters

    public Duration getDuracionRetraso() {
        return duracionRetraso;
    }

    public void setDuracionRetraso(Duration duracionRetraso) {
        this.duracionRetraso = duracionRetraso;
    }
}
