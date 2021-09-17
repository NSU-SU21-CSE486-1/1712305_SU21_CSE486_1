package com.hmtsoft.uniclubz.ui.exploreEvents;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentBloodRequestsBinding;
import com.hmtsoft.uniclubz.databinding.FragmentExploreEventsBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.exploreEvents.controller.ExploreEventsController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ExploreEventsFragment extends BaseFragment<FragmentExploreEventsBinding, ExploreEventsViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private ExploreEventsController controller;

    public ExploreEventsFragment() {
        super(ExploreEventsViewModel.class, R.layout.fragment_explore_events);
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
            controller = new ExploreEventsController();
        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }
}