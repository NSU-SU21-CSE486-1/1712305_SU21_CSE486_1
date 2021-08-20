package com.hmtsoft.uniclubz.ui.quiz2.modal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.BottomSheetEditUniversityBinding;
import com.hmtsoft.uniclubz.model.UniversityModel;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.ui.base.BaseBottomSheetFragment;
import com.hmtsoft.uniclubz.ui.quiz2.EditProfileViewModel;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class EditUniversityBottomSheet extends BaseBottomSheetFragment<BottomSheetEditUniversityBinding, EditProfileViewModel> {

    private EditProfileViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public EditUniversityBottomSheet() {
        super(EditProfileViewModel.class, R.layout.bottom_sheet_edit_university);
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

            String error = "";

            if (binding.etStudentId.getText().toString().isEmpty()) {
                error = "Please enter student id";
            } else if (binding.etEmail.getText().toString().isEmpty()) {
                error = "Please enter email address";
            }

            if (!error.isEmpty()) {
                ToastUtils.show("Please enter phone number");
                return;
            }

            UserDetailsModel model = sharedViewModel.getUserDetailsModel();

            List<UniversityModel> list = model.getUniversities();
            if (list == null)
                list = new ArrayList<>();

            UniversityModel item = new UniversityModel();
            item.setUniversity(binding.spUniversity.getSelectedItem().toString());
            item.setDepartment(binding.spDepartment.getSelectedItem().toString());
            item.setStudyLevel(binding.spStudyLevel.getSelectedItem().toString());
            item.setStudentId(binding.etStudentId.getText().toString());
            item.setEmail(binding.etEmail.getText().toString());

            list.add(item);

            model.setUniversities(list);

            sharedViewModel.setUserDetailsModel(model);
            dismissAllowingStateLoss();
        });


    }
}
