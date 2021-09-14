package com.hmtsoft.uniclubz.ui.auth.signup;

import android.content.Intent;
import android.view.View;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentSignUpBinding;
import com.hmtsoft.uniclubz.ui.auth.editProfileOld.EditProfileActivityOld;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;

public class SignUpFragment extends BaseFragment<FragmentSignUpBinding, SignUpViewModel> {

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
            Intent intent = new Intent(getContext(), EditProfileActivityOld.class);
            intent.putExtra("email", email);
            startActivity(intent);
        });

        binding.toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }
}