package com.hmtsoft.uniclubz.ui.createClub;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.utils.SingleLiveEvent;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CreateClubViewModel extends ViewModel {

    protected MutableLiveData<List<ClubEntity>> liveList = new MutableLiveData<>();
    protected SingleLiveEvent<String> onClubCreated = new SingleLiveEvent<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Inject
    public CreateClubViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.reference = firebaseDatabase.getReference("clubs");

    }

    public void createClub(ClubEntity entity) {
        reference.push().setValue(entity);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                onClubCreated.postValue("Club successfully created!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                ToastUtils.show(error.getMessage());
            }
        });
    }

}
