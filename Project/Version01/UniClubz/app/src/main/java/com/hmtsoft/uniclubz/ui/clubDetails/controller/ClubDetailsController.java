package com.hmtsoft.uniclubz.ui.clubDetails.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.CarouselModel_;
import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.databinding.ItemSectionTitleBinding;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;
import com.hmtsoft.uniclubz.ui.clubDetails.model.MemberModel_;
import com.hmtsoft.uniclubz.ui.home.model.EventHorizontalModel_;
import com.hmtsoft.uniclubz.ui.home.model.SectionTitleModel_;

import java.util.ArrayList;
import java.util.List;

public class ClubDetailsController extends EpoxyController {

    private List<UserDetailsEntity> memberList = new ArrayList<>();
    private List<EventEntity> eventList = new ArrayList<>();
    private List<BloodRequestEntity> bloodRequestList = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        new SectionTitleModel_()
                .id("events_section_title")
                .title("Up Coming Events")
                .addIf(eventList.size() > 0, this);

        List<BaseDataBindingEpoxyModel> eventModelList = new ArrayList<>();

        for (int i = 0; i < eventList.size(); i++) {
            eventModelList.add(new EventHorizontalModel_()
                    .id(eventList.get(i).getName())
                    .model(eventList.get(i)));
        }

        new CarouselModel_()
                .id("events_carousel")
                .models(eventModelList)
                .addIf(eventList.size() > 0, this);


        new SectionTitleModel_()
                .id("member_section_title")
                .title("Members (" + memberList.size() + ")")
                .onBind((model, view, position) -> {
                    ItemSectionTitleBinding binding = (ItemSectionTitleBinding) view.getDataBinding();
                    binding.title.setText("Members (" + memberList.size() + ")");
                })
                .addTo(this);

        for (int i = 0; i < memberList.size(); i++) {
            new MemberModel_()
                    .id(memberList.get(i).getUid())
                    .model(memberList.get(i))
                    .clickListener((model, parentView, clickedView, position) -> clickListener.onMemberClick(model.model()))
                    .addTo(this);
        }

    }

    public void setMemberList(List<UserDetailsEntity> list) {
        this.memberList = list;
    }

    public void setBloodRequestList(List<BloodRequestEntity> bloodRequestList) {
        this.bloodRequestList = bloodRequestList;
    }

    public void setEventList(List<EventEntity> eventList) {
        this.eventList = eventList;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onMemberClick(UserDetailsEntity entity);
    }
}
