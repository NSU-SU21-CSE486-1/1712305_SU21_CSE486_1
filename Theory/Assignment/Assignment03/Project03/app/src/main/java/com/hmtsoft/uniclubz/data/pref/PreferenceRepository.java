package com.hmtsoft.uniclubz.data.pref;

import com.hmtsoft.uniclubz.App;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.model.UserListModel;

public class PreferenceRepository {

    public static void saveUserData(UserDetailsEntity userModel) {
        PreferenceHelper.with(App.getContext()).addObject("USER_MODEL", userModel).save();
    }

    public static UserDetailsEntity getUserData() {
        return PreferenceHelper.with(App.getContext()).getObject("USER_MODEL", UserDetailsEntity.class);
    }

    public static void saveUserListData(UserListModel userModel) {
        PreferenceHelper.with(App.getContext()).addObject("USER_LIST_MODEL", userModel).save();
    }

    public static UserListModel getUserListData() {
        return PreferenceHelper.with(App.getContext()).getObject("USER_LIST_MODEL", UserListModel.class);
    }

}
