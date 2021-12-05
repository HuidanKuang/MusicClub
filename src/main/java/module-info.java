module com.example.musicclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.musicclub to javafx.fxml,com.google.gson;
    exports com.example.musicclub;
    exports com.example.musicclub.Controllers;
    opens com.example.musicclub.Controllers to com.google.gson, javafx.fxml;
    exports com.example.musicclub.Models;
    opens com.example.musicclub.Models to com.google.gson, javafx.fxml;
}