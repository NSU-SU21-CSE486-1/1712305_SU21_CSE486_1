package com.hmtsoft.uniclubz.ui.clubDetails;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.utils.SingleLiveEvent;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ClubDetailsViewModel extends ViewModel {

    protected MutableLiveData<ClubEntity> clubDetails = new MutableLiveData<>();
    protected SingleLiveEvent<String> joinedClubLiveData = new SingleLiveEvent<>();
    protected MutableLiveData<List<UserDetailsEntity>> memberLiveList = new MutableLiveData<>();
    protected MutableLiveData<List<EventEntity>> eventLiveList = new MutableLiveData<>();
    protected MutableLiveData<List<BloodRequestEntity>> bloodRequestLiveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;

    @Inject
    public ClubDetailsViewModel(FirebaseDatabase firebaseDatabase, SavedStateHandle savedStateHandle) {
        this.firebaseDatabase = firebaseDatabase;

        String clubId = PreferenceRepository.getUserData().getClubId();
        if (savedStateHandle.contains("model")) {
            this.clubDetails.setValue(savedStateHandle.get("model"));
            clubId = clubDetails.getValue().getId();
        } else {
            firebaseDatabase.getReference("clubs")
                    .child(PreferenceRepository.getUserData().getClubId())
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ClubEntity clubEntity = snapshot.getValue(ClubEntity.class);
                            if (clubEntity != null) {
                                clubEntity.setId(snapshot.getKey());
                                clubDetails.setValue(clubEntity);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }

        firebaseDatabase.getReference("profiles")
                .orderByChild("clubId")
                .equalTo(clubId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<UserDetailsEntity> list = new ArrayList<>();
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            UserDetailsEntity item = postSnapshot.getValue(UserDetailsEntity.class);
                            list.add(item);
                        }
                        memberLiveList.setValue(list);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        firebaseDatabase.getReference("events")
                .orderByChild("clubId")
                .equalTo(clubId)
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
                .orderByChild("clubId")
                .equalTo(clubId)
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


    public void joinClub() {
        firebaseDatabase.getReference("profiles")
                .child(PreferenceRepository.getUid())
                .child("clubId")
                .setValue(clubDetails.getValue().getId())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        UserDetailsEntity entity = PreferenceRepository.getUserData();
                        entity.setClubId(clubDetails.getValue().getId());
                        PreferenceRepository.saveUserData(entity);
                        joinedClubLiveData.setValue("Successfully joined to this club");
                    } else {
                        ToastUtils.show(task.getException().getMessage());
                    }
                });
    }

}
