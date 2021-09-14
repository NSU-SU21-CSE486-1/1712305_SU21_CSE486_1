package com.hmtsoft.uniclubz.ui.main;

import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.model.UniversityEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private FirebaseDatabase firebaseDatabase;

    @Inject
    public MainViewModel(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;

    }

    private void addUniversityListToDatabase() {
        // one time, needs to be managed by admin
        DatabaseReference universitiesReference = firebaseDatabase.getReference("universities");
        List<UniversityEntity> list = new ArrayList<>();
        list.add(new UniversityEntity("North South University", "Bashundhara R/A, Dhaka", "https://www.daily-sun.com/assets/news_images/2018/08/06/campus.jpg", "Private"));
        list.add(new UniversityEntity("American International University", "Bashundhara R/A, Dhaka", "https://www.aiub.edu/Files/Uploads/new_campus_pic_2.jpg", "Private"));
        list.add(new UniversityEntity("Independent University Bangladesh", "Bashundhara R/A, Dhaka", "https://studybarta.files.wordpress.com/2018/05/independent-university-iub.jpg", "Private"));
        list.add(new UniversityEntity("BRAC University", "Banani, Dhaka", "https://media-eng.dhakatribune.com/uploads/2020/09/web-bracu-03082017-collected-1599318197983.jpg", "Private"));
        list.add(new UniversityEntity("East West University", "Baddha, Dhaka", "https://i.pinimg.com/originals/9c/f2/78/9cf2781851f305e2c2e67bbe24c14612.jpg", "Private"));
        list.add(new UniversityEntity("Daffodil University", "Dhanmondi, Dhaka", "https://dailyasianage.com/library/1593371397_1.jpg", "Private"));
        universitiesReference.setValue(list);
    }

}
