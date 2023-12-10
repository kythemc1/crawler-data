package com.example.oop.views;

import com.example.oop.controller.BlogController;

import java.io.IOException;
import java.net.URL;

public class BlogView extends BaseView {
    private static final URL PATH = BlogView.class.getResource("/fxml/crawler-blog.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public BlogView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }

    public BlogController getController() {
        return (BlogController)super.getController();
    }
}
