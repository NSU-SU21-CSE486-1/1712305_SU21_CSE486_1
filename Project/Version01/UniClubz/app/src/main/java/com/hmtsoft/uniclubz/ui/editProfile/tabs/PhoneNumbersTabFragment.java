package com.hmtsoft.uniclubz.ui.editProfile.tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentTabPhoneNumbersBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.editProfile.EditProfileViewModel;
import com.hmtsoft.uniclubz.ui.editProfile.adapter.PhoneNumberAdapter;
import com.hmtsoft.uniclubz.ui.editProfile.modal.EditPhoneNumberBottomSheet;

public class PhoneNumbersTabFragment extends BaseFragment<FragmentTabPhoneNumbersBinding, EditProfileViewModel> {
    private EditProfileViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public PhoneNumbersTabFragment() {
        super(EditProfileViewModel.class, R.layout.fragment_tab_phone_numbers);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

        sharedViewModel.getUserDetailsLiveData().observe(getViewLifecycleOwner(), model -> {
            if (model == null || model.getPhoneNumbers() == null || model.getPhoneNumbers().size() == 0) {
                binding.empty.setVisibility(View.VISIBLE);
                binding.recyclerView.setVisibility(View.GONE);
            } else {
                binding.empty.setVisibility(View.GONE);
                binding.recyclerView.setVisibility(View.VISIBLE);
                PhoneNumberAdapter adapter = new PhoneNumberAdapter(model.getPhoneNumbers());
                binding.recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        UserDetailsEntity model = sharedViewModel.getUserDetailsModel();
        if (model == null || model.getPhoneNumbers() == null || model.getPhoneNumbers().size() == 0) {
            binding.empty.setVisibility(View.VISIBLE);
        } else {
            binding.empty.setVisibility(View.GONE);
            PhoneNumberAdapter adapter = new PhoneNumberAdapter(model.getPhoneNumbers());
            binding.recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void clickListeners() {
        binding.floatingActionButton.setOnClickListener(v -> {
            EditPhoneNumberBottomSheet bottomSheet = new EditPhoneNumberBottomSheet();
            bottomSheet.show(getParentFragmentManager(), "Edit Phone Number");
        });
    }
}
