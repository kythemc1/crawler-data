package com.example.oop.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneUtils {
    public void changeScene(ActionEvent event, String viewSource) throws IOException {
        Stage stage = null;
        Scene scene= null;
        Parent root= null;
        URL fxmlLocation = getClass().getResource(viewSource);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
