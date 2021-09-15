package com.hmtsoft.uniclubz.ui.clubs;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.ClubEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ClubsViewModel extends ViewModel {

    protected MutableLiveData<List<ClubEntity>> liveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference universityReference;


    @Inject
    public ClubsViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.universityReference = firebaseDatabase.getReference("clubs");

        universityReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ClubEntity> list = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ClubEntity item = postSnapshot.getValue(ClubEntity.class);
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
