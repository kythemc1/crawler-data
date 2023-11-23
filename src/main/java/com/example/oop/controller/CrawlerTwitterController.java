package com.example.oop.controller;

import com.example.oop.MainApplication;
import com.example.oop.model.ModelTwitter;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class CrawlerTwitterController {
    @FXML
    @SuppressWarnings("all")
    private VBox root;
    @FXML
    private TableView<ModelTwitter> tableViewMain;
    @FXML
    private TableColumn<ModelTwitter, Long> columnViewIndex;
    @FXML
    private TableColumn<ModelTwitter, Text> columnViewHashTag;
    @FXML
    private TableColumn<ModelTwitter, Hyperlink> columnViewLink;

    @FXML
    public void  initialize() {
        // bind data
        if (MainApplication.twitterPosts != null)
            this.tableViewMain.setItems(FXCollections.observableList(MainApplication.twitterPosts));
        else
            this.tableViewMain.setItems(FXCollections.observableArrayList(
                    new ModelTwitter("Hashtag 1", "www.google.com"),
                    new ModelTwitter("Hashtag 3", "www.facebook.com"),
                    new ModelTwitter("Hashtag 2", "not_available_link")
            ));

        // index
        this.columnViewIndex.setCellValueFactory(cellData -> {
            long index = tableViewMain.getItems().indexOf(cellData.getValue()) + 1;
            return new ReadOnlyObjectWrapper<>(index);
        });

        // hash tag
        this.columnViewHashTag.setCellValueFactory(cellData -> {
            var text = new Text(cellData.getValue().getHashTag());
            return new ReadOnlyObjectWrapper<>(text);
        });

        // link
        this.columnViewLink.setCellValueFactory(cellData -> {
            var link = new Hyperlink(cellData.getValue().getLink());
            link.setOnAction(e -> {
                try {
                    Desktop.getDesktop().browse(URI.create(link.getText()));
                } catch (IOException ex) {
                    Stage popup = new Stage();
                    // block if not closed
                    popup.initModality(Modality.APPLICATION_MODAL);
                    popup.setTitle("Link Error");

                    Label errMessage = new Label(ex.getMessage());
                    // TODO: style

                    var popupRoot = new StackPane(errMessage);

                    var popupScene = new Scene(popupRoot);

                    popup.setScene(popupScene);
                    popup.showAndWait();
                }
            });
            return new ReadOnlyObjectWrapper<>(link);
        });

        //// size ////
        // table - last col
        this.tableViewMain.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        this.columnViewLink.setMaxWidth(Double.MAX_VALUE);


    }
}
