package com.hmtsoft.uniclubz.ui.auth.editProfile.modal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.BottomSheetEditPersonalInformationBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseBottomSheetFragment;
import com.hmtsoft.uniclubz.ui.auth.editProfile.EditProfileViewModel;
import com.hmtsoft.uniclubz.utils.ToastUtils;

public class EditPersonalInformationBottomSheet extends BaseBottomSheetFragment<BottomSheetEditPersonalInformationBinding, EditProfileViewModel> {

    private EditProfileViewModel sharedViewModel;
    private MaterialDatePicker materialDatePicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public EditPersonalInformationBottomSheet() {
        super(EditProfileViewModel.class, R.layout.bottom_sheet_edit_personal_information);
    }

    @Override
    protected void initViews() {

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTheme(R.style.MaterialCalendarTheme);
        materialDateBuilder.setTitleText("SELECT DATE OF BIRTH");
        materialDatePicker = materialDateBuilder.build();
        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            binding.tvDateOfBirth.setText(materialDatePicker.getHeaderText());
        });

        UserDetailsEntity model = PreferenceRepository.getUserData();
        if (model != null){
            binding.etFullName.setText(model.getFullName());
            binding.etNid.setText(model.getNid());
            binding.tvDateOfBirth.setText(model.getDateOfBirth());
        }

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

        binding.btnSubmit.setOnClickListener(v -> {

            String error = "";

            if (binding.etFullName.getText().toString().isEmpty())
                error = "Please enter your full name";
            else if (binding.etNid.getText().toString().isEmpty())
                error = "Please enter your NID";
            else if (binding.tvDateOfBirth.getText().toString().contains("Select"))
                error = "Please select date of birth";

            if (!error.isEmpty()) {
                ToastUtils.show(error);
                return;
            }

            UserDetailsEntity model = sharedViewModel.getUserDetailsModel();
            model.setPersonalInformation(
                    binding.etFullName.getText().toString(),
                    binding.tvDateOfBirth.getText().toString(),
                    binding.spBloodGroup.getSelectedItem().toString(),
                    binding.etNid.getText().toString()
            );

            sharedViewModel.setUserDetailsModel(model);
            dismissAllowingStateLoss();
        });


        binding.tvDateOfBirth.setOnClickListener(v -> {
            materialDatePicker.show(getParentFragmentManager(), "date_picker");
        });


    }
}
