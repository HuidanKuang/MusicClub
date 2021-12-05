module com.example.musicclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.musicclub to javafx.fxml,com.google.gson;
    exports com.example.musicclub;
}