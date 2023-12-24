package com.example.oop.service;

import com.example.oop.model.ModelBlog;
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

public class CrawlerBlog {
    Document document = Jsoup.connect("https://www.livemint.com/opinion/blogs").get();
    Elements elms = document.getElementsByClass("listView");

    public CrawlerBlog() throws IOException {
    }

    public List<ModelBlog> CrawlerBlog() throws IOException {
        List<ModelBlog> modelBlogList =new ArrayList<>();

        for (Element e:
                elms) {

            Elements element_h2 = e.getElementsByTag("h2");
            Elements elements_a =e.getElementsByTag("img");
            for (int i=0;i<element_h2.size();i++) {
                ModelBlog modelBlog =new ModelBlog();
                Elements name = element_h2.get(i).getElementsByTag("a");
                modelBlog.setName(name.text());
                modelBlog.setUrlBlog(name.attr("href"));
                Elements img =elements_a.get(i).getElementsByAttribute("src");
                modelBlog.setUrlImage(img.attr("src"));
                modelBlogList.add(modelBlog);

            }

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter("G:\\nam4.1\\OOP\\project\\crawler-data\\src\\main\\java\\com\\example\\oop\\data\\BlogMint.json")) {
            // Chuyển đổi danh sách thành chuỗi JSON và lưu vào tệp tin
            gson.toJson(modelBlogList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelBlogList;

    }
}
