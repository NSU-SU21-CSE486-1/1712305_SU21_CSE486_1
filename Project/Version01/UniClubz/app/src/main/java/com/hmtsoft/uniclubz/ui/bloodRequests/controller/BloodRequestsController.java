package com.hmtsoft.uniclubz.ui.bloodRequests.controller;

import androidx.navigation.NavController;

import com.airbnb.epoxy.EpoxyController;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.ui.home.model.BloodRequestHorizontalModel_;
import com.hmtsoft.uniclubz.ui.home.model.LoadingBarFullModel_;
import com.hmtsoft.uniclubz.ui.home.model.LoadingBarModel_;

import java.util.ArrayList;
import java.util.List;

public class BloodRequestsController extends EpoxyController {

    private List<BloodRequestEntity> list = new ArrayList<>();
    private NavController navController;
    private ClickListener clickListener;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @Override
    protected void buildModels() {
        for (int i = 0; i < list.size(); i++) {
            new BloodRequestHorizontalModel_()
                    .id(list.get(i).getBloodGroup(), list.get(i).getAddress(), list.get(i).getPhoneNumber())
                    .model(list.get(i))
                    .addTo(this);
        }


        new LoadingBarFullModel_()
                .id("loadingbar")
                .addIf(list.size() == 0, this);

    }

    public void setList(List<BloodRequestEntity> list) {
        this.list = list;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(BloodRequestEntity entity);
    }
}
