package projetpoo_agence_voyage.model;

public abstract class Voyage {
    private int duree;
    private Hotel hotel;
    private Vol vol;

    public Voyage(int duree, Hotel hotel, Vol vol){
        this.duree = duree;
        this.vol = vol;
        this.hotel = hotel;
    }

    public abstract double calculerPrix();

    //getter et setter
    public int getDuree() {

        return duree;
    }

    public void setDuree(int duree) {

        this.duree = duree;
    }

    public Hotel getHotel() {

        return hotel;
    }

    public void setHotel(Hotel hotel) {

        this.hotel = hotel;
    }

    public Vol getVol() {

        return vol;
    }

    public void setVol(Vol vol) {

        this.vol = vol;
    }
}
