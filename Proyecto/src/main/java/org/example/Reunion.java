package org.example;
import java.time.*;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private List<Asistencia> attendace;
    private List<Invitacion> invitation;
    private List<Nota> notas;
    private Empleado employeereunion;
    private tipoReunion typereunionreunion;

    public void obtenerAsistencias(){ //list

    }

    public void obtenerAusencias(){//list

    }

    public void obtenerRetrasos(){//list

    }

    public void totalAsistencias(){ //int

    }

    public void obtenerPorcentajeAsistencia(){ //float

    }

    public void calcularTiempoReal(){ //float

    }

    public void iniciar(){ //void

    }

    public void finalizar(){ //void

    }

    public Reunion(){

    }
}