package com.hmtsoft.uniclubz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserListModel implements Serializable {

    private List<UserDetailsEntity> list;

    public void setList(List<UserDetailsEntity> list) {
        this.list = list;
    }

    public List<UserDetailsEntity> getList() {
        if (list == null)
            return new ArrayList<>();
        return list;
    }
}
