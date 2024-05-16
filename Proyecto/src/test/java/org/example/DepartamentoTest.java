package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {
    @DisplayName("Testeos metodos")
    @Test
    public void test1() {
        Departamento departamento1 = new Departamento("Desarrollo");
        assertEquals("Desarrollo", departamento1.getNombre()); //Desarrollo es el nombre de departamento 1
        assertTrue(departamento1.getEmpleados().isEmpty()); //Lista de empleados del departamento 1 vacia
        Empleado Mario = new Empleado("33", "Jose", "Mario", "aaa@gmail.com");
        departamento1.agregarEmpleado(Mario);//Metodo agregar empleado
        assertFalse((departamento1.getEmpleados().isEmpty())); // Empleado agregado
        assertEquals(1,departamento1.obtenerCantidadEmpleados());
        Empleado Rodrigo = new Empleado("23", "añañin  ", "Rodrigo", "aaa1@gmail.com");
        departamento1.agregarEmpleado(Rodrigo);
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        ReunionVirtual reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, Rodrigo, tipoReunion.TECNICA, "https://meet.example.com/join/12345");
        departamento1.invitar(reunionVirtual);
    }
}
