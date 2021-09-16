package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class EventEntity implements Serializable {

    private String name;
    private String coverPhoto;
    private String description;
    private String university;
    private String createdBy;
    private String clubId;

    public EventEntity() {

    }

    public EventEntity(String name, String coverPhoto, String description, String university, String createdBy, String clubId) {
        this.name = name;
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.university = university;
        this.createdBy = createdBy;
        this.clubId = clubId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }
}
