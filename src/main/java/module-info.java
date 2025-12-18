module com.example.projetpoo_agence_voyage {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.sctp;


    opens projetpoo_agence_voyage.controller to javafx.fxml;
    exports projetpoo_agence_voyage.controller;
    exports projetpoo_agence_voyage.view;
    opens projetpoo_agence_voyage.view to javafx.fxml;
}