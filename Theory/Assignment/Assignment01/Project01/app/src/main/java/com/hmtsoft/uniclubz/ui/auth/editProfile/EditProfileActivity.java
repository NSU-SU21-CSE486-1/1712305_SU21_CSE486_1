package com.hmtsoft.uniclubz.ui.auth.editProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityEditProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.ui.auth.myProfile.ProfileActivity;

public class EditProfileActivity extends AppCompatActivity {

    private ActivityEditProfileBinding binding;
    private String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);

        if (getIntent().hasExtra("email"))
            emailAddress = getIntent().getStringExtra("email");

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
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

            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("model", model);
            startActivity(intent);
        });

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTheme(R.style.MaterialCalendarTheme);
        materialDateBuilder.setTitleText("SELECT DATE OF BIRTH");
        MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        binding.tvDateOfBirth.setOnClickListener(v -> {
            materialDatePicker.show(getSupportFragmentManager(), "date_picker");
        });

        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            binding.tvDateOfBirth.setText(materialDatePicker.getHeaderText());
        });

    }
}