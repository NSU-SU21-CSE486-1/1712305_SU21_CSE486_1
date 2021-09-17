package com.hmtsoft.uniclubz.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.model.EventEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private FirebaseDatabase firebaseDatabase;
    protected MutableLiveData<List<EventEntity>> eventLiveList = new MutableLiveData<>();
    protected MutableLiveData<List<BloodRequestEntity>> bloodRequestLiveList = new MutableLiveData<>();

    @Inject
    public HomeViewModel(FirebaseDatabase firebaseDatabase) {

        firebaseDatabase.getReference("events")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<EventEntity> list = new ArrayList<>();
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            EventEntity item = postSnapshot.getValue(EventEntity.class);
                            list.add(item);
                        }
                        eventLiveList.setValue(list);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        firebaseDatabase.getReference("blood_requests")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<BloodRequestEntity> list = new ArrayList<>();
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            BloodRequestEntity item = postSnapshot.getValue(BloodRequestEntity.class);
                            list.add(item);
                        }
                        bloodRequestLiveList.setValue(list);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

}
