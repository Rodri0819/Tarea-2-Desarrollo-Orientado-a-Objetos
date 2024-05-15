package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * La clase ReunionVirtual representa una reunión virtual que se lleva a cabo en un enlace específico.
 */
class ReunionVirtual extends org.example.Reunion {
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     *
     * @param fecha           La fecha de la reunión.
     * @param horaPrevista    La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param organizador     El organizador de la reunión.
     * @param tipoReunion     El tipo de la reunión.
     * @param enlace          El enlace donde se llevará a cabo la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace = enlace;
    }

    /**
     * Devuelve una representación en cadena del objeto ReunionVirtual.
     *
     * @return Una cadena que representa la reunión virtual.
     */
    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene el enlace donde se llevará a cabo la reunión virtual.
     *
     * @return El enlace de la reunión virtual.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Establece el enlace donde se llevará a cabo la reunión virtual.
     *
     * @param enlace El enlace a establecer.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}