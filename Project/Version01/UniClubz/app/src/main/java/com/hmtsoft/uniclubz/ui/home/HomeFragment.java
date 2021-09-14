package com.hmtsoft.uniclubz.ui.home;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentHomeBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.home.controller.HomeController;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    private HomeController controller;

    public HomeFragment() {
        super(HomeViewModel.class, R.layout.fragment_home);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

    }

    @Override
    protected void setupRecycler() {
        if (controller == null)
            controller = new HomeController();

        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }
}