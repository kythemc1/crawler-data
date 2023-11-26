package com.example.oop.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;
import java.net.URL;

public abstract class BaseView {
    protected final Scene scene;
    @Getter
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
        this.scene = new Scene(root);
    }

    protected abstract URL getSceneURL() throws NullPointerException;

    /**
     * Apply the scene into the stage
     * @param stage stage that need to change scene
     */
    public void apply(@NonNull Stage stage) {
        var max = stage.isMaximized();
        var min = stage.isIconified();

        stage.setScene(this.scene);

        if (max) {
            stage.setMaximized(true);
        }
        if (min) {
            stage.setIconified(true);
        }
    }

    public <T> T getController() {
        return this.loader.getController();
    }

}
