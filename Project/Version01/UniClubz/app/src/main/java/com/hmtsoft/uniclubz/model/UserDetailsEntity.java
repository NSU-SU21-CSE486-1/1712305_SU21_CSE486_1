package com.hmtsoft.uniclubz.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "user_list_table")
public class UserDetailsEntity implements Serializable {

    @PrimaryKey
    @ColumnInfo
    @NonNull
    private String nid;

    @ColumnInfo
    private String fullName;

    @ColumnInfo
    private String dateOfBirth;

    @ColumnInfo
    private String bloodGroup;

    @ColumnInfo
    private List<UniversityModel> universities;

    @ColumnInfo
    private List<PhoneNumberModel> phoneNumbers;

    public void setPersonalInformation(String fullName, String dateOfBirth, String bloodGroup, String nid) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.nid = nid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public List<UniversityModel> getUniversities() {
        return universities;
    }

    public void setUniversities(List<UniversityModel> universities) {
        this.universities = universities;
    }

    public List<PhoneNumberModel> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberModel> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
