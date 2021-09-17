package com.hmtsoft.uniclubz.ui.createEvent;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.firebase.database.FirebaseDatabase;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.FragmentCreateEventBinding;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CreateEventFragment extends BaseFragment<FragmentCreateEventBinding, CreateEventViewModel> {

    @Inject
    FirebaseDatabase firebaseDatabase;
    private MaterialDatePicker materialDatePicker;

    public CreateEventFragment() {
        super(CreateEventViewModel.class, R.layout.fragment_create_event);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {

        viewModel.onEventCreated.observe(getViewLifecycleOwner(), s -> {
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
            String coverUrl = binding.etCover.getText().toString();
            String description = binding.etDescription.getText().toString();
            String date = binding.tvDate.getText().toString();

            String error = null;

            if (name.isEmpty())
                error = "Please enter event title";
            else if (university.isEmpty())
                error = "Please select university";
            else if (coverUrl.isEmpty())
                error = "Please enter club cover image URL";
            else if (description.isEmpty())
                error = "Please enter event description";
            else if (date.contains("date"))
                error = "Please select date";

            if (error != null) {
                ToastUtils.show(error);
                return;
            }

            EventEntity entity = new EventEntity(name, coverUrl, description, university, PreferenceRepository.getUid(), date);

            viewModel.create(entity);

        });

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTheme(R.style.MaterialCalendarTheme);
        materialDateBuilder.setTitleText("SELECT DATE OF THE EVENT");
        materialDatePicker = materialDateBuilder.build();
        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            binding.tvDate.setText(materialDatePicker.getHeaderText());
        });

        binding.tvDate.setOnClickListener(v -> {
            materialDatePicker.show(getParentFragmentManager(), "date_picker");
        });
    }

    @Override
    protected void setupRecycler() {

    }
}