package com.hmtsoft.uniclubz.ui.universities.controller;

import android.view.View;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.OnModelClickListener;
import com.hmtsoft.uniclubz.model.UniversityEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;
import com.hmtsoft.uniclubz.ui.universities.model.UniversityModel_;

import java.util.ArrayList;
import java.util.List;

public class UniversitiesController extends EpoxyController {

    private List<UniversityEntity> list = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        for (int i = 0; i < list.size(); i++) {
            new UniversityModel_()
                    .id(list.get(i).getName())
                    .model(list.get(i))
                    .clickListener((model, parentView, clickedView, position) -> clickListener.onClick(model.model()))
                    .addTo(this);
        }

    }

    public void setList(List<UniversityEntity> list) {
        this.list = list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onClick(UniversityEntity entity);
    }

}
