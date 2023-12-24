package com.example.oop.service;

import com.example.oop.model.ModelBinanceNFT;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerBinanceNFT {
    public List<ModelBinanceNFT> getPost() {
        List<ModelBinanceNFT> list=new ArrayList<>();
        try {
            String result = sendPOST("https://www.binance.com/bapi/nft/v1/friendly/nft/ranking/trend-collection");
            System.out.println(result);
            JSONObject jsonObject = new JSONObject(result);
            JSONArray rows = jsonObject.getJSONObject("data").getJSONArray("rows");

            for (int i = 0; i < rows.length(); i++) {
                ModelBinanceNFT modelBinanceNFT =new ModelBinanceNFT("","","","",0,0,0,0,0);
                JSONObject row = rows.getJSONObject(i);

                modelBinanceNFT.setCollectionId(row.getString("collectionId"));
                modelBinanceNFT.setCoverUrl(row.getString("coverUrl"));
                modelBinanceNFT.setTitle(row.getString("title"));
                modelBinanceNFT.setNetwork(row.getString("network"));
                modelBinanceNFT.setVolume(row.getFloat("volume"));
                modelBinanceNFT.setVolumeRate(row.getFloat("volumeRate"));
//                    modelBinanceNFT.setOwnersCount(row.getInt("ownersCount"));
//                    modelBinanceNFT.setItemsCount(row.getInt("itemsCount"));
                modelBinanceNFT.setListedCount(row.optInt("listedCount"));
                modelBinanceNFT.setFloorPrice(row.getFloat("floorPrice"));
//                    modelBinanceNFT.setFloorPriceRate(row.getDouble("floorPriceRate"));
                modelBinanceNFT.setVerified(row.getInt("verified"));

                list.add(modelBinanceNFT);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter("G:\\nam4.1\\OOP\\project\\crawler-data\\src\\main\\java\\com\\example\\oop\\data\\BinanceNFT.json")) {
            // Chuyển đổi danh sách thành chuỗi JSON và lưu vào tệp tin
            gson.toJson(list, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
    private static String sendPOST(String url) throws IOException {
        HttpPost request = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Clienttype", "web");

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"network\":\"ALL\",");
        json.append("\"period\":\"24H\",");
        json.append("\"sortType\":\"volumeDesc\",");
        json.append("\"page\":1,");
        json.append("\"rows\":100,");
        json.append("}");

        System.out.println(json);
        // send a JSON data
        request.setEntity(new StringEntity(json.toString()));

        CloseableHttpResponse response = httpClient.execute(request);

        return EntityUtils.toString(response.getEntity());
    }
}
