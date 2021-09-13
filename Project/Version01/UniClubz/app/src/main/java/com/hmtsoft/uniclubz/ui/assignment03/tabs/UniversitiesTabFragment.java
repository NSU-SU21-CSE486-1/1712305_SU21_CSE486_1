package com.hmtsoft.uniclubz.ui.assignment03.tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentTabUniversitiesBinding;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.assignment03.EditProfileViewModel;
import com.hmtsoft.uniclubz.ui.assignment03.adapter.UniversityAdapter;
import com.hmtsoft.uniclubz.ui.assignment03.modal.EditUniversityBottomSheet;

public class UniversitiesTabFragment extends BaseFragment<FragmentTabUniversitiesBinding, EditProfileViewModel> {

    private EditProfileViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    public UniversitiesTabFragment() {
        super(EditProfileViewModel.class, R.layout.fragment_tab_universities);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        sharedViewModel.getUserDetailsLiveData().observe(getViewLifecycleOwner(), model -> {
            if (model == null || model.getUniversities() == null || model.getUniversities().size() == 0) {
                binding.empty.setVisibility(View.VISIBLE);
                binding.recyclerView.setVisibility(View.GONE);
            } else {
                binding.recyclerView.setVisibility(View.VISIBLE);
                binding.empty.setVisibility(View.GONE);
                UniversityAdapter adapter = new UniversityAdapter(model.getUniversities());
                binding.recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void clickListeners() {
        binding.floatingActionButton.setOnClickListener(v -> {
            EditUniversityBottomSheet bottomSheet = new EditUniversityBottomSheet();
            bottomSheet.show(getParentFragmentManager(), "Edit University");
        });
    }

}
