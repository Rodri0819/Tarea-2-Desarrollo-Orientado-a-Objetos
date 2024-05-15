package org.example;

import java.time.Duration;
import java.time.Instant;

/**
 * La clase Retraso representa un retraso en la asistencia de un empleado, extendiendo la clase Asistencia.
 */
class Retraso extends Asistencia {
    private Duration duracionRetraso;

    /**
     * Constructor de la clase Retraso.
     *
     * @param empleado    El empleado que llegó tarde.
     * @param horaLlegada La hora de llegada del empleado.
     * @param horaInicio  La hora de inicio prevista.
     */
    public Retraso(Empleado empleado, Instant horaLlegada, Instant horaInicio) {
        super(empleado, true, horaLlegada);
        this.duracionRetraso = Duration.between(horaInicio, horaLlegada);
    }

    /**
     * Devuelve una representación en cadena del objeto Retraso.
     *
     * @return Una cadena que representa el retraso.
     */
    @Override
    public String toString() {
        return "Retraso{" +
                "duracionRetraso=" + duracionRetraso +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene la duración del retraso.
     *
     * @return La duración del retraso.
     */
    public Duration getDuracionRetraso() {
        return duracionRetraso;
    }

    /**
     * Establece la duración del retraso.
     *
     * @param duracionRetraso La duración del retraso a establecer.
     */
    public void setDuracionRetraso(Duration duracionRetraso) {
        this.duracionRetraso = duracionRetraso;
    }
}
