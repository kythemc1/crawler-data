package com.example.oop.controller;

import com.example.oop.service.CrawlerTwitter;
import com.example.oop.views.TwitterDataView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.example.oop.utils.SceneUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

public class HomePageController {
    @FXML
    private Button buttonTwitter;
    SceneUtils sceneUtils =new SceneUtils();

    @FXML
    void onTwitterButtonClick(ActionEvent event) throws IOException {
        CrawlerTwitter crawlerTwitter=new CrawlerTwitter();
        crawlerTwitter.CrawlerTwitterTest();

        Stage stage = (Stage) this.buttonTwitter.getScene().getWindow();
        TwitterDataView view = new TwitterDataView();
        view.apply(stage);

        CrawlerTwitterController controller = view.getController();
        controller.setData(Collections.emptyList());

    }
    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-blog.fxml");    }

    @FXML
    void onOpenseaButtonClick(ActionEvent event) throws IOException {
        sceneUtils.changeScene(event,"/crawler-opensea.fxml");    }

}
