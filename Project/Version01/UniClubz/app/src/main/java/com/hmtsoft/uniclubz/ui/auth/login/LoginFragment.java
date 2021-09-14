package com.hmtsoft.uniclubz.ui.auth.login;

import android.content.Intent;
import android.view.View;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentLoginBinding;
import com.hmtsoft.uniclubz.databinding.FragmentSignUpBinding;
import com.hmtsoft.uniclubz.ui.auth.editProfileOld.EditProfileActivityOld;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> {

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
            Intent intent = new Intent(getContext(), EditProfileActivityOld.class);
            intent.putExtra("email", email);
            startActivity(intent);
        });

        binding.toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }
}