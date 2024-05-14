package org.example;


import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

abstract class Reunion {
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

    public void iniciar() {
        this.horaInicio = Instant.now();
        System.out.println("Reunión iniciada a las: " + this.horaInicio);
    }

    public void finalizar() {
        this.horaFin = Instant.now();
        System.out.println("Reunión finalizada a las: " + this.horaFin);
    }

    public void marcarAsistencia(Empleado empleado, Instant horaLlegada) {
        if (this.horaInicio == null) {
            System.out.println("La reunión aún no ha comenzado.");
            return;
        }

        // Comprobación si el empleado ya ha sido marcado como asistente
        for (Asistencia asistenciaExistente : asistencias) {
            if (asistenciaExistente.getEmpleado().equals(empleado)) {
                System.out.println("Asistencia ya marcada para: " + empleado.getNombre());
                return;
            }
        }

        // Comprueba si la llegada es antes de la hora de inicio más un margen
        boolean asistio = !horaLlegada.isAfter(horaInicio.plusSeconds(5));  // 5 segundos de margen
        Asistencia nuevaAsistencia = asistio ? new Asistencia(empleado, asistio, horaLlegada) :
                new Retraso(empleado, horaLlegada, this.horaInicio);

        this.asistencias.add(nuevaAsistencia);

        if (asistio) {
            System.out.println("Asistencia marcada como presente para: " + empleado.getNombre());
        } else {
            System.out.println("Retraso de " + Duration.between(this.horaInicio, horaLlegada).toSeconds() + " segundos para: " + empleado.getNombre());
        }
    }

    public List<Empleado> obtenerAusencias() {
        return participantes.stream()
                .filter(p -> p instanceof Empleado) // Asegura que Invitable es un Empleado
                .map(p -> (Empleado)p) // Hace un cast seguro de Invitable a Empleado
                .filter(emp -> asistencias.stream().noneMatch(a -> a.getEmpleado().equals(emp)))
                .collect(Collectors.toList());
    }

    public int totalAsistencias() {
        return (int) asistencias.stream().filter(Asistencia::getAsistio).count();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = participantes.size();
        int totalAsistentes = totalAsistencias();
        return totalInvitados > 0 ? (float) totalAsistentes / totalInvitados * 100.0f : 0.0f;
    }

    public Duration calcularTiempoReal() {
        return (horaInicio != null && horaFin != null) ? Duration.between(horaInicio, horaFin) : Duration.ZERO;
    }

    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
            Invitacion invitacion = new Invitacion(participante, this, Instant.now());
            invitaciones.add(invitacion);
            invitacion.enviar();
        }
    }

    public List<Empleado> obtenerRetrasos() {
        return asistencias.stream()
                .filter(a -> a instanceof Retraso)
                .map(a -> a.getEmpleado()) // Aquí estamos seguros de que getEmpleado devuelve Empleado
                .collect(Collectors.toList());
    }

    public void agregarNota(String contenido) {
        Nota nota = new Nota(contenido);
        this.notas.add(nota);
        System.out.println("Nota agregada: " + contenido);
    }

    public void listarNotas() {
        System.out.println("Notas de la reunión:");
        for (Nota nota : notas) {
            System.out.println(nota.getContenido());
        }
    }

    //toString

    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", asistencias=" + asistencias +
                ", invitaciones=" + invitaciones +
                ", notas=" + notas +
                ", organizador=" + organizador +
                ", tipoReunion=" + tipoReunion +
                ", participantes=" + participantes +
                '}';
    }

    //Getters y Setters


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Empleado getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public org.example.tipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public void setTipoReunion(org.example.tipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public List<Invitable> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Invitable> participantes) {
        this.participantes = participantes;
    }
}
