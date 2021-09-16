package com.hmtsoft.uniclubz.ui.clubDetails;

import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentClubDetailsBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.clubs.controller.ClubsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ClubDetailsFragment extends BaseFragment<FragmentClubDetailsBinding, ClubDetailsViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private ClubsController controller;

    public ClubDetailsFragment() {
        super(ClubDetailsViewModel.class, R.layout.fragment_club_details);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

        viewModel.clubDetails.observe(getViewLifecycleOwner(), entity -> {
            binding.title.setText(entity.getName());
            binding.tvUniversity.setText(entity.getUniversity());
            binding.tvDescription.setText(entity.getDescription());
            Glide.with(this)
                    .load(entity.getLogo())
                    .into(binding.logoImage);
            Glide.with(this)
                    .load(entity.getCoverPhoto())
                    .into(binding.coverImage);
        });

//        viewModel.liveList.observe(getViewLifecycleOwner(), clubEntities -> {
//            controller.setList(clubEntities);
//            controller.requestModelBuild();
//        });
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