package com.hmtsoft.uniclubz.ui.myProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModelOld;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private UserDetailsModelOld userDetailsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        userDetailsModel = (UserDetailsModelOld) getIntent().getSerializableExtra("model");
        updateUserDetails(userDetailsModel);

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void updateUserDetails(UserDetailsModelOld model) {
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