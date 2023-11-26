package com.example.oop;

import com.example.oop.model.ModelTwitter;
import com.example.oop.views.HomePageView;
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
        stage.setTitle("NFT-Crawler!");
        stage.show();
        HomePageView home = new HomePageView();
        home.apply(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}