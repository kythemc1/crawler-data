package com.example.oop.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;

public abstract class BaseView {
    protected Scene scene = null;
    protected final Parent root;
    protected final FXMLLoader loader;

    /**
     * prepare a new scene
     * @throws IOException if getSceneURL return null
     * @throws NullPointerException if cant find fxml file
     */
    public BaseView() throws IOException {
        this.loader = new FXMLLoader(this.getSceneURL());
        this.root = loader.load();
//        this.scene = new Scene(root);
    }

    protected abstract URL getSceneURL() throws NullPointerException;

    public Object getController() {
        return this.loader.getController();
    }

    public Scene getScene() {
        if (this.scene == null) this.scene = new Scene(this.root);
        return this.scene;
    }

}
