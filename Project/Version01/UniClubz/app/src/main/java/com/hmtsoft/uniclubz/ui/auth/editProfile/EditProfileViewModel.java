package com.hmtsoft.uniclubz.ui.auth.editProfile;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.data.room.DatabaseRepository;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.utils.SingleLiveEvent;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class EditProfileViewModel extends ViewModel {

    protected MutableLiveData<UserDetailsEntity> userDetailsLiveData = new MutableLiveData<>();
    protected SingleLiveEvent<String> userInsertObserver = new SingleLiveEvent<>();
    protected UserDetailsEntity userDetailsModel = new UserDetailsEntity();
    protected DatabaseRepository databaseRepository;
    protected FirebaseDatabase firebaseDatabase;

    public EditProfileViewModel(){

    }

    @Inject
    public EditProfileViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        databaseRepository = DatabaseRepository.getInstance();
        if (PreferenceRepository.getUserData() != null)
            userDetailsModel = PreferenceRepository.getUserData();
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

        userDetailsModel.setUid(PreferenceRepository.getUid());

        DatabaseReference profileReference = firebaseDatabase.getReference("profiles");

        profileReference.push().setValue(userDetailsModel);

        profileReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userInsertObserver.postValue("User profile successfully updated!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                ToastUtils.show(error.getMessage());
            }
        });

    }

}
