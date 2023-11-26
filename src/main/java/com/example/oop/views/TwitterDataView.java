package com.example.oop.views;

import com.example.oop.controller.CrawlerTwitterController;
import com.example.oop.service.CrawlerTwitter;

import java.io.IOException;
import java.net.URL;

public class TwitterDataView extends BaseView {
    private static final URL PATH = TwitterDataView.class.getResource("/com/example/oop/crawler-twitter.fxml");


    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public TwitterDataView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }
}
