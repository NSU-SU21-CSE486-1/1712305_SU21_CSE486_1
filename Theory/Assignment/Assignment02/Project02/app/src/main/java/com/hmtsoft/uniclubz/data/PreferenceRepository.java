package com.hmtsoft.uniclubz.data;

import com.hmtsoft.uniclubz.App;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.model.UserListModel;

public class PreferenceRepository {

    public static void saveUserData(UserDetailsModel userModel) {
        PreferenceHelper.with(App.getContext()).addObject("USER_MODEL", userModel).save();
    }

    public static UserDetailsModel getUserData() {
        return PreferenceHelper.with(App.getContext()).getObject("USER_MODEL", UserDetailsModel.class);
    }

    public static void saveUserListData(UserListModel userModel) {
        PreferenceHelper.with(App.getContext()).addObject("USER_LIST_MODEL", userModel).save();
    }

    public static UserListModel getUserListData() {
        return PreferenceHelper.with(App.getContext()).getObject("USER_LIST_MODEL", UserListModel.class);
    }

}
