package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class ClubEntity implements Serializable {

    private String id;
    private String name;
    private String address;
    private String coverPhoto;
    private String logo;
    private String description;
    private String university;

    public ClubEntity() {

    }

    public ClubEntity(String name, String address, String coverPhoto, String logo, String description, String university) {
        this.name = name;
        this.address = address;
        this.coverPhoto = coverPhoto;
        this.logo = logo;
        this.description = description;
        this.university = university;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
