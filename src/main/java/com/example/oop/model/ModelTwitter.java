package com.example.oop.model;

public class ModelTwitter {
    private String hashTag;
    private String link;
    public ModelTwitter() {

    }
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
    public String toString(String link, String hashTag) {
        return "link: " + link +"\n" +", hashTag: " + hashTag ;
    }

}
