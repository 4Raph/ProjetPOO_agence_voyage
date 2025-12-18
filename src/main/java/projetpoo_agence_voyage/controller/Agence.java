package projetpoo_agence_voyage.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListCell;
import projetpoo_agence_voyage.model.*;

import java.util.ArrayList;
import java.util.List;

public class Agence {

    @FXML private TextField nomClientField;
    @FXML private TextField nbPersonnesField;
    @FXML private TextField nbJours;
    @FXML private RadioButton rbSejour;
    @FXML private RadioButton rbCircuit;
    @FXML private CheckBox cbPiscine;
    @FXML private ComboBox<Integer> cbEtoiles;
    @FXML private ComboBox<String> cbContinent;
    @FXML private ComboBox<String> cbTypeVol;
    @FXML private ListView<Hotel> listeHotels;
    @FXML private Label resultLabel;
    @FXML private ListView<String> listeClients;

    private final List<Client> clients = new ArrayList<>();
    private final List<Hotel> tousLesHotels = new ArrayList<>();


    private void viderFormulaire() {
        nomClientField.clear();
        nbPersonnesField.clear();
        nbJours.clear();
        rbSejour.setSelected(true);
        cbPiscine.setSelected(false);
        cbEtoiles.getSelectionModel().clearSelection();
        cbContinent.getSelectionModel().clearSelection();
        cbTypeVol.getSelectionModel().clearSelection();
        listeHotels.getItems().clear();
    }

    @FXML
    public void initialize() {
        cbEtoiles.getItems().addAll(0, 3, 5);
        cbContinent.getItems().addAll("Europe", "Amerique", "Asie", "Afrique");
        cbTypeVol.getItems().addAll("Economie", "Premiere", "Business");

        construireHotels();

        listeHotels.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Hotel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNom() + " - " + item.getLieu()
                            + " (" + item.getNbEtoiles() + " étoiles ☆ , piscine: "
                            + (item.isPiscine() ? "oui" : "non") + ", "
                            + item.getContinent() + ")");
                }
            }
        });
    }

    private void construireHotels() {
        // Europe
        tousLesHotels.add(new Hotel("Hotel du Louvre", 5, false, "Paris, France", "Europe"));
        tousLesHotels.add(new Hotel("Hotel Delle Civette", 3, true, "Rome, Italie", "Europe"));
        tousLesHotels.add(new Hotel("Storfjord Hotel", 0, false, "Skodje, Norvège", "Europe"));

        // Amérique
        tousLesHotels.add(new Hotel("The New York EDITION", 5, true, "New York, États Unis", "Amerique"));
        tousLesHotels.add(new Hotel("Mayan Monkey Hostel Tulum", 3, true, "Mexico, Mexique", "Amerique"));
        tousLesHotels.add(new Hotel("Samesun Toronto", 0, false, "Toronto, Canada", "Amerique"));

        // Asie
        tousLesHotels.add(new Hotel("The St. Regis Hong Kong", 5, true, "Hong Kong, Chine", "Asie"));
        tousLesHotels.add(new Hotel("Qnz Hotel", 3, true, "Jakarta, Indonésie", "Asie"));
        tousLesHotels.add(new Hotel("APA Hotel Higashi Shinjuku Kabukicho Tower", 0, true, "Tokyo, Japon", "Asie"));

        // Afrique
        tousLesHotels.add(new Hotel("Hotel Riu Palace Tikida", 5, true, "Agadir, Maroc", "Afrique"));
        tousLesHotels.add(new Hotel("Fraaigelegen Farm", 3, false, "Tulbagh, Afrique du Sud", "Afrique"));
        tousLesHotels.add(new Hotel("The hotel Acacias", 0, true, "Tamatave, Madagascar", "Afrique"));
    }

    @FXML
    private void onChercherHotels() {
        listeHotels.getItems().clear();

        if (rbSejour.isSelected()) {
            Integer etoiles = cbEtoiles.getValue();
            boolean piscineVoulu = cbPiscine.isSelected();

            for (Hotel h : tousLesHotels) {
                boolean okEtoiles = (etoiles == null) || h.getNbEtoiles() == etoiles;
                boolean okPiscine = !piscineVoulu || h.isPiscine();
                if (okEtoiles && okPiscine) {
                    listeHotels.getItems().add(h);
                }
            }
        } else if (rbCircuit.isSelected()) {
            String continent = cbContinent.getValue();
            if (continent == null) {
                resultLabel.setText("Choisis un continent pour le circuit");
                return;
            }
            for (Hotel h : tousLesHotels) {
                if (continent.equalsIgnoreCase(h.getContinent())) {
                    listeHotels.getItems().add(h);
                }
            }
        }

        if (listeHotels.getItems().isEmpty()) {
            resultLabel.setText("Aucun hôtel ne correspond aux critères");
        } else {
            resultLabel.setText("");
        }
    }

    @FXML
    private void onReserve() {
        try {
            String nom = nomClientField.getText();
            int nb = Integer.parseInt(nbPersonnesField.getText());
            int nbJ = Integer.parseInt(nbJours.getText());
            if (nom == null || nom.isBlank()) {
                resultLabel.setText("Entre un nom de client");
                return;
            }

            String typeVol = cbTypeVol.getValue();
            if (typeVol == null) {
                resultLabel.setText("Choisis un type de vol");
                return;
            }

            Vol vol = new Vol(typeVol, 200);
            Client client = new Client(nom);
            clients.add(client);

            Reservation reservation = new Reservation(nb);

            if (rbSejour.isSelected()) {
                Hotel hotelChoisi = listeHotels.getSelectionModel().getSelectedItem();
                if (hotelChoisi == null) {
                    resultLabel.setText("Choisis un hôtel pour le séjour");
                    return;
                }
                Sejour sejour = new Sejour(nbJ, hotelChoisi, vol);
                reservation.calculPrixTotal(sejour);
            } else if (rbCircuit.isSelected()) {
                String continent = cbContinent.getValue();
                if (continent == null) {
                    resultLabel.setText("Choisis un continent pour le circuit");
                    return;
                }

                Circuit circuit = new Circuit("Circuit " + continent);
                int max = Math.min(3, listeHotels.getItems().size());
                if (max == 0) {
                    resultLabel.setText("Aucun hôtel pour construire le circuit");
                    return;
                }
                for (int i = 0; i < max; i++) {
                    Hotel h = listeHotels.getItems().get(i);
                    circuit.ajouterEtape(new Sejour(3, h, vol));
                }
                reservation.calculPrixTotal(circuit);
            }

            listeClients.getItems().add(client.getNom()+ " - Prix total : " + reservation.getPrixTotal() + " €");

            resultLabel.setText("Client " + nom + " - Prix total : " + reservation.getPrixTotal() + " €");

            viderFormulaire();

        } catch (NumberFormatException e) {
            resultLabel.setText("Nombre de personnes invalide / durée invalide");
        }
    }
}
