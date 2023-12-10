package com.example.oop.controller;

import com.example.oop.model.ModelBlog;
import com.example.oop.model.ModelTwitter;
import com.example.oop.service.CrawlerBlog;
import com.example.oop.utils.SceneUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.util.List;

public class CrawlerBlogController {
    @FXML
    private Label json;
    SceneUtils sceneUtils =new SceneUtils();
   @FXML
   void buttonBack(ActionEvent event)throws IOException{

       sceneUtils.changeScene(event, "/home-page.fxml");
   }

    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        CrawlerBlog crawlerBlog=new CrawlerBlog();
        List<ModelBlog> list = crawlerBlog.CrawlerBlog();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(list);

        // In chuỗi JSON ra màn hình
        System.out.println(json);

        json.setText(jsonLog);
    }
}
