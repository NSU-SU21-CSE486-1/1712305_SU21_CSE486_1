package com.hmtsoft.uniclubz.model;

import java.io.Serializable;

public class PhoneNumberModel implements Serializable {

    private String tag;
    private String phoneNumber;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
