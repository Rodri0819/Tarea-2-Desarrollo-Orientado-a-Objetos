package org.example;

import java.time.Instant;

/**
 * La clase Asistencia representa el registro de asistencia de un empleado, incluyendo la hora de llegada y si asistió o no.
 */
public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private boolean asistio;

    /**
     * Constructor de la clase Asistencia.
     *
     * @param empleado    El empleado que está registrando la asistencia.
     * @param asistio     Indica si el empleado asistió o no.
     * @param horaLlegada La hora de llegada del empleado.
     */
    public Asistencia(Empleado empleado, boolean asistio, Instant horaLlegada) {
        this.empleado = empleado;
        this.asistio = asistio;
        this.horaLlegada = horaLlegada;
    }

    /**
     * ToString de Asistencia.
     *
     * @return Una cadena que representa la asistencia del empleado.
     */
    @Override
    public String toString() {
        return "Asistencia{" +
                "empleado=" + empleado +
                ", horaLlegada=" + horaLlegada +
                ", asistio=" + asistio +
                '}';
    }

    /**
     * Obtiene el empleado asociado a esta asistencia.
     *
     * @return El empleado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado asociado a esta asistencia.
     *
     * @param empleado El empleado a establecer.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene la hora de llegada del empleado.
     *
     * @return La hora de llegada.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Establece la hora de llegada del empleado.
     *
     * @param horaLlegada La hora de llegada a establecer.
     */
    public void setHoraLlegada(Instant horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    /**
     * Indica si el empleado asistió.
     *
     * @return {@code true} si el empleado asistió, de lo contrario {@code false}.
     */
    public boolean getAsistio() {
        return asistio;
    }

    /**
     * Establece si el empleado asistió.
     *
     * @param asistio {@code true} si el empleado asistió, de lo contrario {@code false}.
     */
    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    /**
     * Indica si el empleado asistió.
     *
     * @return {@code true} si el empleado asistió, de lo contrario {@code false}.
     */
    public boolean isAsistio() {
        return asistio;
    }
}
