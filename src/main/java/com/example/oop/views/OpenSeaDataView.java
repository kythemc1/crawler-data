package com.example.oop.views;

import java.io.IOException;
import java.net.URL;

public class OpenSeaDataView extends BaseView {
    private static final URL PATH = OpenSeaDataView.class.getResource("/com/example/oop/crawler-opensea.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public OpenSeaDataView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }
}
