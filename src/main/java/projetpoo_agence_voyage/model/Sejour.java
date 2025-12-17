package projetpoo_agence_voyage.model;

public class Sejour extends Voyage{


    public Sejour(int duree, Hotel hotel, Vol vol) {
        super(duree, hotel, vol);
    }

    @Override
    public double calculerPrix() {
        getHotel().CalculPrix();
        getVol().CalculPrix();
        return getHotel().getPrixChambre() * getDuree() + getVol().getPrixPassager();
    }

}
