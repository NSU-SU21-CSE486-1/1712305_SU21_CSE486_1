package com.hmtsoft.uniclubz.ui.assignment03.memberList;

import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ActivityMembersBinding;
import com.hmtsoft.uniclubz.ui.assignment03.adapter.MemberAdapter;
import com.hmtsoft.uniclubz.ui.base.BaseActivity;
import com.hmtsoft.uniclubz.utils.ToastUtils;

public class MembersActivity extends BaseActivity<ActivityMembersBinding, MembersViewModel> {

    public MembersActivity() {
        super(MembersViewModel.class, R.layout.activity_members);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void liveEventsObservers() {
        viewModel.userLiveList.observe(this, userDetailsEntities -> {

            if (userDetailsEntities.isEmpty())
                binding.empty.setVisibility(View.VISIBLE);
            else
                binding.empty.setVisibility(View.GONE);

            MemberAdapter adapter = new MemberAdapter(userDetailsEntities, model1 ->
                    ToastUtils.show("Name: " + model1.getFullName() + "\nNID:" + model1.getNid() + "\nBlood Group:" + model1.getBloodGroup() + "\nDate of Birth: " + model1.getDateOfBirth()));

            binding.recyclerView.setAdapter(adapter);
        });
    }

    @Override
    protected void clickListeners() {
        binding.toolbar.setNavigationOnClickListener(v -> finish());

        binding.clearAll.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme)
                    .setMessage("Are you sure you want to clear user database?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                        viewModel.clearUserDatabase();
                    })
                    .setNegativeButton(android.R.string.no, null).show();

        });
    }
}