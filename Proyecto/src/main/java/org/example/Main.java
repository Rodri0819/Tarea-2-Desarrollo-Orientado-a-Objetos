package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configuracion inicial de la reunion y empleados
        Departamento desarrollo = new Departamento("Desarrollo");
        Empleado rodrigo = new Empleado("777", "Bascuñán", "Rodrigo", "rbascunan2023@udec.cl");
        Empleado martin = new Empleado("555", "Fuentealba", "Martin", "mfuentealba2023@udec.cl");
        Empleado tomas = new Empleado("666", "Gutierrez", "Tomas", "tgutierrez2023@udec.cl");

        desarrollo.agregarEmpleado(rodrigo);
        desarrollo.agregarEmpleado(martin);
        desarrollo.agregarEmpleado(tomas);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(110);


        ReunionVirtual reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, rodrigo, tipoReunion.TECNICA, "https://meet.google.com/join/12345");
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, rodrigo, tipoReunion.MARKETING, "Sala A401");

        //Agregar participantes de desarrollo (Además envia la invitación)
        //reunionVirtual.agregarParticipante(desarrollo);
        reunionPresencial.agregarParticipante(desarrollo);
        //Notas agregadas
        reunionVirtual.agregarNota("Por favor marcar asistencia.");
        reunionPresencial.agregarNota("Avisar a los que no asistieron sobre la reunión.");

        //Reunion iniciada
        reunionPresencial.iniciar();


        reunionPresencial.marcarAsistencia(martin, Instant.now()); // Martín llega a tiempo
        reunionPresencial.marcarAsistencia(rodrigo, Instant.now().plusSeconds(10)); // Rodrigo llega 10s tarde
        //reunionVirtual.marcarAsistencia(tomas, Instant.now()); // tomas llega a tiempo

        try {

            Thread.sleep(10*1000);  // Simula una duración de 10 segundos para la reunión
            // Marcar asistencia
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La simulación de la reunión fue interrumpida");
        }
        reunionPresencial.listarNotas();

        //Reunion finalizada
        reunionPresencial.finalizar();
       

        // Generar el informe
        Informe informe = new Informe(reunionPresencial, "informe_reunion.txt");
        informe.generarInforme();
    }
}
