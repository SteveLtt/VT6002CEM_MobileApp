package com.example.mobileapp_.model;

public class RecentsData {
    String umbrellaName;

    public String getUmbrellaName() {
        return umbrellaName;
    }

    public void setUmbrellaName(String umbrellaName) {
        this.umbrellaName = umbrellaName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    String Type;
    String price;

    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RecentsData(String umbrellaName, String Type, String price, Integer imageUrl) {
        this.umbrellaName = umbrellaName;
        this.Type = Type;
        this.price = price;
        this.imageUrl = imageUrl;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
