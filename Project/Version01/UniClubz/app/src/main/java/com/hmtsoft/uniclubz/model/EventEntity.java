package com.hmtsoft.uniclubz.model;

import java.io.Serializable;
import java.util.Calendar;

public class EventEntity implements Serializable {

    private String name;
    private String coverPhoto;
    private String description;
    private String university;
    private String createdBy;
    private long createdAt;
    private String date;
    private String clubId;
    private String clubName;

    public EventEntity() {

    }

    public EventEntity(String name, String coverPhoto, String description, String university, String createdBy, String date) {
        this.name = name;
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.university = university;
        this.createdBy = createdBy;
        this.date = date;
        this.createdAt = Calendar.getInstance().getTimeInMillis();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
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

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }
}
