package com.hmtsoft.uniclubz.ui.clubs.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.clubs.model.ClubModel_;

import java.util.ArrayList;
import java.util.List;

public class ClubsController extends EpoxyController {

    private List<ClubEntity> list = new ArrayList<>();
    private NavController navController;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        for (int i = 0; i < list.size(); i++) {
            new ClubModel_()
                    .id(list.get(i).getName())
                    .model(list.get(i))
                    .addTo(this);
        }

    }

    public void setList(List<ClubEntity> list) {
        this.list = list;
    }
}
