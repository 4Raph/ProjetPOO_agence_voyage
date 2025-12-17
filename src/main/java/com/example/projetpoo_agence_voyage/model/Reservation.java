package com.example.projetpoo_agence_voyage.model;

public class Reservation {
    private double prixTotal;
    private double nbPersonne;

    public Reservation(double nbPersonne){
        this.prixTotal = 0;
        this.nbPersonne = nbPersonne;
    }


    public void CalculPrixTotal(Hotel hotel, Vol vol, Sejour sejour){
        this.prixTotal = this.prixTotal + (this.nbPersonne/2) * hotel.getPrixChambre() * sejour.getDuree();
        this.prixTotal = this.prixTotal + this.nbPersonne * vol.getPrixPassager();
        IO.println("Prix de votre réservation : " + this.prixTotal);
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
