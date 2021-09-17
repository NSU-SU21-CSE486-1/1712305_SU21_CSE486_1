package com.hmtsoft.uniclubz.ui.editProfile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.FragmentEditProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseFragment;
import com.hmtsoft.uniclubz.ui.editProfile.adapter.TabAdapter;
import com.hmtsoft.uniclubz.ui.editProfile.tabs.PersonalInformationTabFragment;
import com.hmtsoft.uniclubz.ui.editProfile.tabs.PhoneNumbersTabFragment;
import com.hmtsoft.uniclubz.ui.editProfile.tabs.UniversitiesTabFragment;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EditProfileFragment extends BaseFragment<FragmentEditProfileBinding, EditProfileViewModel> {

    private EditProfileViewModel sharedViewModel;
    protected TabAdapter tabAdapter;

    public EditProfileFragment() {
        super(EditProfileViewModel.class, R.layout.fragment_edit_profile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(EditProfileViewModel.class);
    }

    @Override
    protected void initViews() {
        setupTabs();
    }

    private void setupTabs() {

        tabAdapter = new TabAdapter(requireActivity());

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        fragmentList.add(new PersonalInformationTabFragment());
        titleList.add("Personal Information");
        fragmentList.add(new UniversitiesTabFragment());
        titleList.add("Universities");
        fragmentList.add(new PhoneNumbersTabFragment());
        titleList.add("Phone Numbers");

        tabAdapter.setFragmentList(fragmentList);
        tabAdapter.setTitleList(titleList);

        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.setAdapter(tabAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    tab.setText(titleList.get(position));
                }
        ).attach();

        tabAdapter.notifyDataSetChanged();

    }

    @Override
    protected void liveEventsObservers() {
        sharedViewModel.userInsertObserver.observe(this, s -> {
            ToastUtils.show(s);
            navController.navigate(R.id.homeFragment);
        });
    }


    @Override
    protected void clickListeners() {

        binding.toolbar.setNavigationOnClickListener(backPressClickListener);

        binding.save.setOnClickListener(v -> {
            UserDetailsEntity model = sharedViewModel.getUserDetailsModel();
            String error = "";
            if (model == null || model.getFullName() == null)
                error = "Please enter personal information";
            else if (model.getUniversities() == null || model.getUniversities().size() == 0)
                error = "Please enter your university";
            else if (model.getPhoneNumbers() == null || model.getPhoneNumbers().size() == 0)
                error = "Please enter your phone number";

            if (!error.isEmpty()) {
                ToastUtils.show(error);
                return;
            }
            sharedViewModel.insertUserDetailsToDatabase();
        });


    }

}