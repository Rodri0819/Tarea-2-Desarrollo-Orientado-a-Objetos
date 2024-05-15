package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * La clase Informe genera un informe sobre una reunión y lo guarda en un archivo especificado.
 */
public class Informe {
    private Reunion reunion;
    private String nombreArchivo;

    /**
     * Constructor de la clase Informe.
     *
     * @param reunion       La reunión sobre la que se generará el informe.
     * @param nombreArchivo El nombre del archivo donde se guardará el informe.
     */
    public Informe(Reunion reunion, String nombreArchivo) {
        this.reunion = reunion;
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Genera el informe de la reunión y lo escribe en el archivo especificado.
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

            long horas = reunion.getDuracionPrevista().toHours();
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
                    writer.write(" - " + empleado.getNombre() + " " + empleado.getApellido() + "\n");
                }
            }
            writer.write("\n");

            writer.write("Notas:\n");
            for (Nota nota : reunion.getNotas()) {
                writer.write(" - " + nota.getContenido() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
