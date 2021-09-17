package com.hmtsoft.uniclubz.ui.bloodRequests;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BloodRequestsViewModel extends ViewModel {

    protected MutableLiveData<List<BloodRequestEntity>> liveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;

    @Inject
    public BloodRequestsViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;

        firebaseDatabase.getReference("blood_requests").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<BloodRequestEntity> list = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    BloodRequestEntity item = postSnapshot.getValue(BloodRequestEntity.class);
                    assert item != null;
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
