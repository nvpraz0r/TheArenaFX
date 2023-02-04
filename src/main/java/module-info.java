module com.example.thearena {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thearena to javafx.fxml;
    exports com.example.thearena;
}