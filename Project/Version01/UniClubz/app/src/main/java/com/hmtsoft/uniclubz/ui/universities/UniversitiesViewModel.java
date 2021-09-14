package com.hmtsoft.uniclubz.ui.universities;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.model.UniversityEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UniversitiesViewModel extends ViewModel {

    protected MutableLiveData<List<UniversityEntity>> liveList = new MutableLiveData<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference universityReference;


    @Inject
    public UniversitiesViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.universityReference = firebaseDatabase.getReference("universities");

        universityReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<UniversityEntity> list = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    UniversityEntity item = postSnapshot.getValue(UniversityEntity.class);
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
