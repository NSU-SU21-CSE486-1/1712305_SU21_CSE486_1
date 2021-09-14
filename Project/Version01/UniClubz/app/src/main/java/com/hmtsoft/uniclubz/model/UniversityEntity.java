package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class UniversityEntity implements Serializable {

    private String name;
    private String address;
    private String imageUrl;
    private String type;

    public UniversityEntity(){

    }

    public UniversityEntity(String name, String address, String imageUrl, String type) {
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
