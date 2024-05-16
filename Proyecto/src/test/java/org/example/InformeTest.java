package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InformeTest {

    private Reunion reunion;
    private Informe informe;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Crear un archivo temporal para el test
        tempFile = Files.createTempFile(null, ".txt");
        // Setup de la reunión con datos necesarios
        reunion = new ReunionPresencial(new Date(), Instant.now(), Duration.ofHours(1), new Empleado("001", "Doe", "John", "johndoe@example.com"), tipoReunion.TECNICA, "Sala de Conferencias");
        informe = new Informe(reunion, tempFile.toString());
    }

    @Test
    void testGenerarInforme() throws IOException {
        // Ejecutar el método que genera el informe
        informe.generarInforme();

        // Leer el archivo
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        // Verificar que el contenido del informe contiene ciertos elementos esperados
        assertTrue(content.toString().contains("**Informe de Reunión**"));
        assertTrue(content.toString().contains("Fecha y hora de la reunión:"));
        assertTrue(content.toString().contains("Duración prevista:"));
        assertTrue(content.toString().contains("Tipo de reunión: TECNICA"));
        assertTrue(content.toString().contains("Modalidad: Presencial"));
        assertTrue(content.toString().contains("Sala de Conferencias"));

        // Borrar el archivo temporal
        Files.delete(tempFile);
    }
}