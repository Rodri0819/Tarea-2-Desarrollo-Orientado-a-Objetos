package org.example;

import java.time.*;

/**
 * La clase Invitacion representa una invitación a una reunión, incluyendo el destinatario, la reunión y la hora de envío.
 */
class Invitacion {
    private Invitable destinatario;
    private Reunion reunion;
    private Instant horaEnvio;

    /**
     * Constructor de la clase Invitacion.
     *
     * @param destinatario El destinatario de la invitación.
     * @param reunion      La reunión a la que se invita.
     * @param horaEnvio    La hora en que se envió la invitación.
     */
    public Invitacion(Invitable destinatario, Reunion reunion, Instant horaEnvio) {
        this.destinatario = destinatario;
        this.reunion = reunion;
        this.horaEnvio = horaEnvio;
    }

    /**
     * Envía la invitación y notifica al destinatario.
     */
    public void enviar() {
        String mensaje = generarMensajeInvitacion();
        System.out.println(mensaje);
        destinatario.invitar(reunion);
    }

    /**
     * Genera el mensaje de la invitación.
     *
     * @return El mensaje de la invitación.
     */
    private String generarMensajeInvitacion() {
        Empleado organizador = reunion.getOrganizador();
        return "El organizador " + organizador.getNombre() + " ha enviado una invitación ";
    }

    /**
     * Devuelve una representación en cadena del objeto Invitacion.
     *
     * @return Una cadena que representa la invitación.
     */
    @Override
    public String toString() {
        return "Invitacion{" +
                "destinatario=" + destinatario +
                ", reunion=" + reunion +
                ", horaEnvio=" + horaEnvio +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene el destinatario de la invitación.
     *
     * @return El destinatario.
     */
    public Invitable getDestinatario() {
        return destinatario;
    }

    /**
     * Establece el destinatario de la invitación.
     *
     * @param destinatario El destinatario a establecer.
     */
    public void setDestinatario(Invitable destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtiene la reunión de la invitación.
     *
     * @return La reunión.
     */
    public Reunion getReunion() {
        return reunion;
    }

    /**
     * Establece la reunión de la invitación.
     *
     * @param reunion La reunión a establecer.
     */
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Obtiene la hora de envío de la invitación.
     *
     * @return La hora de envío.
     */
    public Instant getHoraEnvio() {
        return horaEnvio;
    }

    /**
     * Establece la hora de envío de la invitación.
     *
     * @param horaEnvio La hora de envío a establecer.
     */
    public void setHoraEnvio(Instant horaEnvio) {
        this.horaEnvio = horaEnvio;
    }
}
