package org.example;

public class Empleado {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado(String id, String apellido, String nombre, String correo){
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
    }
    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setId(String id) {
        this.id = id;
    }

}
