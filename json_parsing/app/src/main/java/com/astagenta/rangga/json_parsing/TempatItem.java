package com.astagenta.rangga.json_parsing;

public class TempatItem {
    private String imageUrl;
    private String name;
    private String latitude;
    private String longitude;
    private String category;

    public TempatItem(String imageUrl, String name, String latitude, String longitude, String category) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
