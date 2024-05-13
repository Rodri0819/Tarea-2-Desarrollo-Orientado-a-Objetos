package org.example;

class Empleado implements Invitable {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;
    private Departamento departamento;

    public Empleado(String id, String apellido, String nombre, String correo) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getId() {
        return id;
    }


    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public void invitar(Reunion reunion) {
        // Define el mensaje base
        String mensaje = "Estimado " + nombre + " " + apellido + ", está invitado a una reunión ";

        if (reunion instanceof ReunionVirtual) { //Si es virtual
            mensaje += "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) { //Si es presencial
            mensaje += "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        }

        // Imprime el mensaje
        System.out.println("Invitación enviada a " + nombre + " via email: " + correo + " con detalles: " + mensaje);
    }


}