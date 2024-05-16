package org.example;

/**
 * La clase Empleado representa un empleado dentro de una empresa, con detalles como ID, apellido, nombre, correo y departamento.
 */
class Empleado implements Invitable {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;
    private String departamento;

    /**
     * Constructor de la clase Empleado.
     *
     * @param id       El ID del empleado.
     * @param apellido El apellido del empleado.
     * @param nombre   El nombre del empleado.
     * @param correo   El correo electrónico del empleado.
     */
    public Empleado(String id, String apellido, String nombre, String correo) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = null;
    }

    /**
     * Envía una invitación a una reunión al empleado.
     *
     * @param reunion La reunión a la que se invita.
     */
    @Override
    public void invitar(Reunion reunion) {
        // Define el mensaje base
        String mensaje = "Estimado " + nombre + " " + apellido + ", está invitado a una reunión ";

        if (reunion instanceof ReunionVirtual) { // Si es virtual
            mensaje = mensaje + "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace(); //Se añade el enlace al mensaje
        } else if (reunion instanceof ReunionPresencial) { // Si es presencial
            mensaje = mensaje + "presencial en la sala: " + ((ReunionPresencial) reunion).getSala(); //Se añade la dirección de la sala al mensaje
        }

        // Imprime el mensaje
        System.out.println("Invitación enviada a " + nombre + " via email: " + correo + " con detalles: " + mensaje);

    }

    /**
     * ToString Empleado
     *
     * @return Una cadena que representa el empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", departamento=" + departamento +
                '}';
    }

    // Getters y Setters

    /**
     * Obtiene el ID del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id El ID a establecer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el apellido del empleado.
     *
     * @return El apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del empleado.
     *
     * @param apellido El apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return El correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo El correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el departamento del empleado.
     *
     * @return El departamento del empleado.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del empleado.
     *
     * @param departamento El departamento a establecer.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
