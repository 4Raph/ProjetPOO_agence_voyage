package projetpoo_agence_voyage.model;

public class Reservation {
    private double prixTotal;
    private double nbPersonne;

    public Reservation(double nbPersonne){
        this.prixTotal = 0;
        this.nbPersonne = nbPersonne;
    }


    public void calculPrixTotal(Voyage voyage){
        double prixSeul = voyage.calculerPrix();
        this.prixTotal = prixSeul * nbPersonne;
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
