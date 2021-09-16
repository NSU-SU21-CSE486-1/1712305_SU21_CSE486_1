package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class BloodRequestEntity implements Serializable {

    private String bloodGroup;
    private String bags;
    private String date;
    private String phoneNumber;
    private String address;
    private String note;
    private String createdBy;
    private String clubId;

    public BloodRequestEntity() {

    }

    public BloodRequestEntity(String bloodGroup, String bags, String date, String phoneNumber, String address, String note, String createdBy, String clubId) {
        this.bloodGroup = bloodGroup;
        this.bags = bags;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
        this.createdBy = createdBy;
        this.clubId = clubId;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBags() {
        return bags;
    }

    public void setBags(String bags) {
        this.bags = bags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
