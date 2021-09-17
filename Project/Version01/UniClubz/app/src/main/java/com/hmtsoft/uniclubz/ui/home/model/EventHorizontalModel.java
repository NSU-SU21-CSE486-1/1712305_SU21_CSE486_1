package com.hmtsoft.uniclubz.ui.home.model;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.bumptech.glide.Glide;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemEventHorizontalBinding;
import com.hmtsoft.uniclubz.model.EventEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_event_horizontal)
public abstract class EventHorizontalModel extends BaseDataBindingEpoxyModel {


    @EpoxyAttribute
    EventEntity model;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);

        ItemEventHorizontalBinding binding = (ItemEventHorizontalBinding) holder.getDataBinding();

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
