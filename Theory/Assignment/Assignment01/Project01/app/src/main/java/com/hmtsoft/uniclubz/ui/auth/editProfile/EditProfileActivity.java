package com.hmtsoft.uniclubz.ui.auth.editProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityEditProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModel;

public class EditProfileActivity extends AppCompatActivity {

    private ActivityEditProfileBinding binding;
    private String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);
        if (getIntent().hasExtra("email"))
            emailAddress = getIntent().getStringExtra("email");

        binding.btnSubmit.setOnClickListener(v -> {

            UserDetailsModel model = new UserDetailsModel(
                    binding.etFullName.getText().toString(),
                    emailAddress,
                    binding.etContactNumber.getText().toString(),
                    binding.tvDateOfBirth.getText().toString(),
                    binding.spBloodGroup.getSelectedItem().toString(),
                    binding.etNid.getText().toString(),
                    binding.spUniversity.getSelectedItem().toString(),
                    binding.spDepartment.getSelectedItem().toString(),
                    binding.etStudentId.getText().toString(),
                    binding.spStudyLevel.getSelectedItem().toString()
            );

        });

    }
}