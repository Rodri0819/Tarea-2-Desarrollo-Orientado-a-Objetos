package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * La clase ReunionPresencial representa una reunión presencial que se lleva a cabo en una sala específica.
 */
public class ReunionPresencial extends org.example.Reunion {
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial.
     *
     * @param sala            La sala donde se llevará a cabo la reunión.
     * @param fecha           La fecha de la reunión.
     * @param horaPrevista    La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param organizador     El organizador de la reunión.
     * @param tipoReunion     El tipo de la reunión.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String sala) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }

    /**
     * Devuelve una representación en cadena del objeto ReunionPresencial.
     *
     * @return Una cadena que representa la reunión presencial.
     */
    @Override
    public String toString() {
        return "ReunionPresencial{" +
                "sala='" + sala + '\'' +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene la sala donde se llevará a cabo la reunión.
     *
     * @return La sala de la reunión.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Establece la sala donde se llevará a cabo la reunión.
     *
     * @param sala La sala a establecer.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }
}