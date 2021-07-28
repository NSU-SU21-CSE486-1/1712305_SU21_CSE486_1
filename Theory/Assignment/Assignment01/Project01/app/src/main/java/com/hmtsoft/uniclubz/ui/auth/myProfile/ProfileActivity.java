package com.hmtsoft.uniclubz.ui.auth.myProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModel;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private UserDetailsModel userDetailsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        userDetailsModel = (UserDetailsModel) getIntent().getSerializableExtra("model");
        updateUserDetails(userDetailsModel);

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void updateUserDetails(UserDetailsModel model) {
        binding.userName.setText(model.getFullName());
        binding.emailAddress.setText(model.getEmailAddress());
        binding.contactNumber.setText(model.getContactNumber());
        binding.dateOfBirth.setText(model.getDateOfBirth());
        binding.bloodGroup.setText(model.getBloodGroup());
        binding.nid.setText(model.getNid());
        binding.studentId.setText(model.getStudentId());
        binding.university.setText(model.getUniversity());
        binding.department.setText(model.getDepartment());
        binding.studyLevel.setText(model.getStudyLevel());
    }
}