package com.hmtsoft.uniclubz.ui.editProfile.tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentTabPersonalInformationBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.editProfile.EditProfileViewModel;
import com.hmtsoft.uniclubz.ui.editProfile.modal.EditPersonalInformationBottomSheet;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PersonalInformationTabFragment extends BaseFragment<FragmentTabPersonalInformationBinding, EditProfileViewModel> {

    @Inject
    FirebaseAuth firebaseAuth;
    private EditProfileViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public PersonalInformationTabFragment() {
        super(EditProfileViewModel.class, R.layout.fragment_tab_personal_information);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

        sharedViewModel.getUserDetailsLiveData().observe(this, model -> {
            if (model == null || model.getFullName() == null) {
                binding.empty.setVisibility(View.VISIBLE);
                binding.informationHolder.setVisibility(View.GONE);
            } else {
                binding.empty.setVisibility(View.GONE);
                binding.informationHolder.setVisibility(View.VISIBLE);

                binding.userName.setText(model.getFullName());
                binding.bloodGroup.setText(model.getBloodGroup());
                binding.dateOfBirth.setText(model.getDateOfBirth());
                binding.nid.setText(model.getNid());
            }
        });
    }

    @Override
    protected void clickListeners() {

        binding.logout.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(getContext(), R.style.AlertDialogTheme)
                    .setMessage("Are you sure you want logout?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                        firebaseAuth.signOut();
                        PreferenceRepository.clearAll();
                        requireActivity().finishAffinity();
                        startActivity(requireActivity().getIntent());
                    })
                    .setNegativeButton(android.R.string.no, null).show();
        });

        binding.floatingActionButton.setOnClickListener(v -> {
            EditPersonalInformationBottomSheet bottomSheet = new EditPersonalInformationBottomSheet();
            bottomSheet.show(getParentFragmentManager(), "Edit Personal Information");
        });

    }
}
