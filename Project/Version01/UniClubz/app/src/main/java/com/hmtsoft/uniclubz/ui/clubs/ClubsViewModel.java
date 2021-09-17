package com.hmtsoft.uniclubz.ui.clubs;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.model.UniversityEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ClubsViewModel extends ViewModel {

    protected MutableLiveData<List<ClubEntity>> liveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference universityReference;
    private UniversityEntity universityEntity;

    @Inject
    public ClubsViewModel(FirebaseDatabase firebaseDatabase, SavedStateHandle savedStateHandle) {
        this.firebaseDatabase = firebaseDatabase;
        this.universityEntity = savedStateHandle.get("model");

        Query query;
        if (universityEntity != null)
            query = firebaseDatabase.getReference("clubs").orderByChild("university").equalTo(universityEntity.getName());
        else
            query = firebaseDatabase.getReference("clubs");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ClubEntity> list = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ClubEntity item = postSnapshot.getValue(ClubEntity.class);
                    assert item != null;
                    item.setId(postSnapshot.getKey());
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
