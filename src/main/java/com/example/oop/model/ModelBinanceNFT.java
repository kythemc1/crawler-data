package com.example.oop.model;

public class ModelBinanceNFT {
    private String collectionId;
    private String coverUrl;
    private String title;
    private String network;
    private float volume;
    private float volumeRate;
//    private int ownersCount;
//    private int itemsCount;
    private int listedCount;
    private float floorPrice;
//    private double floorPriceRate;
    private int verified;

    public ModelBinanceNFT(String collectionId, String coverUrl, String title, String network, float volume, float volumeRate, int listedCount, float floorPrice, int verified) {
        this.collectionId = collectionId;
        this.coverUrl = coverUrl;
        this.title = title;
        this.network = network;
        this.volume = volume;
        this.volumeRate = volumeRate;
//        this.ownersCount = ownersCount;
//        this.itemsCount = itemsCount;
        this.listedCount = listedCount;
        this.floorPrice = floorPrice;
//        this.floorPriceRate = floorPriceRate;
        this.verified = verified;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = String.valueOf(collectionId);
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getVolumeRate() {
        return volumeRate;
    }

    public void setVolumeRate(float volumeRate) {
        this.volumeRate = volumeRate;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public float getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(float floorPrice) {
        this.floorPrice = floorPrice;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }
}
