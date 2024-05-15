package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Departamento representa un departamento dentro de una empresa, con un nombre y una lista de empleados.
 */
public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;

    /**
     * Constructor de la clase Departamento.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Obtiene la cantidad de empleados en el departamento.
     *
     * @return La cantidad de empleados.
     */
    public int obtenerCantidadEmpleados() {
        int cantidadEmpleados = 0; // Inicializamos el contador fuera del bucle
        for (Empleado empleado : empleados) { // Para cada Empleado en la lista empleados
            cantidadEmpleados++; // Incrementamos el contador por cada empleado encontrado
        }
        return cantidadEmpleados;
    }

    /**
     * Agrega un empleado al departamento y asigna el nombre del departamento al empleado.
     *
     * @param empleado El empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleado.setDepartamento(this.nombre); // Asigna el departamento al empleado
        empleados.add(empleado);
    }

    /**
     * Envía una invitación a una reunión a todos los empleados del departamento.
     *
     * @param reunion La reunión a la que se invita.
     */
    @Override
    public void invitar(Reunion reunion) {
        System.out.println("Enviando invitación al departamento " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }

    /**
     * Devuelve una representación en cadena del objeto Departamento.
     *
     * @return Una cadena que representa el departamento.
     */
    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados del departamento.
     *
     * @param empleados La lista de empleados a establecer.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}