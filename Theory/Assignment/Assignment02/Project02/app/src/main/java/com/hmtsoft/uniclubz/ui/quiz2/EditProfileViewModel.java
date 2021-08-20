package com.hmtsoft.uniclubz.ui.quiz2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hmtsoft.uniclubz.model.UserDetailsModel;

public class EditProfileViewModel extends ViewModel {

    private MutableLiveData<UserDetailsModel> userDetailsLiveData = new MutableLiveData<>();

    private UserDetailsModel userDetailsModel = new UserDetailsModel();

    public EditProfileViewModel() {

        userDetailsLiveData.setValue(userDetailsModel);

    }

    public UserDetailsModel getUserDetailsModel() {
        if (userDetailsModel == null) {
            userDetailsModel = new UserDetailsModel();
            return userDetailsModel;
        }
        return userDetailsModel;
    }

    public void setUserDetailsModel(UserDetailsModel userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
        userDetailsLiveData.setValue(userDetailsModel);
    }

    public LiveData<UserDetailsModel> getUserDetailsLiveData() {
        return userDetailsLiveData;
    }
}
