package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class UserDetailsModelOld implements Serializable {
    private String fullName;
    private String dateOfBirth;
    private String bloodGroup;
    private String contactNumber;
    private String emailAddress;
    private String nid;
    private String university;
    private String department;
    private String studentId;
    private String studyLevel;



    public UserDetailsModelOld(String fullName, String emailAddress, String contactNumber, String dateOfBirth, String bloodGroup, String nid, String university, String department, String studentId, String studyLevel) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.nid = nid;
        this.university = university;
        this.department = department;
        this.studentId = studentId;
        this.studyLevel = studyLevel;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }
}
