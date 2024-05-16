package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepartamentoTest {
    private Departamento departamento;
    private Empleado empleadoMock;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Desarrollo");
        empleadoMock = mock(Empleado.class); // Usamos Mockito para crear un mock de Empleado
        when(empleadoMock.getNombre()).thenReturn("Juan");
    }

    @Test
    void testAgregarEmpleado() {
        Empleado empleado1 = new Empleado("100", "Perez", "Juanito", "juanito@outlook.com");
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados()); //Debe haber solo un empleado
        assertTrue(departamento.getEmpleados().contains(empleado1)); //Departamento contiene al empleado
    }

    @Test
    void testInvitarTodosLosEmpleados() {
        Reunion reunionMock = mock(Reunion.class);
        departamento.agregarEmpleado(empleadoMock);
        departamento.invitar(reunionMock);
        verify(reunionMock, times(1)).agregarParticipante(empleadoMock);
    }

    @Test
    void testObtenerCantidadEmpleados() {
        assertEquals(0, departamento.obtenerCantidadEmpleados()); //Al empezar hay 0 empleados
        departamento.agregarEmpleado(empleadoMock);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testToString() {
        String expected = "Departamento{nombre='Desarrollo', empleados=[]}";
        assertEquals(expected, departamento.toString(), "El método toString no genera la cadena esperada");
    }
}
