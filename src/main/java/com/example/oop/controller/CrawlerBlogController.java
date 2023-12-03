package com.example.oop.controller;

import com.example.oop.model.ModelBlog;
import com.example.oop.service.CrawlerBlog;
import com.example.oop.views.HomeView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CrawlerBlogController {
    @FXML
    private Label json;

    @FXML
    void buttonBack(ActionEvent event) throws IOException {
        ((Stage) json.getScene().getWindow()).setScene(new HomeView().getScene());
    }

    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        CrawlerBlog crawlerBlog = new CrawlerBlog();
        List<ModelBlog> list = crawlerBlog.CrawlerBlog();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(list);

        // In chuỗi JSON ra màn hình
        System.out.println(json);

        json.setText(jsonLog);
    }
}
