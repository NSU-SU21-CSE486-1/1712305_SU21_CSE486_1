package com.hmtsoft.uniclubz.ui.auth.login;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentLoginBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.utils.ToastUtils;
import com.hmtsoft.uniclubz.utils.Utils;

import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> {

    @Inject
    FirebaseAuth auth;

    @Inject
    FirebaseDatabase firebaseDatabase;


    public LoginFragment() {
        super(LoginViewModel.class, R.layout.fragment_login);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

        binding.signUp.setOnClickListener(v -> navController.navigate(R.id.signUpFragment));


        binding.btnSubmit.setOnClickListener(v -> {

            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            String error = null;

            if (email.isEmpty())
                error = "Please enter your email address";
            else if (!Utils.isEmailValid(email))
                error = "Please enter a valid email address";
            else if (password.isEmpty())
                error = "Confirm password didn't match";
            else if (password.length() < 7)
                error = "Password length should be more than 6 characters";
            if (error != null) {
                ToastUtils.show(error);
                return;
            }

            loadingDialog.showDialog();

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity(), task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                PreferenceRepository.saveEmail(user.getEmail());
                                PreferenceRepository.saveUid(user.getUid());
                                syncProfile();
                            }
                        } else {
                            loadingDialog.hideDialog();
                            ToastUtils.show(Objects.requireNonNull(task.getException()).getMessage());
                        }
                    });
        });

        binding.toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }

    protected void syncProfile() {

        ToastUtils.show("Syncing profile...");
        firebaseDatabase.getReference("profiles").child(PreferenceRepository.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loadingDialog.hideDialog();
                UserDetailsEntity model = snapshot.getValue(UserDetailsEntity.class);
                if (model == null) {
                    navController.navigate(R.id.editProfileFragment);
                } else {
                    PreferenceRepository.saveUserData(model);
                    navController.navigate(R.id.homeFragment);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                loadingDialog.hideDialog();
            }
        });

    }
}