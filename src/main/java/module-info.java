module com.example.projetpoo_agence_voyage {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.sctp;


    opens projetpoo_agence_voyage to javafx.fxml;
    exports projetpoo_agence_voyage;
}