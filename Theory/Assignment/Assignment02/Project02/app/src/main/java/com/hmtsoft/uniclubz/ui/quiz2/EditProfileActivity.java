package com.hmtsoft.uniclubz.ui.quiz2;

import android.content.Intent;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityEditProfileBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.ui.base.BaseActivity;
import com.hmtsoft.uniclubz.ui.quiz2.adapter.TabAdapter;
import com.hmtsoft.uniclubz.ui.quiz2.memberList.MembersActivity;
import com.hmtsoft.uniclubz.ui.quiz2.tabs.PersonalInformationTabFragment;
import com.hmtsoft.uniclubz.ui.quiz2.tabs.PhoneNumbersTabFragment;
import com.hmtsoft.uniclubz.ui.quiz2.tabs.UniversitiesTabFragment;
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


    }

    private void updateTabs() {

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void clickListeners() {

        binding.save.setOnClickListener(v -> {
            UserDetailsModel model = viewModel.getUserDetailsModel();
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

            Intent intent = new Intent(this, MembersActivity.class);
            intent.putExtra("model", viewModel.getUserDetailsModel());

            viewModel.setUserDetailsModel(new UserDetailsModel());
            startActivity(intent);
        });

    }

}