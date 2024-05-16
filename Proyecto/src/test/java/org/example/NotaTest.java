package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    public void testSetAndGetContenido() {
        String contenido = "Este es un contenido de prueba";
        Nota nota = new Nota(contenido);
        assertEquals(contenido, nota.getContenido(), "El contenido recuperado debe coincidir con el contenido asignado");

        String nuevoContenido = "Nuevo contenido de prueba";
        nota.setContenido(nuevoContenido);
        assertEquals(nuevoContenido, nota.getContenido()); //El contenido debería haber sido actualizado
    }

    @Test
    public void testToString() {
        String contenido = "Prueba de contenido para toString";
        Nota nota = new Nota(contenido);
        String expectedToString = "Nota{contenido='" + contenido + "'}";
        assertEquals(expectedToString, nota.toString()); //El método toString debe devolver el formato correcto
    }
}
