package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class ReunionVirtual extends org.example.Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace = enlace;
    }

    //toString

    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                '}';
    }

    //Getters y Setters


    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}