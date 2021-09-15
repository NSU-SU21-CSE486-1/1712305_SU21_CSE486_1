package com.hmtsoft.uniclubz.ui.universities;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentUniversitiesBinding;
import com.hmtsoft.uniclubz.model.UniversityEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.universities.controller.UniversitiesController;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UniversitiesFragment extends BaseFragment<FragmentUniversitiesBinding, UniversitiesViewModel> implements UniversitiesController.ClickListener {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private UniversitiesController controller;

    public UniversitiesFragment() {
        super(UniversitiesViewModel.class, R.layout.fragment_universities);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        viewModel.liveList.observe(getViewLifecycleOwner(), universityEntities -> {
            controller.setList(universityEntities);
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
            controller = new UniversitiesController();
        controller.setClickListener(this);
        controller.setNavController(navController);
        binding.recyclerView.setAdapter(controller.getAdapter());
        controller.requestModelBuild();
    }

    @Override
    public void onClick(UniversityEntity entity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", entity);
        navController.navigate(R.id.clubsFragment, bundle);
    }
}