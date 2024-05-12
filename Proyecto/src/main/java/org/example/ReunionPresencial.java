package org.example;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(String sala){
        this.sala = sala;
    }

    //Getters

    public String getSala() {
        return sala;
    }
    //Seters

    public void setSala(String sala) {
        this.sala = sala;
    }
}
