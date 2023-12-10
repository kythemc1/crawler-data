package com.example.oop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.example.oop.views.BinanceView;
import com.example.oop.views.BlogView;
import com.example.oop.views.TwitterView;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    private Button buttonTwitter;

    @FXML
    private Button buttonBlogs;

    @FXML
    private Button buttonBinanceNFT;

    public HomePageController() throws IOException {
    }

    @FXML
    void onTwitterButtonClick(ActionEvent event) throws IOException {
        var twitterView = new TwitterView();

        // change scene
        var stage = (Stage) buttonTwitter.getScene().getWindow();
        var scene = twitterView.getScene();
        stage.setScene(scene);
    }

    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        var twitterView = new BlogView();

        // change scene
        var stage = (Stage) buttonTwitter.getScene().getWindow();
        var scene = twitterView.getScene();
        stage.setScene(scene);
    }

    @FXML
    void onBinanceNFTButtonClick(ActionEvent event) throws IOException {
        var twitterView = new BinanceView();

        // change scene
        var stage = (Stage) buttonTwitter.getScene().getWindow();
        var scene = twitterView.getScene();
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buttonTwitter.prefWidthProperty().bind(this.buttonBinanceNFT.prefWidthProperty());
        this.buttonBlogs.prefWidthProperty().bind(this.buttonBinanceNFT.prefWidthProperty());
    }
}
