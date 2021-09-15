package com.hmtsoft.uniclubz.ui.createClub;

import androidx.lifecycle.Observer;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentCreateClubBinding;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.universities.controller.UniversitiesController;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CreateClubFragment extends BaseFragment<FragmentCreateClubBinding, CreateClubViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private UniversitiesController controller;

    public CreateClubFragment() {
        super(CreateClubViewModel.class, R.layout.fragment_create_club);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

        viewModel.onClubCreated.observe(getViewLifecycleOwner(), s -> {
            ToastUtils.show(s);
            navController.popBackStack();
        });

    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(backPressClickListener);

        binding.btnSubmit.setOnClickListener(v -> {

            String name = binding.etName.getText().toString();
            String university = binding.spUniversity.getSelectedItem().toString();
            String logoUrl = binding.etLogo.getText().toString();
            String coverUrl = binding.etCover.getText().toString();
            String description = binding.etDescription.getText().toString();

            String error = null;

            if (name.isEmpty())
                error = "Please enter club name";
            else if (university.isEmpty())
                error = "Please select university";
            else if (logoUrl.isEmpty())
                error = "Please enter club logo image URL";
            else if (coverUrl.isEmpty())
                error = "Please enter club cover image URL";
            else if (description.isEmpty())
                error = "Please enter club description";

            if (error != null) {
                ToastUtils.show(error);
                return;
            }

            ClubEntity entity = new ClubEntity(name, university, logoUrl, coverUrl, description, PreferenceRepository.getUid());

            viewModel.createClub(entity);

        });
    }

    @Override
    protected void setupRecycler() {

    }
}