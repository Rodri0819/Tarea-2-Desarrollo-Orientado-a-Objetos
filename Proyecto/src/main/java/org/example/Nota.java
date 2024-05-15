package org.example;

public class Nota {
    private String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }

    //toString
    @Override
    public String toString() {
        return "Nota{" +
                "contenido='" + contenido + '\'' +
                '}';
    }

    //Getters y Setters
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

