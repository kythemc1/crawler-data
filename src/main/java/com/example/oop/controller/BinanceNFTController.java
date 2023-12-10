package com.example.oop.controller;

import com.example.oop.model.ModelBinanceNFT;
import com.example.oop.service.CrawlerBinanceNFT;
import com.example.oop.views.HomeView;
import com.google.gson.GsonBuilder;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BinanceNFTController implements Initializable {
    @FXML
    private TableView<ModelBinanceNFT> tableViewMain;
    @FXML
    private TableColumn<ModelBinanceNFT, Long> columnViewIndex;
    @FXML
    private TableColumn<ModelBinanceNFT, Hyperlink> columnViewUrl;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewTitle;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewNetwork;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewVolumn;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewVolumnRate;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewListedCount;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewFloorPrice;
    @FXML
    private TableColumn<ModelBinanceNFT, Text> columnViewVerified;

    @FXML
    void buttonBack(ActionEvent ignoredEvent) throws IOException {
        ((Stage) this.tableViewMain.getScene().getWindow()).setScene(new HomeView().getScene());
    }

    @FXML
    void onBinanceNFTButtonClick(ActionEvent ignoredEvent) {
        CrawlerBinanceNFT callAPIBinance = new CrawlerBinanceNFT();
        List<ModelBinanceNFT> list = callAPIBinance.getPost();

        String jsonLog = new GsonBuilder().setPrettyPrinting().create().toJson(list);

        this.tableViewMain.setItems(FXCollections.observableList(list));

        // In chuỗi JSON ra màn hình
        System.out.println(jsonLog);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // index
        this.columnViewIndex.setCellValueFactory(cellData -> {
            long index = tableViewMain.getItems().indexOf(cellData.getValue()) + 1;
            return new ReadOnlyObjectWrapper<>(index);
        });

        // url
        this.columnViewUrl.setCellValueFactory(new PropertyValueFactory<>("coverUrl"));

        // title
        this.columnViewTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        // network
        this.columnViewNetwork.setCellValueFactory(new PropertyValueFactory<>("network"));

        // volume
        this.columnViewVolumn.setCellValueFactory(new PropertyValueFactory<>("volume"));

        // volumeRate
        this.columnViewVolumnRate.setCellValueFactory(new PropertyValueFactory<>("volumeRate"));

        // listedCount
        this.columnViewListedCount.setCellValueFactory(new PropertyValueFactory<>("listedCount"));

        // floorPrice
        this.columnViewFloorPrice.setCellValueFactory(new PropertyValueFactory<>("floorPrice"));

        // verified
        this.columnViewVerified.setCellValueFactory(new PropertyValueFactory<>("verified"));
    }
}
