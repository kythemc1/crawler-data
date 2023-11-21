package com.example.oop;

import com.example.oop.model.ModelTwitter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class MainApplication extends Application {
    public static List<ModelTwitter> twitterPosts;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/oop/home-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NFT-Crawler!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}