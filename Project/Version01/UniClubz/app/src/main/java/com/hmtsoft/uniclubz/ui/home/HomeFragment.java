package com.hmtsoft.uniclubz.ui.home;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentHomeBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.home.controller.HomeController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private HomeController controller;

    public HomeFragment() {
        super(HomeViewModel.class, R.layout.fragment_home);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        viewModel.eventLiveList.observe(getViewLifecycleOwner(), entities -> {
            controller.setEventList(entities);
            controller.requestModelBuild();
        });

        viewModel.bloodRequestLiveList.observe(getViewLifecycleOwner(), entities -> {
            controller.setBloodRequestList(entities);
            controller.requestModelBuild();
        });
    }

    @Override
    protected void clickListeners() {

    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new HomeController();

        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }
}