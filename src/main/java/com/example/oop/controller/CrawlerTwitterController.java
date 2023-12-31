package com.example.oop.controller;

import com.example.oop.model.ModelTwitter;
import com.example.oop.service.CrawlerTwitter;
import com.example.oop.utils.SceneUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CrawlerTwitterController implements Initializable {
    @FXML
    private Label json;

    SceneUtils sceneUtils =new SceneUtils();
    @FXML
    void buttonBack(ActionEvent event)throws IOException{

        sceneUtils.changeScene(event, "/home-page.fxml");
    }

    @FXML
    void onTwitterButtonClick(ActionEvent event) throws IOException {
        CrawlerTwitter crawlerTwitter=new CrawlerTwitter();
        List<ModelTwitter> list = crawlerTwitter.CrawlerTwitter();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(list);

        // In chuỗi JSON ra màn hình
        System.out.println(json);

        json.setText(jsonLog);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
