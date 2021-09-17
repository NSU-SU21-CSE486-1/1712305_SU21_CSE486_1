package com.hmtsoft.uniclubz.model;

import java.io.Serializable;
import java.util.Calendar;

public class BloodRequestEntity implements Serializable {

    private String bloodGroup;
    private String bags;
    private String date;
    private String phoneNumber;
    private String address;
    private String note;
    private String createdBy;
    private long createdAt;
    private String clubId;
    private String clubName;

    public BloodRequestEntity() {

    }

    public BloodRequestEntity(String bloodGroup, String bags, String date, String phoneNumber, String address, String note, String createdBy) {
        this.bloodGroup = bloodGroup;
        this.bags = bags;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
        this.createdBy = createdBy;
        this.createdAt = Calendar.getInstance().getTimeInMillis();
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

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
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
