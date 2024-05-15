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

    public void enviar() {
        String mensaje = Invitacionorganizador();
        System.out.println(mensaje);
        destinatario.invitar(reunion);
    }
    private String Invitacionorganizador() {
        Empleado organizador = reunion.getOrganizador();
        return "El organizador " + organizador.getNombre() + " ha enviado una invitación ";
    }

    //toString

    @Override
    public String toString() {
        return "Invitacion{" +
                "destinatario=" + destinatario +
                ", reunion=" + reunion +
                ", horaEnvio=" + horaEnvio +
                '}';
    }

    //Getters y Setters

    public Invitable getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Invitable destinatario) {
        this.destinatario = destinatario;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Instant getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Instant horaEnvio) {
        this.horaEnvio = horaEnvio;
    }
}
