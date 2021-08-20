package com.hmtsoft.uniclubz.model;

import java.io.Serializable;
import java.util.List;

public class UserDetailsModel implements Serializable {
    private String fullName;
    private String dateOfBirth;
    private String bloodGroup;
    private String nid;
    private List<UniversityModel> universities;
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
