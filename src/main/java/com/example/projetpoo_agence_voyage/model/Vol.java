package com.example.projetpoo_agence_voyage.model;

public class Vol implements Prix{
    private String typeClasse;
    private double prixPassager;

    public Vol(String typeClasse, double prixPassager){
        this.typeClasse = typeClasse;
        this.prixPassager = prixPassager;
    }


    @Override
    public void CalculPrix() {

    }


    public String getTypeClasse() {
        return typeClasse;
    }

    public void setTypeClasse(String typeClasse) {
        this.typeClasse = typeClasse;
    }

    public double getPrixPassager() {
        return prixPassager;
    }

    public void setPrixPassager(double prixPassager) {
        this.prixPassager = prixPassager;
    }


}
