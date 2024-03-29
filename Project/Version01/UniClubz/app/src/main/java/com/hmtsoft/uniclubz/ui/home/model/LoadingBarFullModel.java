package com.hmtsoft.uniclubz.ui.home.model;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemSectionTitleBinding;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_loading_bard)
public abstract class LoadingBarFullModel extends BaseDataBindingEpoxyModel {


    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);

    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
