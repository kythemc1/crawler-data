package com.example.oop.views;

import com.example.oop.controller.CrawlerTwitterController;

import java.io.IOException;
import java.net.URL;

public class TwitterView extends BaseView {
    private static final URL PATH = TwitterView.class.getResource("/fxml/crawler-twitter.fxml");


    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public TwitterView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }

    public CrawlerTwitterController getController() {
        return super.getUnknownController();
    }
}
