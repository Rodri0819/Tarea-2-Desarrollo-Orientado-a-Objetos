package org.example;

import java.time.*;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * Clase abstracta que representa una reunión con participantes, asistencias y organizador.
 */
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

    /**
     * Constructor para crear una reunión.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista para iniciar la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param organizador Empleado que organiza la reunión.
     * @param tipoReunion Tipo de la reunión.
     */
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
    /**
     * Obtiene una lista de empleados que fueron invitados y marcaron asistencia.
     * @return Lista de empleados que asistieron.
     */
    public void marcarAsistencia(Empleado empleado) {
        // Verifica si el empleado ya ha sido marcado como asistente
        for (Asistencia asistenciaExistente : this.asistencias) {
            if (asistenciaExistente.getEmpleado().equals(empleado)) {
                System.out.println("Asistencia ya marcada para: " + empleado.getNombre());
                return;  // Si ya está marcado, sale del método para evitar duplicados
            }
        }
        Asistencia nuevaAsistencia = new Asistencia(empleado, true);
        this.asistencias.add(nuevaAsistencia);
        System.out.println("Asistencia marcada para: " + empleado.getNombre());
    }


    /**
     * Obtiene una lista de empleados que fueron invitados pero no asistieron a la reunión.
     * @return Lista de empleados ausentes.
     */
    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>();
        for (Invitacion invitacion : this.invitaciones) {
            boolean asistio = false;
            if (invitacion.getDestinatario() instanceof Empleado) {
                Empleado empleadoInvitado = (Empleado) invitacion.getDestinatario();
                for (Asistencia asistencia : this.asistencias) {
                    if (asistencia.getEmpleado().equals(empleadoInvitado) && asistencia.getAsistio()) {
                        asistio = true;
                        break;
                    }
                }
                if (!asistio) {
                    ausentes.add(empleadoInvitado);
                }
            }
        }
        return ausentes;
    }


    /**
     * Obtiene una lista de empleados que llegaron tarde a la reunión.
     * @return Lista de empleados que se registraron como retrasados.
     */
    public List<Empleado> obtenerRetrasos() {
        //Se delcara la lista de retrasados
        List<Empleado> retrasados = new ArrayList<>();
        //Recorre la asistencia
        for (Asistencia asistencia : this.asistencias) {
            //Si está en la instancia de la clase retraso
            if (asistencia instanceof Retraso) {
                //Se añade a la lista de retraso
                retrasados.add(asistencia.getEmpleado());
            }
        }
        return retrasados;
    }

    /**
     * Calcula el total de asistencias a la reunión.
     * @return Número total de asistentes que confirmaron su presencia.
     */
    public int totalAsistencias() {
        return asistencias.size();
    }

    /**
     * Calcula el porcentaje de asistencia en relación con el total de invitados.
     * @return Porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = this.invitaciones.size();
        int totalAsistentes = this.asistencias.size();
        float porcentajeAsistencia = 0.0f;

        if (totalInvitados > 0) {
            porcentajeAsistencia = (float) totalAsistentes / totalInvitados * 100.0f; // Conversión explícita y multiplicación por 100 para obtener el porcentaje
        }

        return porcentajeAsistencia;
    }

    /**
     * Calcula la duración real de la reunión basada en la hora de inicio y fin.
     * @return Duración real de la reunión.
     */
    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        }
        return Duration.ZERO;
    }


    /**
     * Registra el momento de inicio de la reunión.
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    /**
     * Registra el momento de finalización de la reunión.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }

    /**
     * Agrega un participante a la reunión y envía una invitación.
     * @param participante Objeto Invitable que será agregado a la lista de participantes.
     */
    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) { // Asegurarse de no duplicar participantes
            participantes.add(participante);
            Invitacion invitacion = new Invitacion(participante, this, Instant.now());
            invitaciones.add(invitacion);
            invitacion.enviar(); // Enviar invitación al agregar al participante
        }
    }



    /**
     * GETTERS
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    public Date getFecha() {
        return fecha;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public org.example.tipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Invitable> getParticipantes() {
        return participantes;
    }

    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * SETTERS
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public void setTipoReunion(org.example.tipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public void setParticipantes(List<Invitable> participantes) {
        this.participantes = participantes;
    }
}
