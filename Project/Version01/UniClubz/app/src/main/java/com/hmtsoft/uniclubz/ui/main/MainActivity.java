package com.hmtsoft.uniclubz.ui.main;

import android.util.Log;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityMainBinding;
import com.hmtsoft.uniclubz.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    FirebaseAuth firebaseAuth;
    private NavController navController;


    public MainActivity() {
        super(MainViewModel.class, R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

    }

    @Override
    public void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() == null) {
            navController.navigate(R.id.loginFragment);
        } else {
            Log.e("user info", new Gson().toJson(firebaseAuth.getCurrentUser().));
        }
    }

}