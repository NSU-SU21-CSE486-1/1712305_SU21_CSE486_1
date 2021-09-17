package com.hmtsoft.uniclubz.ui.home.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.ui.home.model.HomeHeaderModel_;
import com.hmtsoft.uniclubz.ui.home.model.HomeWidgetModel_;

public class HomeController extends EpoxyController {

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
                .universitiesClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.universitiesFragment))
                .bloodRequestsClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.bloodRequestsFragment))
                .eventsClickListener((model, parentView, clickedView, position) -> navController.navigate(R.id.universitiesFragment))
                .addTo(this);

    }
}
