package com.hmtsoft.uniclubz.ui.clubDetails;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentClubDetailsBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.clubDetails.controller.ClubDetailsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ClubDetailsFragment extends BaseFragment<FragmentClubDetailsBinding, ClubDetailsViewModel> implements ClubDetailsController.ClickListener {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private ClubDetailsController controller;

    public ClubDetailsFragment() {
        super(ClubDetailsViewModel.class, R.layout.fragment_club_details);
    }

    @Override
    protected void initViews() {
        transparentStatusBar();
        binding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0)
                binding.title.setText(viewModel.clubDetails.getValue().getName());
            else
                binding.title.setText("");
        });
    }

    @Override
    protected void liveEventsObservers() {

        viewModel.clubDetails.observe(getViewLifecycleOwner(), entity -> {
            binding.tvName.setText(entity.getName());
            binding.tvUniversity.setText(entity.getUniversity());
            binding.tvDescription.setText(entity.getDescription());

            Glide.with(this)
                    .load(entity.getLogo())
                    .into(binding.logoImage);
            Glide.with(this)
                    .load(entity.getCoverPhoto())
                    .into(binding.coverImage);


            if (entity.getId().equals(PreferenceRepository.getUserData().getClubId()))
                binding.userActionHolder.setVisibility(View.GONE);
            else
                binding.userActionHolder.setVisibility(View.VISIBLE);

            if (entity.getAdminUid().equals(PreferenceRepository.getUid())) {
                binding.adminActionsHolder.setVisibility(View.VISIBLE);
                binding.userActionHolder.setVisibility(View.GONE);
            } else
                binding.adminActionsHolder.setVisibility(View.GONE);


        });

        viewModel.liveList.observe(getViewLifecycleOwner(), clubEntities -> {
            controller.setMemberList(clubEntities);
            controller.requestModelBuild();
        });
    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(backPressClickListener);
        binding.createEvent.setOnClickListener(v -> navController.navigate(R.id.createEventFragment));
        binding.requestBlood.setOnClickListener(v -> navController.navigate(R.id.createBloodRequestFragment));
    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new ClubDetailsController();
        controller.setClickListener(this);
        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }

    private void transparentStatusBar() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    private void whiteStatusBar() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                int flags = getActivity().getWindow().getDecorView().getSystemUiVisibility();
                flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                getActivity().getWindow().getDecorView().setSystemUiVisibility(flags);
                getActivity().getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        whiteStatusBar();
    }

    @Override
    public void onMemberClick(UserDetailsEntity entity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", entity);
        navController.navigate(R.id.userProfileBottomSheet, bundle);
    }
}