package com.hmtsoft.uniclubz.ui.home.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemHomeButtonsBinding;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_home_buttons)
public abstract class HomeWidgetModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener profileClickListener;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener universitiesClickListener;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener bloodRequestsClickListener;


    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener eventsClickListener;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener exploreClubsClickListener;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener myClubClickListener;


    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemHomeButtonsBinding binding = (ItemHomeButtonsBinding) holder.getDataBinding();
        binding.myProfile.setOnClickListener(profileClickListener);
        binding.exploreUniversities.setOnClickListener(universitiesClickListener);
        binding.bloodRequests.setOnClickListener(bloodRequestsClickListener);
        binding.myEvents.setOnClickListener(eventsClickListener);
        binding.exploreClubs.setOnClickListener(exploreClubsClickListener);
        binding.myClub.setOnClickListener(myClubClickListener);
    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
