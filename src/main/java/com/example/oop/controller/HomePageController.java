package com.example.oop.controller;

import com.example.oop.service.CrawlerTwitter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.example.oop.utils.SceneUtils;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Button buttonTwitter;
    SceneUtils sceneUtils =new SceneUtils();

    @FXML
    void onTwitterButtonClick(ActionEvent event) throws IOException {
        CrawlerTwitter crawlerTwitter=new CrawlerTwitter();
        crawlerTwitter.CrawlerTwitterTest();
        sceneUtils.changeScene(event, "/com/example/oop/crawler-twitter.fxml");
    }
    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-blog.fxml");    }

    @FXML
    void onOpenseaButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-opensea.fxml");    }

}
