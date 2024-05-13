package org.example;
import java.time.*;

class Invitacion {
    private Invitable destinatario;
    private Reunion reunion;
    private Instant horaEnvio;

    public Invitacion(Invitable destinatario, Reunion reunion, Instant horaEnvio) {
        this.destinatario = destinatario;
        this.reunion = reunion;
        this.horaEnvio = horaEnvio;
    }

    // Getters y setters
    public Invitable getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Invitable destinatario) {
        this.destinatario = destinatario;
    }


    public Instant getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Instant horaEnvio) {
        this.horaEnvio = horaEnvio;
    }


    public void enviar() {
        String mensaje = construirMensajeInvitacion();
        System.out.println(mensaje);
        destinatario.invitar(reunion);
    }
    private String construirMensajeInvitacion() {
        Empleado organizador = reunion.getOrganizador();


        return "El organizador " + organizador.getNombre() + " ha enviado una invitación ";
    }



}
