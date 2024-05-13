package org.example;

class Asistencia {
    private org.example.Empleado empleado;
    private boolean asistio;

    public Asistencia(org.example.Empleado empleado, boolean asistio) {
        this.empleado = empleado;
        this.asistio = asistio;
    }


    public org.example.Empleado getEmpleado() {
        return empleado;
    }

    public boolean getAsistio() {
        return asistio;
    }
}