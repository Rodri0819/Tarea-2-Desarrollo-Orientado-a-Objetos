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

    //Getters
    public String getEnlace() {
        return enlace;
    }

    //Setters
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }


}