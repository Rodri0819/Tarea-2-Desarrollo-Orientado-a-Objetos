    package org.example;

    import java.time.Duration;
    import java.time.Instant;
    import java.util.Date;

    public class Main {
        public static void main(String[] args) {

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

            reunionVirtual.agregarParticipante(desarrollo);

        }
    }
