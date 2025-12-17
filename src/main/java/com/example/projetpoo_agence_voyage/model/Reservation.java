package com.example.projetpoo_agence_voyage.model;

public class Reservation {
    private double prixTotal;
    private double nbPersonne;

    public Reservation(double nbPersonne){
        this.prixTotal = 0;
        this.nbPersonne = nbPersonne;
    }


    public void CalculPrixTotal(Hotel hotel, Vol vol, Sejour sejour){
        this.prixTotal += hotel.getPrixChambre()* sejour.getDuree() + vol.getPrixPassager();
    }

    public void CalculPrixTotal(Hotel hotel, Vol vol, Circuit circuit){
        this.prixTotal += hotel.getPrixChambre()* circuit.getDuree() + vol.getPrixPassager();
    }


    public void AffichageReservation(Client client){
        IO.println("La réservation pour " + client.getNom()+ ", avec" + this.nbPersonne + " personne(s) à bien été effectuer !");
    }

    //Getter et setter
    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(double nbPersonne) {
        this.nbPersonne = nbPersonne;
    }
}
