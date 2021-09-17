package com.hmtsoft.uniclubz.ui.userProfileModal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.hmtsoft.uniclubz.model.UserDetailsEntity;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserProfileViewModel extends ViewModel {

    protected MutableLiveData<UserDetailsEntity> liveData = new MutableLiveData<>();

    @Inject
    public UserProfileViewModel(SavedStateHandle args) {
        liveData.setValue(args.get("model"));
    }


}
