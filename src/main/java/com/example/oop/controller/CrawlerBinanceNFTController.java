package com.example.oop.controller;

import com.example.oop.model.ModelBinanceNFT;
import com.example.oop.service.CrawlerBinanceNFT;
import com.example.oop.utils.SceneUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class CrawlerBinanceNFTController {
    @FXML
    private Label json;
    SceneUtils sceneUtils =new SceneUtils();
    @FXML
    void buttonBack(ActionEvent event)throws IOException{

        sceneUtils.changeScene(event, "/home-page.fxml");
    }
    @FXML
    void onBinanceNFTButtonClick(ActionEvent event) throws IOException {
        CrawlerBinanceNFT callAPIBinance=new CrawlerBinanceNFT();
        List<ModelBinanceNFT> list = callAPIBinance.getPost();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(list);

        // In chuỗi JSON ra màn hình
        System.out.println(json);

        json.setText(jsonLog);
    }
}
