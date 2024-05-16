package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * La clase Informe genera un informe sobre una reunión y lo guarda en un archivo
 */
public class Informe {
    private Reunion reunion;
    private String nombreArchivo;

    /**
     * Constructor de la clase Informe
     *
     * @param reunion       La reunión sobre la que se generará el informe
     * @param nombreArchivo El nombre del archivo donde se guardará el informe
     */
    public Informe(Reunion reunion, String nombreArchivo) {
        this.reunion = reunion;
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Genera el informe de la reunión y lo escribe en el archivo especificado al llamar el metodo.
     */
    public void generarInforme() {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("**Informe de Reunión**");

            writer.write("\n\n\n");
            writer.write("Fecha y hora de la reunión: " + reunion.getFecha());
            writer.write("\n\n");

            writer.write("Hora de inicio: " + reunion.getHoraInicio());
            writer.write("\n\n");

            writer.write("Hora de fin: " + reunion.getHoraFin());
            writer.write("\n\n");

            long horas = reunion.getDuracionPrevista().toHoursPart();
            long minutos = reunion.getDuracionPrevista().toMinutesPart();
            if (horas > 0) {
                writer.write("Duración prevista: " + horas + " hora y " + minutos + " minutos");
                writer.write("\n\n");
            } else {
                writer.write("Duración prevista: " + minutos + " minutos");
                writer.write("\n\n");
            }

            writer.write("Duración total: " + reunion.calcularTiempoReal().getSeconds() + " segundos");
            writer.write("\n\n");

            writer.write("Tipo de reunión: " + reunion.getTipoReunion());
            writer.write("\n\n");

            writer.write("Modalidad: ");
            if (reunion instanceof ReunionVirtual) {
                writer.write("Virtual");
            } else if (reunion instanceof ReunionPresencial) {
                writer.write("Presencial");
            }
            writer.write("\n\n");

            writer.write("Enlace o sala: ");
            if (reunion instanceof ReunionVirtual) {
                writer.write(((ReunionVirtual) reunion).getEnlace());
            } else if (reunion instanceof ReunionPresencial) {
                writer.write(((ReunionPresencial) reunion).getSala());
            }
            writer.write("\n\n");

            writer.write("Lista de participantes:\n");
            List<Asistencia> empleadosAsistentes = reunion.getAsistencias();
            for (Asistencia asistencia : empleadosAsistentes) {
                if (asistencia.getAsistio()) {
                    Empleado empleado = asistencia.getEmpleado();
                    writer.write(" - Nombre : " + empleado.getNombre() + "   Apellido : " + empleado.getApellido() + "   Correo : " +empleado.getCorreo() + "   Departamento : " +empleado.getDepartamento() +"\n");
                }
            }
            writer.write("\n");

            writer.write("Lista de retrasos\n");

            List<Empleado> retrasados = reunion.obtenerRetrasos();

            for (Empleado empleado : retrasados) {
                for (Asistencia asistencia : reunion.getAsistencias()) {
                    if (asistencia instanceof Retraso && asistencia.getEmpleado().equals(empleado)) {
                        Retraso retraso = (Retraso) asistencia;
                        long horas2 = retraso.getDuracionRetraso().toHoursPart();
                        long minutos2 = retraso.getDuracionRetraso().toMinutesPart();
                        long segundos2 = retraso.getDuracionRetraso().toSecondsPart();
                        long minutoss = retraso.getDuracionRetraso().toMinutes();
                        long segundoss = retraso.getDuracionRetraso().toSeconds();

                        if (segundoss < 60) {
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellido() + " se ha retrasado " + segundos2 +" segundos\n");
                        } else if (minutoss < 60){
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellido() + " se ha retrasado " + minutos2 +" minutos " + segundos2 +" segundos\n");
                        } else {
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellido() + " se ha retrasado " + horas2 + " horas " + minutos2 +" minutos " + segundos2 +" segundos\n");

                        }
                        break;
                    }
                }
            }

            writer.write("\n");

            writer.write("Lista de  ausentes\n");
            List<Empleado> empleadosAusentes = reunion.obtenerAusencias();
            for (Empleado empleado : empleadosAusentes) {
                writer.write(" - Nombre : " + empleado.getNombre() + "   Apellido : " + empleado.getApellido() + "   Correo : " +empleado.getCorreo() + "   Departamento : " +empleado.getDepartamento() +"\n");
            }
            writer.write("\n\n");


            writer.write("Notas:\n");
            for (Nota nota : reunion.getNotas()) {
                writer.write(" - " + nota.getContenido() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
