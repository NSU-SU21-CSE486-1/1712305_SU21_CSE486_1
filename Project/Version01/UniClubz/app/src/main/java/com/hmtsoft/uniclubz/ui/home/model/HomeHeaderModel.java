package com.hmtsoft.uniclubz.ui.home.model;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.data.pref.PreferenceRepository;
import com.hmtsoft.uniclubz.databinding.ItemHomeHeaderBinding;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_home_header)
public abstract class HomeHeaderModel extends BaseDataBindingEpoxyModel {

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemHomeHeaderBinding binding = (ItemHomeHeaderBinding) holder.getDataBinding();
        if (PreferenceRepository.getUserData() != null)
            binding.userName.setText(PreferenceRepository.getUserData().getFullName());
    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
