package com.hmtsoft.uniclubz.ui.clubDetails;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ClubDetailsViewModel extends ViewModel {

    protected MutableLiveData<ClubEntity> clubDetails = new MutableLiveData<>();
    protected MutableLiveData<List<UserDetailsEntity>> liveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;

    @Inject
    public ClubDetailsViewModel(FirebaseDatabase firebaseDatabase, SavedStateHandle savedStateHandle) {
        this.firebaseDatabase = firebaseDatabase;
        this.clubDetails.setValue(savedStateHandle.get("model"));

        firebaseDatabase.getReference("profiles").orderByChild("clubId").equalTo(clubDetails.getValue().getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<UserDetailsEntity> list = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    UserDetailsEntity item = postSnapshot.getValue(UserDetailsEntity.class);
                    list.add(item);
                }
                liveList.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
