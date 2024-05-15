package org.example;

/**
 * La clase Nota representa una nota con un contenido textual.
 */
public class Nota {
    private String contenido;

    /**
     * Constructor de la clase Nota.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve una representación en cadena del objeto Nota.
     *
     * @return Una cadena que representa la nota.
     */
    @Override
    public String toString() {
        return "Nota{" +
                "contenido='" + contenido + '\'' +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la nota.
     *
     * @param contenido El contenido a establecer.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

