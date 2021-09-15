package com.hmtsoft.uniclubz.ui.clubs.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.bumptech.glide.Glide;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemClubListBinding;
import com.hmtsoft.uniclubz.model.ClubEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_club_list)
public abstract class ClubModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute
    ClubEntity model;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener clickListener;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemClubListBinding binding = (ItemClubListBinding) holder.getDataBinding();

        binding.name.setText(model.getName());
        binding.address.setText(model.getUniversity());

        Glide.with(binding.coverPhoto.getContext())
                .load(model.getCoverPhoto())
                .into(binding.coverPhoto);

        binding.getRoot().setOnClickListener(clickListener);

    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
