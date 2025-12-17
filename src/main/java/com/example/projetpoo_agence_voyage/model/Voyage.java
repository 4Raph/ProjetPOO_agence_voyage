package com.example.projetpoo_agence_voyage.model;

public abstract class Voyage {
    private int duree;
    private Hotel hotel;
    private Vol vol;

    public Voyage(int duree){
        this.duree = duree;
    }


    //getter et setter
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
