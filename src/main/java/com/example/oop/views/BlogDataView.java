package com.example.oop.views;

import java.io.IOException;
import java.net.URL;

public class BlogDataView extends BaseView {
    private static final URL PATH = BlogDataView.class.getResource("/com/example/oop/crawler-blog.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public BlogDataView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }
}
