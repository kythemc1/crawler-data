package com.example.oop.views;

import java.io.IOException;
import java.net.URL;

public class HomePageView extends BaseView{
    private static final URL PATH = HomePageView.class.getResource("/com/example/oop/home-page.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public HomePageView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }
}
