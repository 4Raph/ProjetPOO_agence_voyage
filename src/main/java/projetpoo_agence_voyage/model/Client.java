package projetpoo_agence_voyage.model;

public class Client {
    private String nom;
    private Reservation reservation;

    public Client(String nom){
        this.nom = nom;
    }






    //Getter et setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

