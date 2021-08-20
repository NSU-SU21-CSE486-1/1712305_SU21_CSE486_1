package com.hmtsoft.uniclubz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserListModel implements Serializable {

    private List<UserDetailsModel> list;

    public void setList(List<UserDetailsModel> list) {
        this.list = list;
    }

    public List<UserDetailsModel> getList() {
        if (list == null)
            return new ArrayList<>();
        return list;
    }
}
