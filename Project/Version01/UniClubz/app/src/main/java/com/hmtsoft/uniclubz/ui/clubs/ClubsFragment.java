package com.hmtsoft.uniclubz.ui.clubs;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentClubsBinding;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.clubs.controller.ClubsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ClubsFragment extends BaseFragment<FragmentClubsBinding, ClubsViewModel> implements ClubsController.ClickListener {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private ClubsController controller;

    public ClubsFragment() {
        super(ClubsViewModel.class, R.layout.fragment_clubs);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        viewModel.liveList.observe(getViewLifecycleOwner(), clubEntities -> {
            controller.setList(clubEntities);
            controller.requestModelBuild();
        });
    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(backPressClickListener);
        binding.createClub.setOnClickListener(v -> navController.navigate(R.id.createClubFragment));
    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new ClubsController();

        controller.setClickListener(this);
        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }

    @Override
    public void onClick(ClubEntity entity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", entity);
        navController.navigate(R.id.clubDetailsFragment, bundle);
    }
}