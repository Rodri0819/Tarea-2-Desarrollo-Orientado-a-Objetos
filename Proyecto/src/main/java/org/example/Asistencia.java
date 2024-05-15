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

    //toString
    @Override
    public String toString() {
        return "Asistencia{" +
                "empleado=" + empleado +
                ", horaLlegada=" + horaLlegada +
                ", asistio=" + asistio +
                '}';
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setHoraLlegada(Instant horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public boolean isAsistio() {
        return asistio;
    }
}
