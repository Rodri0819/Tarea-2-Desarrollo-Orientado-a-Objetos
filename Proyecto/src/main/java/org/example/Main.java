package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configuración inicial de la reunión y empleados
        Departamento desarrollo = new Departamento("Desarrollo");
        Empleado rodrigo = new Empleado("777", "Bascuñán", "Rodrigo", "rbascunan2023@udec.cl");
        Empleado martin = new Empleado("555", "Fuentealba", "Martin", "mfuentealba2023@udec.cl");
        Empleado tomas = new Empleado("666", "Gutierrez", "Tomas", "tgutierrez2023@udec.cl");

        desarrollo.agregarEmpleado(rodrigo);
        desarrollo.agregarEmpleado(martin); // Asegurándonos de agregar a Martín también, ya que se marca su asistencia.
        desarrollo.agregarEmpleado(tomas);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(110);

        // Crear una reunión presencial
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, rodrigo, tipoReunion.MARKETING, "Sala A401");

        // Agregar participantes y enviar invitación
        reunionPresencial.agregarParticipante(desarrollo);


        // Notas agregadas
        reunionPresencial.agregarNota("Avisar a los que no asistieron sobre la reunión.");

        // Iniciar la reunión presencial
        reunionPresencial.iniciar();

        // Marcar asistencia
        reunionPresencial.marcarAsistencia(martin, Instant.now()); // Martín llega a tiempo
        reunionPresencial.marcarAsistencia(rodrigo, Instant.now().plusSeconds(10)); // Rodrigo llega 10s tarde

        try {
            Thread.sleep(10 * 1000); // Simula una duración de 10 segundos para la reunión
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La simulación de la reunión fue interrumpida");
        }

        reunionPresencial.listarNotas();

        // Finalizar la reunión
        reunionPresencial.finalizar();

        // Generar informe
        Informe informe = new Informe(reunionPresencial, "informe_reunion.txt");
        informe.generarInforme();
    }
}
