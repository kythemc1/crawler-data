package com.example.oop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.example.oop.utils.SceneUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Button buttonTwitter;

    @FXML
    private Button buttonBlogs;

    @FXML
    private Button buttonBinanceNFT;
    SceneUtils sceneUtils =new SceneUtils();

    @FXML
    private Label label;

    public HomePageController() throws IOException {
    }

    @FXML
    void onTwitterButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-twitter.fxml");
//        label.setText("" );
    }
    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-blog.fxml");
    }

    @FXML
    void onBinanceNFTButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event, "/crawler-binance-nft.fxml");
    }
}
