module com.example.oop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.jsoup;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires org.json;

    opens com.example.oop to javafx.fxml;
    exports com.example.oop;
    exports com.example.oop.controller;
    exports com.example.oop.model;
    opens com.example.oop.controller to javafx.fxml;
    opens com.example.oop.model to com.google.gson;
}