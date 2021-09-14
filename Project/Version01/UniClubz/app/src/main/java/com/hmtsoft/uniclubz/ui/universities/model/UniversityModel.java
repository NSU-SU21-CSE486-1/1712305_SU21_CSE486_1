package com.hmtsoft.uniclubz.ui.universities.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.bumptech.glide.Glide;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemUniversityListBinding;
import com.hmtsoft.uniclubz.model.UniversityEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_university_list)
public abstract class UniversityModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute
    UniversityEntity model;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener clickListener;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemUniversityListBinding binding = (ItemUniversityListBinding) holder.getDataBinding();
        binding.name.setText(model.getName());
        binding.address.setText(model.getAddress());

        Glide.with(binding.coverPhoto.getContext())
                .load(model.getImageUrl())
                .into(binding.coverPhoto);

        binding.getRoot().setOnClickListener(clickListener);
    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
