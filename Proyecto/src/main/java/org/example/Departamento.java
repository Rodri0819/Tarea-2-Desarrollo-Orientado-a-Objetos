package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;

    public  Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();

    }
    public int obtenerCantidadEmpleados() {
        int cantidadEmpleados = 0; // Inicializamos el contador fuera del bucle
        for (Empleado empleado : empleados) { // Para cada Empleado en la lista empleados
                cantidadEmpleados++; // Incrementamos el contador por cada empleado encontrado
            }
            return cantidadEmpleados;
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    @Override
    public void invitar(Reunion reunion) {
        System.out.println("Enviando invitación al departamento " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }
}