package projetpoo_agence_voyage.model;

public class Hotel extends Destination implements Prix{
    private String nom;
    private int nbEtoiles;
    private boolean piscine;
    private double prixChambre;

    public Hotel(String nom, int nbEtoiles, boolean piscine, String lieu, String continent){
        super(lieu, continent);
        this.nom = nom;
        this.nbEtoiles = nbEtoiles;
        this.piscine = piscine;
        this.prixChambre = 30;
    }
    @Override
    public void CalculPrix(){
        this.prixChambre *= nbEtoiles;
        if (this.piscine){
            this.prixChambre += 10;
        }
    }


    //getter et setter
    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public double getPrixChambre() {

        return prixChambre;
    }

    public void setPrixChambre(double prixChambre) {

        this.prixChambre = prixChambre;
    }

    public boolean isPiscine() {

        return piscine;
    }

    public void setPiscine(boolean piscine) {

        this.piscine = piscine;
    }

    public int getNbEtoiles() {

        return nbEtoiles;
    }

    public void setNbEtoiles(int nbEtoiles) {

        this.nbEtoiles = nbEtoiles;
    }
}
