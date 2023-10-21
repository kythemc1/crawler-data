module com.example.oop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.jsoup;

    opens com.example.oop to javafx.fxml;
    exports com.example.oop;
    exports com.example.oop.controller;
    opens com.example.oop.controller to javafx.fxml;
}