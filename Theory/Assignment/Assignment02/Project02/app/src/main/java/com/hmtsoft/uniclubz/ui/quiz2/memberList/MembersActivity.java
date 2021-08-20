package com.hmtsoft.uniclubz.ui.quiz2.memberList;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.PreferenceHelper;
import com.hmtsoft.uniclubz.data.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.ActivityMembersBinding;
import com.hmtsoft.uniclubz.model.UserDetailsModel;
import com.hmtsoft.uniclubz.model.UserListModel;
import com.hmtsoft.uniclubz.ui.base.BaseActivity;
import com.hmtsoft.uniclubz.ui.quiz2.EditProfileViewModel;
import com.hmtsoft.uniclubz.ui.quiz2.adapter.MemberAdapter;

import java.util.List;

public class MembersActivity extends BaseActivity<ActivityMembersBinding, EditProfileViewModel> {

    public MembersActivity() {
        super(EditProfileViewModel.class, R.layout.activity_members);
    }

    @Override
    protected void initViews() {

        UserDetailsModel model = (UserDetailsModel) getIntent().getSerializableExtra("model");
        UserListModel userListModel = PreferenceRepository.getUserListData();
        if (userListModel == null)
            userListModel = new UserListModel();

        List<UserDetailsModel> userList = userListModel.getList();
        userList.add(model);
        userListModel.setList(userList);

        PreferenceRepository.saveUserListData(userListModel);

        MemberAdapter adapter = new MemberAdapter(userList);
        binding.recyclerView.setAdapter(adapter);

    }

    @Override
    protected void liveEventsObservers() {

    }

    @Override
    protected void clickListeners() {

    }
}