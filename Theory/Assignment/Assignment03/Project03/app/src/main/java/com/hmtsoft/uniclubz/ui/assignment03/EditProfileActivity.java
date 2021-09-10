package com.hmtsoft.uniclubz.ui.assignment03;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityEditProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.assignment03.adapter.TabAdapter;
import com.hmtsoft.uniclubz.ui.assignment03.memberList.MembersActivity;
import com.hmtsoft.uniclubz.ui.assignment03.tabs.PersonalInformationTabFragment;
import com.hmtsoft.uniclubz.ui.assignment03.tabs.PhoneNumbersTabFragment;
import com.hmtsoft.uniclubz.ui.assignment03.tabs.UniversitiesTabFragment;
import com.hmtsoft.uniclubz.ui.base.BaseActivity;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends BaseActivity<ActivityEditProfileBinding, EditProfileViewModel> {

    protected TabAdapter tabAdapter;

    public EditProfileActivity() {
        super(EditProfileViewModel.class, R.layout.activity_edit_profile);
    }

    @Override
    protected void initViews() {
        setupTabs();
    }

    private void setupTabs() {

        tabAdapter = new TabAdapter(this);

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
        viewModel.userInsertObserver.observe(this, s -> {
            ToastUtils.show(s);
            if (s.contains("success")) {
                Intent intent = new Intent(this, MembersActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void clickListeners() {

        binding.userList.setOnClickListener(v -> {
            Intent intent = new Intent(this, MembersActivity.class);
            startActivity(intent);
        });

        binding.save.setOnClickListener(v -> {
            UserDetailsEntity model = viewModel.getUserDetailsModel();
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
            viewModel.insertUserDetailsToDatabase();
            viewModel.setUserDetailsModel(new UserDetailsEntity());
        });


    }

}