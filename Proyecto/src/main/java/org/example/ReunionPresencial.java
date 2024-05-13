package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }

    //Getters
    public String getSala() {
        return sala;
    }

    //Seters
    public void setSala(String sala) {
        this.sala = sala;
    }

}

