package projetpoo_agence_voyage.model;

public class Destination {
    private String lieu;
    private String continent;


    public Destination(String lieu, String continent){
        this.lieu = lieu;
        this.continent = continent;
    }

    //Getter et setter
    public String getLieu() {

        return lieu;
    }

    public void setLieu(String lieu) {

        this.lieu = lieu;
    }

    public String getContinent() {

        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

}
