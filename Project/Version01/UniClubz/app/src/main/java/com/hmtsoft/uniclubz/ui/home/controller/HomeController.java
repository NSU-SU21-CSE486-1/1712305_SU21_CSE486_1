package com.hmtsoft.uniclubz.ui.home.controller;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.ui.home.model.HomeWidgetModel_;

public class HomeController extends EpoxyController {

    @Override
    protected void buildModels() {

        new HomeWidgetModel_()
                .id("home_widget")
                .addTo(this);

    }
}
