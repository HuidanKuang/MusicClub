module com.example.musicclub {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.musicclub to javafx.fxml;
    exports com.example.musicclub;
}