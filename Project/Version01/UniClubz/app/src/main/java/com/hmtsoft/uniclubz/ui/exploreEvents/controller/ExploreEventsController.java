package com.hmtsoft.uniclubz.ui.exploreEvents.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.ui.exploreEvents.model.EventVerticalModel_;

import java.util.ArrayList;
import java.util.List;

public class ExploreEventsController extends EpoxyController {

    private List<EventEntity> list = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {
        for (int i = 0; i < list.size(); i++) {
            new EventVerticalModel_()
                    .id(list.get(i).getName(), list.get(i).getCoverPhoto())
                    .model(list.get(i))
                    .addTo(this);
        }
    }

    public void setList(List<EventEntity> list) {
        this.list = list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(EventEntity entity);
    }
}
