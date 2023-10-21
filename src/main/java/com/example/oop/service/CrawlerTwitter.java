package com.example.oop.service;

import com.example.oop.model.ModelTwitter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlerTwitter {
    ArrayList<ModelTwitter> modelTwitters =new ArrayList<>();
    Document document = Jsoup.connect("https://getdaytrends.com/").get();
    Elements elms = document.getElementsByClass("trends");

    public CrawlerTwitter() throws IOException {
    }


    public void CrawlerTwitterTest() throws IOException {
        for (Element e:
             elms) {
            ModelTwitter model = new ModelTwitter();

            Elements elms = document.getElementsByTag("tbody");
            for (int i = 0; i < elms.size(); i++) {
                Elements elm_row = elms.get(i).getElementsByClass("main");
                for(int j=0 ; j< elm_row.size();j++){
                    Elements elm_row_td_first =elm_row.get(j).getElementsByTag("a");
                    model.setLink(elm_row_td_first.first().absUrl("href"));
                    System.out.println(model.getLink());

                }

            }

        }
    }
}
