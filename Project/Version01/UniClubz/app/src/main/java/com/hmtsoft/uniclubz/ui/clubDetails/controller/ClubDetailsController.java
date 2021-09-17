package com.hmtsoft.uniclubz.ui.clubDetails.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.OnModelBoundListener;
import com.hmtsoft.uniclubz.databinding.ItemSectionTitleBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;
import com.hmtsoft.uniclubz.ui.clubDetails.model.MemberModel_;
import com.hmtsoft.uniclubz.ui.home.model.SectionTitleModel_;

import java.util.ArrayList;
import java.util.List;

public class ClubDetailsController extends EpoxyController {

    private List<UserDetailsEntity> memeberList = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        new SectionTitleModel_()
                .id("member_section_title")
                .title("Members (" + memeberList.size() + ")")
                .onBind((model, view, position) -> {
                    ItemSectionTitleBinding binding = (ItemSectionTitleBinding) view.getDataBinding();
                    binding.title.setText("Members (" + memeberList.size() + ")");
                })
                .addTo(this);

        for (int i = 0; i < memeberList.size(); i++) {
            new MemberModel_()
                    .id(memeberList.get(i).getUid())
                    .model(memeberList.get(i))
                    .clickListener((model, parentView, clickedView, position) -> clickListener.onClick(model.model()))
                    .addTo(this);
        }

    }

    public void setMemberList(List<UserDetailsEntity> list) {
        this.memeberList = list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(UserDetailsEntity entity);
    }
}
