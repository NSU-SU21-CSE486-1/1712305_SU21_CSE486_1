package com.hmtsoft.uniclubz.ui.clubDetails;

import android.graphics.Color;
import android.os.Build;
import android.view.View;

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
        transparentStatusBar();
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

    private void transparentStatusBar() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
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
}