package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class ReunionPresencial extends org.example.Reunion {
    private String sala;

    public ReunionPresencial(String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }

    //toString

    @Override
    public String toString() {
        return "ReunionPresencial{" +
                "sala='" + sala + '\'' +
                '}';
    }

    //Getters y Setters


    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}