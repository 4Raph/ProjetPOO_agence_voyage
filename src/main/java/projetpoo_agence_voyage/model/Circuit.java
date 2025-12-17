package projetpoo_agence_voyage.model;

import java.util.ArrayList;
import java.util.List;

public class Circuit extends Voyage {

    private String nomCircuit;
    private List<Voyage> etapes = new ArrayList<>();

    public Circuit(String nomCircuit) {
        super(0, null, null);
        this.nomCircuit = nomCircuit;
    }

    public void ajouterEtape(Voyage v) {
        etapes.add(v);
        setDuree(getDuree() + v.getDuree());
    }

    public List<Voyage> getEtapes() {
        return etapes;
    }

    @Override
    public double calculerPrix() {
        double total = 0;
        for (Voyage v : etapes) {
            total += v.calculerPrix();
        }
        return total;
    }

    //getter et setter

    public String getNomCircuit() {
        return nomCircuit;
    }

    public void setNomCircuit(String nomCircuit) {
        this.nomCircuit = nomCircuit;
    }
}

