module com.example.projetpoo_agence_voyage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetpoo_agence_voyage to javafx.fxml;
    exports com.example.projetpoo_agence_voyage;
}