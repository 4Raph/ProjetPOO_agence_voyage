package com.example.projetpoo_agence_voyage.model;

public class Circuit extends Voyage{
    private String nomCircuit;
    public Circuit(int duree, String nomCircuit) {
        super(duree);
        this.nomCircuit = nomCircuit;
    }

    //getter et setter
    public String getNomCircuit() {
        return nomCircuit;
    }

    public void setNomCircuit(String nomCircuit) {
        this.nomCircuit = nomCircuit;
    }
}
