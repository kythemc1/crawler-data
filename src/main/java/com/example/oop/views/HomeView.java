package com.example.oop.views;

import com.example.oop.controller.HomePageController;

import java.io.IOException;
import java.net.URL;

public class HomeView extends BaseView{
    private static final URL PATH = HomeView.class.getResource("/fxml/home-page.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public HomeView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }

    public HomePageController getController() {
        return (HomePageController)super.getController();
    }
}
