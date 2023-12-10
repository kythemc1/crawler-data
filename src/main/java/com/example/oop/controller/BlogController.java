package com.example.oop.controller;

import com.example.oop.model.ModelBlog;
import com.example.oop.service.CrawlerBlog;
import com.example.oop.views.HomeView;
import com.google.gson.Gson;
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
import javafx.scene.control.cell.PropertyValueFactory;
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

public class BlogController implements Initializable {
    @FXML
    private TableView<ModelBlog> tableViewMain;
    @FXML
    private TableColumn<ModelBlog, Long> tableColumnIndex;
    @FXML
    private TableColumn<ModelBlog, Text> tableColumnName;
    @FXML
    private TableColumn<ModelBlog, Hyperlink> tableColumnUrlImage;
    @FXML
    private TableColumn<ModelBlog, Hyperlink> tableColumnUrlBlog;


    @FXML
    void buttonBack(ActionEvent ignored) throws IOException {
        ((Stage) tableViewMain.getScene().getWindow()).setScene(new HomeView().getScene());
    }

    @FXML
    void onBlogButtonClick(ActionEvent event) throws IOException {
        CrawlerBlog crawlerBlog = new CrawlerBlog();
        List<ModelBlog> list = crawlerBlog.CrawlerBlog();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(list);

        this.tableViewMain.setItems(FXCollections.observableList(list));

        // In chuỗi JSON ra màn hình
        System.out.println(jsonLog);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // index
        this.tableColumnIndex.setCellValueFactory(cellData -> {
            long index = tableViewMain.getItems().indexOf(cellData.getValue()) + 1;
            return new ReadOnlyObjectWrapper<>(index);
        });

        // name
        this.tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        // urlImage
        this.tableColumnUrlImage.setCellValueFactory(cellData -> {
            var link = new Hyperlink(cellData.getValue().getUrlImage());
            link.setOnAction(e -> {
                try {
                    Desktop.getDesktop().browse(URI.create(link.getText()));
                } catch (IOException ex) {
                    Stage popup = new Stage();
                    // block if not closed
                    popup.initModality(Modality.APPLICATION_MODAL);
                    popup.setTitle("Link Error");

                    javafx.scene.control.Label errMessage = new Label(ex.getMessage());
                    // TODO: style

                    var popupRoot = new StackPane(errMessage);

                    var popupScene = new Scene(popupRoot);

                    popup.setScene(popupScene);
                    popup.showAndWait();
                }
            });
            return new ReadOnlyObjectWrapper<>(link);

        });

        // urlBlog
        this.tableColumnUrlBlog.setCellValueFactory(cellData -> {
            var link = new Hyperlink(cellData.getValue().getUrlBlog());
            link.setOnAction(e -> {
                try {
                    Desktop.getDesktop().browse(URI.create(link.getText()));
                } catch (IOException ex) {
                    Stage popup = new Stage();
                    // block if not closed
                    popup.initModality(Modality.APPLICATION_MODAL);
                    popup.setTitle("Link Error");

                    javafx.scene.control.Label errMessage = new Label(ex.getMessage());
                    // TODO: style

                    var popupRoot = new StackPane(errMessage);

                    var popupScene = new Scene(popupRoot);

                    popup.setScene(popupScene);
                    popup.showAndWait();
                }
            });
            return new ReadOnlyObjectWrapper<>(link);

        });
    }
}
