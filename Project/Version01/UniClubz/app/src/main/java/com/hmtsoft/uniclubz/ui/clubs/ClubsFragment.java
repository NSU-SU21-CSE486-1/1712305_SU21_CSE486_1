package com.hmtsoft.uniclubz.ui.clubs;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentUniversitiesBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.clubs.controller.ClubsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ClubsFragment extends BaseFragment<FragmentUniversitiesBinding, ClubsViewModel> {

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
    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new ClubsController();

        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }
}