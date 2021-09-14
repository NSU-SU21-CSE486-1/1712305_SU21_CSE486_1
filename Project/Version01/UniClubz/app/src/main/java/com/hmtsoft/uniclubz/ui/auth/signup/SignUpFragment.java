package com.hmtsoft.uniclubz.ui.auth.signup;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentSignUpBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.utils.ToastUtils;
import com.hmtsoft.uniclubz.utils.Utils;

import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignUpFragment extends BaseFragment<FragmentSignUpBinding, SignUpViewModel> {

    private static final String TAG = "Signup";
    @Inject
    FirebaseAuth auth;

    public SignUpFragment() {
        super(SignUpViewModel.class, R.layout.fragment_sign_up);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

        binding.login.setOnClickListener(v -> navController.navigate(R.id.loginFragment));

        binding.btnSubmit.setOnClickListener(v -> {

            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            String confirmPassword = binding.etConfirmPassword.getText().toString();
            String error = null;

            if (email.isEmpty())
                error = "Please enter your email address";
            else if (!Utils.isEmailValid(email))
                error = "Please enter a valid email address";
            else if (password.isEmpty())
                error = "Please enter your password";
            else if (!password.equals(confirmPassword))
                error = "Confirm password didn't match";
            else if (password.length() < 7)
                error = "Password length should be more than 6 characters";
            if (error != null) {
                ToastUtils.show(error);
                return;
            }

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity(), task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            ToastUtils.show(Objects.requireNonNull(task.getException()).getMessage());
                        }
                    });
        });

        binding.toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }
}