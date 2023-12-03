package com.example.oop.views;

import com.example.oop.controller.BinanceNFTController;

import java.io.IOException;
import java.net.URL;

public class BinanceView extends BaseView {
    private static final URL PATH = BinanceView.class.getResource("/fxml/crawler-binance-nft.fxml");

    /**
     * prepare a new scene
     *
     * @throws IOException          if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public BinanceView() throws IOException {
        super();
    }

    @Override
    protected URL getSceneURL() throws NullPointerException {
        return PATH;
    }

    public BinanceNFTController getController() {
        return super.getUnknownController();
    }
}
