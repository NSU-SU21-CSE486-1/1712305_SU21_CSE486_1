package com.hmtsoft.uniclubz.ui.clubs.controller;

import android.view.View;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.OnModelClickListener;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;
import com.hmtsoft.uniclubz.ui.clubs.model.ClubModel_;

import java.util.ArrayList;
import java.util.List;

public class ClubsController extends EpoxyController {

    private List<ClubEntity> list = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {

        for (int i = 0; i < list.size(); i++) {
            new ClubModel_()
                    .id(list.get(i).getName())
                    .model(list.get(i))
                    .clickListener((model, parentView, clickedView, position) -> clickListener.onClick(model.model()))
                    .addTo(this);
        }

    }

    public void setList(List<ClubEntity> list) {
        this.list = list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onClick(ClubEntity entity);
    }
}
