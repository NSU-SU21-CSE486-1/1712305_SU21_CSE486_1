package com.hmtsoft.uniclubz.ui.userProfileModal;

import android.content.Intent;
import android.net.Uri;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.BottomSheetUserProfileBinding;
import com.hmtsoft.uniclubz.ui.base.BaseBottomSheetFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserProfileBottomSheet extends BaseBottomSheetFragment<BottomSheetUserProfileBinding, UserProfileViewModel> {

    public UserProfileBottomSheet() {
        super(UserProfileViewModel.class, R.layout.bottom_sheet_user_profile);
    }

    @Override
    protected void initViews() {


    }

    @Override
    protected void liveEventsObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), entity -> {
            binding.name.setText(entity.getFullName());
            binding.bloodGroup.setText(entity.getBloodGroup());
            binding.department.setText(entity.getUniversities().get(0).getDepartment());
            binding.university.setText(entity.getUniversities().get(0).getUniversity());

            binding.call.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", entity.getPhoneNumbers().get(0).getPhoneNumber(), null));
                startActivity(intent);
            });

            binding.email.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, entity.getUniversities().get(0).getEmail());
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email from UniClubz");
                startActivity(intent);
            });
        });
    }

    @Override
    protected void clickListeners() {


    }
}
