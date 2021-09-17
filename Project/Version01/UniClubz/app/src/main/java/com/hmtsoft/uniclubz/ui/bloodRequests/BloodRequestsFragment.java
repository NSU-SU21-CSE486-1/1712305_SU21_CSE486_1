package com.hmtsoft.uniclubz.ui.bloodRequests;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentBloodRequestsBinding;
import com.hmtsoft.uniclubz.databinding.FragmentClubsBinding;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.bloodRequests.controller.BloodRequestsController;
import com.hmtsoft.uniclubz.ui.clubs.controller.ClubsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BloodRequestsFragment extends BaseFragment<FragmentBloodRequestsBinding, BloodRequestsViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private BloodRequestsController controller;

    public BloodRequestsFragment() {
        super(BloodRequestsViewModel.class, R.layout.fragment_blood_requests);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        viewModel.liveList.observe(getViewLifecycleOwner(), entities -> {
            controller.setList(entities);
            controller.requestModelBuild();
        });
    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(backPressClickListener);
    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new BloodRequestsController();
        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }
}