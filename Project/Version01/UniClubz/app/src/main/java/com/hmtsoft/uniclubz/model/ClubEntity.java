package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class ClubEntity implements Serializable {

    private String id;
    private String name;
    private String coverPhoto;
    private String logo;
    private String description;
    private String university;
    private String adminUid;

    public ClubEntity() {

    }

    public ClubEntity(String name, String university, String logo, String coverPhoto, String description, String adminUid) {
        this.name = name;
        this.coverPhoto = coverPhoto;
        this.logo = logo;
        this.description = description;
        this.university = university;
        this.adminUid = adminUid;
    }

    public void setAdminUid(String adminUid) {
        this.adminUid = adminUid;
    }

    public String getAdminUid() {
        return adminUid;
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
