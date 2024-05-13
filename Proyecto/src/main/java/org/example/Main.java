package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Autores
 *
 * @author ChatGPT
 *
 */
public class Main {
    public static void main(String[] args) {
        // Configuración inicial y creación de la reunión
        Departamento desarrollo = new Departamento("Desarrollo");
        Empleado rodrigo = new Empleado("777", "Bascuñán", "Rodrigo", "rbascunan2023@udec.cl");
        Empleado martin = new Empleado("555", "Fuentealba", "Martin", "mfuentealba2023@udec.cl");
        Empleado tomas = new Empleado("666", "Gutierrez", "Tomas", "tgutierrez2023@udec.cl");

        desarrollo.agregarEmpleado(rodrigo);
        desarrollo.agregarEmpleado(martin);
        desarrollo.agregarEmpleado(tomas);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);

        ReunionVirtual reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, rodrigo, tipoReunion.TECNICA, "https://meet.example.com/join/12345");

        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala de Conferencias 101", fecha, horaPrevista, duracionPrevista, rodrigo, tipoReunion.TECNICA);

        // Agregar participantes y marcar asistencias
        reunionVirtual.agregarParticipante(rodrigo);
        reunionVirtual.agregarParticipante(martin);
        reunionVirtual.agregarParticipante(tomas);

        // Asumiendo que estás marcando la asistencia así:
        reunionVirtual.marcarAsistencia(rodrigo);
        reunionVirtual.marcarAsistencia(martin);
        //reunionVirtual.marcarAsistencia(martin);

        // Inicio de la reunión
        reunionVirtual.iniciar();  // Registra el momento de inicio

        // Simulación de la duración de la reunión
        try {
            Thread.sleep(6000);  // Simula que la reunión dura 6000 milisegundos (6 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Finalización de la reunión
        reunionVirtual.finalizar();  // Registra el momento de finalización


        System.out.println("Total participantes: " + reunionVirtual.getParticipantes().size());
        System.out.println("Total asistencias marcadas: " + reunionVirtual.totalAsistencias());

        // Mostrar resultados
        System.out.println("Duración Real: " + reunionVirtual.calcularTiempoReal().getSeconds() + " segundos");
        System.out.println("Porcentaje de Asistencia: " + reunionVirtual.obtenerPorcentajeAsistencia() + "%");

        List<Empleado> empleadosAusentes = reunionVirtual.obtenerAusencias();
        System.out.println("Empleados ausentes:");
        for (Empleado empleado : empleadosAusentes) {
            System.out.println(empleado.getNombre());
        }
    }

}
