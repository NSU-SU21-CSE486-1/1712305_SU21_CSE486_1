package com.hmtsoft.uniclubz.ui.auth.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.hmtsoft.uniclubz.ui.auth.editProfile.EditProfileActivity;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        binding.btnSubmit.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString();
            Intent intent = new Intent(this, EditProfileActivity.class);
            intent.putExtra("email", email);
        });
    }
}