package com.hmtsoft.uniclubz.ui.quiz2.modal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.BottomSheetEditPhoneNumberBinding;
import com.hmtsoft.uniclubz.model.PhoneNumberModel;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.ui.base.BaseBottomSheetFragment;
import com.hmtsoft.uniclubz.ui.quiz2.EditProfileViewModel;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class EditPhoneNumberBottomSheet extends BaseBottomSheetFragment<BottomSheetEditPhoneNumberBinding, EditProfileViewModel> {

    private EditProfileViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public EditPhoneNumberBottomSheet() {
        super(EditProfileViewModel.class, R.layout.bottom_sheet_edit_phone_number);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

        binding.btnSubmit.setOnClickListener(v -> {
            if (binding.etContactNumber.getText().toString().isEmpty()) {
                ToastUtils.show("Please enter phone number");
                return;
            }
            UserDetailsModel model = sharedViewModel.getUserDetailsModel();

            List<PhoneNumberModel> list = model.getPhoneNumbers();
            if (list == null)
                list = new ArrayList<>();

            PhoneNumberModel item = new PhoneNumberModel();
            item.setTag(binding.spTags.getSelectedItem().toString());
            item.setPhoneNumber(binding.etContactNumber.getText().toString());

            list.add(item);

            model.setPhoneNumbers(list);

            sharedViewModel.setUserDetailsModel(model);
            dismissAllowingStateLoss();
        });


    }
}
