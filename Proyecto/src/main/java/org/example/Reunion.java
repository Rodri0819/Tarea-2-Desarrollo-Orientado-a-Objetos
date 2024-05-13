package org.example;
import java.time.*;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;
    private List<Nota> notas;
    private Empleado organizador;
    private tipoReunion tipoReunion;
    private List<Invitable> participantes;


    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;
        this.asistencias = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.participantes = new ArrayList<>();

    }

    //Getters

    public Empleado getOrganizador() {
        return organizador;
    }

    public void obtenerAsistencias() { //list

    }

    public void obtenerAusencias() {//list

    }

    public void obtenerRetrasos() {//list

    }

    public void totalAsistencias() { //int

    }

    public void obtenerPorcentajeAsistencia() { //float

    }

    public void calcularTiempoReal() { //float

    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    public void agregarParticipante(Invitable participante) {
        participantes.add(participante);
        Invitacion invitacion = new Invitacion(participante, this, Instant.now());
        invitacion.enviar();  //Envia la invitacion
    }

}