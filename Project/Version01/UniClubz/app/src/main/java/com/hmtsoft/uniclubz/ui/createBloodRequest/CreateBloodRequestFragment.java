package com.hmtsoft.uniclubz.ui.createBloodRequest;

import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentCreateBloodRequestBinding;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CreateBloodRequestFragment extends BaseFragment<FragmentCreateBloodRequestBinding, CreateBloodRequestViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;

    private String clubId = null;

    public CreateBloodRequestFragment() {
        super(CreateBloodRequestViewModel.class, R.layout.fragment_create_blood_request);
    }

    @Override
    protected void initViews() {
        if (getArguments() != null && getArguments().containsKey("club_id"))
            clubId = getArguments().getString("club_id");
    }

    @Override
    protected void liveEventsObservers() {

        viewModel.onBloodRequestCreated.observe(getViewLifecycleOwner(), s -> {
            ToastUtils.show(s);
            navController.popBackStack();
        });

    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(backPressClickListener);

        binding.btnSubmit.setOnClickListener(v -> {

            String bloodGroup = binding.spBloodGroup.getSelectedItem().toString();
            String bags = binding.spBags.getSelectedItem().toString();
            String date = binding.tvDate.getText().toString();
            String phoneNumber = binding.etPhoneNumber.getText().toString();
            String address = binding.etAddress.getText().toString();
            String note = binding.etNote.getText().toString();

            String error = null;

            if (phoneNumber.isEmpty())
                error = "Please enter phone number";
            else if (address.isEmpty())
                error = "Please enter address";
            else if (date.contains("date"))
                error = "Please select date";

            if (error != null) {
                ToastUtils.show(error);
                return;
            }

            BloodRequestEntity entity = new BloodRequestEntity(bloodGroup, bags, date, phoneNumber, address, note, PreferenceRepository.getUid(), clubId);

            viewModel.create(entity);

        });
    }

    @Override
    protected void setupRecycler() {

    }
}