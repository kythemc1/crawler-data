package com.example.oop.model;

public class ModelTwitter {
    private String hashTag;
    private String link;
    public ModelTwitter() {

    }
//    public ModelTwitter(String hashTag, String link) {
//        this.hashTag = hashTag;
//        this.link = link;
//    }
    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
