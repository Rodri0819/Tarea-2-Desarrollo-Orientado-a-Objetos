package org.example;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(String enlace){
        this.enlace = enlace;
    }

    //Getters

    public String getEnlace() {
        return enlace;
    }

    //Setters

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
