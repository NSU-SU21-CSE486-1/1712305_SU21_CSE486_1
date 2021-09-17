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

    public static String getEmail() {
        return PreferenceHelper.with(App.getContext()).getString("email", "");
    }

    public static void saveEmail(String email) {
        PreferenceHelper.with(App.getContext()).addString("email", email).save();
    }

    public static String getUid() {
        return PreferenceHelper.with(App.getContext()).getString("uid", "");
    }

    public static void saveUid(String value) {
        PreferenceHelper.with(App.getContext()).addString("uid", value).save();
    }

    public static void clearAll(){
        PreferenceHelper.with(App.getContext()).clearAll();
    }

}
