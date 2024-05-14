package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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

        // Agregar participantes
        reunionVirtual.agregarParticipante(rodrigo);
        reunionVirtual.agregarParticipante(martin);
        reunionVirtual.agregarParticipante(tomas);


        reunionVirtual.agregarNota("Por favor marcar asistencia.");
        reunionVirtual.agregarNota("Avisar a los que no asistieron sobre la reunión.");


        // Inicio de la reunión
        reunionVirtual.iniciar();
        reunionVirtual.listarNotas();


        reunionVirtual.marcarAsistencia(martin, Instant.now()); // Martín llega a tiempo
        reunionVirtual.marcarAsistencia(rodrigo, Instant.now().plusSeconds(5)); // Rodrigo llega 5 minutos tarde

        try {

            Thread.sleep(10*1000);  // Simula una duración de 10 segundos para la reunión
            // Marcar asistencia
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La simulación de la reunión fue interrumpida");
        }


        // Finalización de la reunión
        reunionVirtual.finalizar();

        // Mostrar resultados generales
        System.out.println("Total participantes: " + reunionVirtual.getParticipantes().size());
        System.out.println("Total asistencias marcadas: " + reunionVirtual.totalAsistencias());
        System.out.println("Duración Real: " + reunionVirtual.calcularTiempoReal().getSeconds() + " segundos");
        System.out.println("Porcentaje de Asistencia: " + reunionVirtual.obtenerPorcentajeAsistencia() + "%");

        // Mostrar empleados ausentes
        List<Empleado> empleadosAusentes = reunionVirtual.obtenerAusencias();
        System.out.println("Empleados ausentes:");
        for (Empleado empleado : empleadosAusentes) {
            System.out.println(empleado.getNombre());
        }

        // Mostrar empleados asistentes
        List<Asistencia> empleadosAsistentes = reunionVirtual.getAsistencias();
        System.out.println("Empleados asistentes:");
        for (Asistencia asistencia : empleadosAsistentes) {
            if (asistencia.getAsistio()) {  // Asegúrate de imprimir solo los que realmente asistieron
                Empleado empleado = asistencia.getEmpleado();  // Obtiene el empleado asociado a la asistencia
                System.out.println(empleado.getNombre() + " " + empleado.getApellido());  // Imprime el nombre completo del empleado
            }
        }


        // Mostrar retrasos
        System.out.println("Empleados retrasados:");
        List<Empleado> detallesRetrasos = reunionVirtual.obtenerRetrasos();
        for (Empleado detalle : detallesRetrasos) {
            System.out.println(detalle);
        }
    }
}
