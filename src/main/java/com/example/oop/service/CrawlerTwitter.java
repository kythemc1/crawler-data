package com.example.oop.service;

import com.example.oop.model.ModelTwitter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerTwitter {
    Document document = Jsoup.connect("https://getdaytrends.com/").get();
    Elements elms = document.getElementsByClass("trends");

    public CrawlerTwitter() throws IOException {
    }



    public List<ModelTwitter> CrawlerTwitter() throws IOException {
        List<ModelTwitter> modelTwitterList =new ArrayList<>();
        for (Element e:
             elms) {
            Elements elms = document.getElementsByTag("tbody");
            for (int i = 0; i < elms.size(); i++) {
                Elements elm_row = elms.get(i).getElementsByClass("main");
                for(int j=0 ; j< elm_row.size();j++){
                    ModelTwitter model = new ModelTwitter();
                    Elements elm_row_td_first =elm_row.get(j).getElementsByTag("a");
                    model.setLink(elm_row_td_first.first().absUrl("href"));
                    model.setHashTag(elm_row_td_first.first().text());
                    modelTwitterList.add(model);

                }

            }

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter("G:\\nam4.1\\OOP\\project\\crawler-data\\src\\main\\java\\com\\example\\oop\\data\\Twitter.json")) {
            // Chuyển đổi danh sách thành chuỗi JSON và lưu vào tệp tin
            gson.toJson(modelTwitterList, fileWriter);
            System.out.println("Đã lưu danh sách vào json.json"+modelTwitterList);
        } catch (IOException e) {
            e.printStackTrace();
        }

       return modelTwitterList;

    }

}
