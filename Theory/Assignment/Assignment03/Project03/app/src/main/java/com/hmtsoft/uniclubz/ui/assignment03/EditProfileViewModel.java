package com.hmtsoft.uniclubz.ui.assignment03;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hmtsoft.uniclubz.data.room.DatabaseRepository;
import com.hmtsoft.uniclubz.listener.DatabaseListener;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.utils.SingleLiveEvent;

public class EditProfileViewModel extends ViewModel {

    protected MutableLiveData<UserDetailsEntity> userDetailsLiveData = new MutableLiveData<>();
    protected SingleLiveEvent<String> userInsertObserver = new SingleLiveEvent<>();
    protected UserDetailsEntity userDetailsModel = new UserDetailsEntity();
    protected DatabaseRepository databaseRepository;

    public EditProfileViewModel() {
        databaseRepository = DatabaseRepository.getInstance();
        userDetailsLiveData.setValue(userDetailsModel);
    }

    public UserDetailsEntity getUserDetailsModel() {
        if (userDetailsModel == null) {
            userDetailsModel = new UserDetailsEntity();
            return userDetailsModel;
        }
        return userDetailsModel;
    }

    public void setUserDetailsModel(UserDetailsEntity userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
        userDetailsLiveData.setValue(userDetailsModel);
    }

    public LiveData<UserDetailsEntity> getUserDetailsLiveData() {
        return userDetailsLiveData;
    }

    public void insertUserDetailsToDatabase() {

        databaseRepository.insertUser(userDetailsModel, new DatabaseListener() {
            @Override
            public void onSuccess() {
                userInsertObserver.postValue("User details inserted to database successfully");
            }

            @Override
            public void onFailed() {
                userInsertObserver.postValue("User details couldn't be inserted to database");
            }
        });

    }

}
