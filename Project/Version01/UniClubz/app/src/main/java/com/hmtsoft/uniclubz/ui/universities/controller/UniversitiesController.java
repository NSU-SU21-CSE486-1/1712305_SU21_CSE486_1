package com.hmtsoft.uniclubz.ui.universities.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.model.UniversityEntity;
import com.hmtsoft.uniclubz.ui.universities.model.UniversityModel_;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesController extends EpoxyController {

    private List<UniversityEntity> list = new ArrayList<>();
    private NavController navController;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        for (int i = 0; i < list.size(); i++) {
            new UniversityModel_()
                    .id(list.get(i).getName())
                    .model(list.get(i))
                    .addTo(this);
        }

    }

    public void setList(List<UniversityEntity> list) {
        this.list = list;
    }
}
