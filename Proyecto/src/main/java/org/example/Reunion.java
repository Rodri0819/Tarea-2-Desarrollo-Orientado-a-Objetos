package org.example;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

/**
 * La clase abstracta Reunion representa una reunión que puede tener asistentes, notas y un organizador.
 */
public class Reunion {
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
     * Constructor de la clase Reunion.
     *
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param organizador      El organizador de la reunión.
     * @param tipoReunion      El tipo de la reunión.
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
     * Inicia la reunión registrando la hora de inicio.
     */
    public void iniciar() {
        if (this.horaInicio == null) {
            this.horaInicio = Instant.now();
            System.out.println("Reunión iniciada a las: " + this.horaInicio);
        } else {
            System.out.println("La reunión ya había sido iniciada previamente.");
        }
    }


    /**
     * Finaliza la reunión registrando la hora de fin.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
        System.out.println("Reunión finalizada a las: " + this.horaFin);
    }

    /**
     * Marca la asistencia de un empleado a la reunión.
     *
     * @param empleado    El empleado cuya asistencia se va a marcar.
     * @param horaLlegada La hora de llegada del empleado.
     */

    public void marcarAsistencia(Empleado empleado, Instant horaLlegada) {
        if (this.horaInicio == null) { //Si la horaInicio es nula
            System.out.println("La reunión aún no ha comenzado.");
            return;
        }
        if (!participantes.contains(empleado)) {
            System.out.println("El empleado " + empleado.getNombre() + " no está invitado a esta reunión.");
            return;
        }


        for (Asistencia asistenciaExistente : asistencias) { //Recorremos las asistenciaExistente en asistencias
            if (asistenciaExistente.getEmpleado().equals(empleado)) { //Si la asistencia existente de un empleado ya está
                System.out.println("Asistencia ya marcada para: " + empleado.getNombre()); //La asistencia ya a sido marcada
                return;
            }
        }

        // Comprueba si la llegada es antes de la hora de inicio más un margen
        boolean asistio;
        if (horaLlegada.isBefore(horaInicio.plusSeconds(5))) { //Si la hora de llegada es antes de 5 segundos pasados la hora de Inicio de la reunion
            asistio = true;  // Llegó a tiempo
        } else {
            asistio = false;  // Llegó tarde
        }

        Asistencia nuevaAsistencia; //Variable nuevaAsistencia de tipo Asistencia
        if (asistio) { //Si llegó a tiempo (Asistio = true)
            nuevaAsistencia = new Asistencia(empleado, true, horaLlegada); //Se instancia la clase Asistencia del empleado
        } else { // Si no llegó a tiempo, llegó tarde (Asistio = false)
            nuevaAsistencia = new Retraso(empleado, horaLlegada, this.horaInicio); //Se instancia la clase Retraso del empleado
        }

        this.asistencias.add(nuevaAsistencia); //En esa reunion creada, se añade una nueva asistencia al arreglo asistencias

    }

    /**
     * Obtiene una lista de empleados que no asistieron a la reunión.
     *
     * @return Una lista de empleados ausentes.
     */
    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>(); //Declaracion arreglo ausentes que almacenará objetos del tipo empleado

        for (Invitable participante : participantes) { //Recorremos los empleados participantes
            if (participante instanceof Empleado) { //Asegurandonos que ese participante es una instancia de empleado (Osea es un empleado)
                Empleado empleado = (Empleado) participante; //casting  de participante a empleado
                boolean sinAsistencia = true; //Suponemos que el empleado no asiste
                for (Asistencia asistencia : asistencias) { //Recorremos las asistencias viendo la asistencia de un empleado
                    if (asistencia.getEmpleado().equals(empleado)) { // Si el empleado de la asistencia actual es igual al empleado actual
                        sinAsistencia = false; //Entonces el empleado si asitió
                        break;
                    }
                }
                if (sinAsistencia) {  //Si todavia SinAsistencia es true entonces
                    ausentes.add(empleado); //Se añade al arreglo de ausentes
                }
            }
        }

        return ausentes;
    }

    /**
     * Calcula el total de asistencias a la reunión.
     *
     * @return El total de asistencias.
     */
    public int totalAsistencias() {
        int totalAsistencias = 0;
        for (Asistencia asistencia : asistencias) { //Recorremos los empleados asistentes
            if (asistencia.getAsistio()) { //Si el empleado asistió
                totalAsistencias++; //Se suma una asistencia
            }
        }
        return totalAsistencias;
    }


    /**
     * Obtiene el porcentaje de asistencia a la reunión.
     *
     * @return El porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        if (participantes.isEmpty()) {
            return 0.0f;
        } else {
            int totalAsistentes = totalAsistencias();
            int numeroParticipantes = participantes.size();
            return (float) totalAsistentes / numeroParticipantes * 100.0f;
        }
    }


    /**
     * Calcula la duración real de la reunión.
     *
     * @return La duración real de la reunión.
     */
    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        } else {
            return Duration.ZERO;
        }
    }


    /**
     * Agrega un participante a la reunión y envía una invitación.
     *
     * @param participante El participante a agregar.
     */
    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) { //Si el participante no esta en participantes
            participantes.add(participante); //Se añade a participantes

            Invitacion invitacion = new Invitacion(participante, this, Instant.now()); //Se crea una instancia de invitacion para la reunion creada y el participante invitado
            invitaciones.add(invitacion); //Se agrega esa instancia de invitacion a las invitaciones
            invitacion.enviar(); //Se llama el metodo enviar de invitacion
        }
    }

    /**
     * Obtiene una lista de empleados que llegaron tarde a la reunión.
     *
     * @return Una lista de empleados que llegaron tarde.
     */
    public List<Empleado> obtenerRetrasos() {
        List<Empleado> retrasados = new ArrayList<>();


        for (Asistencia asistencia : asistencias) { //ecorremos cada asistencia en la lista de asistencias
            if (asistencia instanceof Retraso) { //Verificamos si la asistencia es un retraso
                retrasados.add(asistencia.getEmpleado()); // Obtenemos el empleado asociado al retraso y lo agregamos a la lista de retrasados

            }
        }

        return retrasados; // Devolvemos la lista de empleados que llegaron tarde
    }


    /**
     * Agrega una nota a la reunión.
     *
     * @param contenido El contenido de la nota.
     */
    public void agregarNota(String contenido) {
        Nota nota = new Nota(contenido);
        this.notas.add(nota);
    }

    /**
     * Lista todas las notas de la reunión.
     */
    public void listarNotas() {
        System.out.println("Notas de la reunión:");
        for (Nota nota : notas) {
            System.out.println(nota.getContenido());
        }
    }

    /**
     * Devuelve una representación en cadena del objeto Reunion.
     *
     * @return Una cadena que representa la reunión.
     */
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

    // Getters y Setters

    /**
     * Obtiene la fecha de la reunión.
     *
     * @return La fecha de la reunión.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reunión.
     *
     * @param fecha La fecha a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora prevista de la reunión.
     *
     * @return La hora prevista de la reunión.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Establece la hora prevista de la reunión.
     *
     * @param horaPrevista La hora prevista a establecer.
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * Obtiene la duración prevista de la reunión.
     *
     * @return La duración prevista de la reunión.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Establece la duración prevista de la reunión.
     *
     * @param duracionPrevista La duración prevista a establecer.
     */
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Obtiene la hora de inicio de la reunión.
     *
     * @return La hora de inicio de la reunión.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de la reunión.
     *
     * @param horaInicio La hora de inicio a establecer.
     */
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin de la reunión.
     *
     * @return La hora de fin de la reunión.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de la reunión.
     *
     * @param horaFin La hora de fin a establecer.
     */
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene la lista de asistencias a la reunión.
     *
     * @return La lista de asistencias.
     */
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    /**
     * Establece la lista de asistencias a la reunión.
     *
     * @param asistencias La lista de asistencias a establecer.
     */
    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * Obtiene la lista de invitaciones enviadas para la reunión.
     *
     * @return La lista de invitaciones.
     */
    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    /**
     * Establece la lista de invitaciones enviadas para la reunión.
     *
     * @param invitaciones La lista de invitaciones a establecer.
     */
    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    /**
     * Obtiene la lista de notas de la reunión.
     *
     * @return La lista de notas.
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * Establece la lista de notas de la reunión.
     *
     * @param notas La lista de notas a establecer.
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    /**
     * Obtiene el organizador de la reunión.
     *
     * @return El organizador de la reunión.
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    /**
     * Establece el organizador de la reunión.
     *
     * @param organizador El organizador a establecer.
     */
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    /**
     * Obtiene el tipo de reunión.
     *
     * @return El tipo de reunión.
     */
    public tipoReunion getTipoReunion() {
        return tipoReunion;
    }

    /**
     * Establece el tipo de reunión.
     *
     * @param tipoReunion El tipo de reunión a establecer.
     */
    public void setTipoReunion(tipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    /**
     * Obtiene la lista de participantes de la reunión.
     *
     * @return La lista de participantes.
     */
    public List<Invitable> getParticipantes() {
        return participantes;
    }

    /**
     * Establece la lista de participantes de la reunión.
     *
     * @param participantes La lista de participantes a establecer.
     */
    public void setParticipantes(List<Invitable> participantes) {
        this.participantes = participantes;
    }
}