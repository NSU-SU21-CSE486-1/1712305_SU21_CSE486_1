package com.hmtsoft.uniclubz.ui.exploreEvents.model;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.bumptech.glide.Glide;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemEventVerticalBinding;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_event_vertical)
public abstract class EventVerticalModel extends BaseDataBindingEpoxyModel {
    
    @EpoxyAttribute
    EventEntity model;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);

        ItemEventVerticalBinding binding = (ItemEventVerticalBinding) holder.getDataBinding();

        binding.name.setText(model.getName());
        binding.date.setText(model.getDate());

        Glide.with(binding.coverPhoto.getContext())
                .load(model.getCoverPhoto())
                .into(binding.coverPhoto);

        // binding.getRoot().setOnClickListener(clickListener);
    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
