package com.example.oop.controller;

import com.example.oop.model.ModelTwitter;
import com.example.oop.service.CrawlerTwitter;
import com.example.oop.views.HomeView;
import com.google.gson.GsonBuilder;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TwitterController implements Initializable {
    @FXML
    private TableView<ModelTwitter> tableViewMain;
    @FXML
    private TableColumn<ModelTwitter, Long> tableColumnIndex;
    @FXML
    private TableColumn<ModelTwitter, Text> tableColumnHashTag;
    @FXML
    private TableColumn<ModelTwitter, Hyperlink> tableColumnLink;

    @FXML
    void buttonBack(ActionEvent ignored) throws IOException {
        ((Stage) tableViewMain.getScene().getWindow()).setScene(new HomeView().getScene());
    }

    @FXML
    void onTwitterButtonClick(ActionEvent ignored) throws IOException {
        CrawlerTwitter crawlerTwitter = new CrawlerTwitter();
        List<ModelTwitter> list = crawlerTwitter.CrawlerTwitter();

        String jsonLog = new GsonBuilder().setPrettyPrinting().create().toJson(list);

        // In chuỗi JSON ra màn hình
        System.out.println(jsonLog);

        this.tableViewMain.setItems(FXCollections.observableList(list));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // index
        this.tableColumnIndex.setCellValueFactory(cellData -> {
            long index = tableViewMain.getItems().indexOf(cellData.getValue()) + 1;
            return new ReadOnlyObjectWrapper<>(index);
        });

        // hash tag
        this.tableColumnHashTag.setCellValueFactory(cellData -> {
            var text = new Text(cellData.getValue().getHashTag());
            return new ReadOnlyObjectWrapper<>(text);
        });

        // link
        this.tableColumnLink.setCellValueFactory(cellData -> {
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
//        this.tableColumnLink.setMaxWidth(Double.MAX_VALUE);

    }
}
