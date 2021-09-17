package com.hmtsoft.uniclubz.ui.home.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.CarouselModel_;
import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;
import com.hmtsoft.uniclubz.ui.home.model.BloodRequestHorizontalModel_;
import com.hmtsoft.uniclubz.ui.home.model.EventHorizontalModel_;
import com.hmtsoft.uniclubz.ui.home.model.HomeHeaderModel_;
import com.hmtsoft.uniclubz.ui.home.model.HomeWidgetModel_;
import com.hmtsoft.uniclubz.ui.home.model.SectionTitleModel_;
import com.hmtsoft.uniclubz.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeController extends EpoxyController {

    private List<EventEntity> eventList = new ArrayList<>();
    private List<BloodRequestEntity> bloodRequestList = new ArrayList<>();
    private NavController navController;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        new HomeHeaderModel_()
                .id("home_header")
                .addTo(this);

        new HomeWidgetModel_()
                .id("home_widget")
                .profileClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.editProfileFragment))
                .myClubClickListener((model, parentView, clickedView, position) -> {
                    if (PreferenceRepository.getUserData().getClubId() == null || PreferenceRepository.getUserData().getClubId().isEmpty()) {
                        navController.navigate(R.id.clubsFragment);
                        ToastUtils.show("Please join a club first");
                    } else
                        navController.navigate(R.id.clubDetailsFragment);
                })
                .universitiesClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.universitiesFragment))
                .bloodRequestsClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.bloodRequestsFragment))
                .eventsClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.exploreEventsFragment))
                .exploreClubsClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.clubsFragment))
                .addTo(this);

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
                .onBind((model, view, position) -> view.setNestedScrollingEnabled(false))
                .addIf(eventList.size() > 0, this);


        new SectionTitleModel_()
                .id("blood_section_title")
                .title("Urgent Blood Requests")
                .addIf(bloodRequestList.size() > 0, this);

        List<BaseDataBindingEpoxyModel> bloodRequestModelList = new ArrayList<>();

        for (int i = 0; i < bloodRequestList.size(); i++) {
            bloodRequestModelList.add(new BloodRequestHorizontalModel_()
                    .id(bloodRequestList.get(i).getBloodGroup(), bloodRequestList.get(i).getAddress())
                    .model(bloodRequestList.get(i)));
        }

        new CarouselModel_()
                .id("blood_request_carousel")
                .models(bloodRequestModelList)
                .onBind((model, view, position) -> view.setNestedScrollingEnabled(false))
                .addIf(bloodRequestList.size() > 0, this);

    }

    public void setEventList(List<EventEntity> eventList) {
        this.eventList = eventList;
    }

    public void setBloodRequestList(List<BloodRequestEntity> bloodRequestList) {
        this.bloodRequestList = bloodRequestList;
    }
}
