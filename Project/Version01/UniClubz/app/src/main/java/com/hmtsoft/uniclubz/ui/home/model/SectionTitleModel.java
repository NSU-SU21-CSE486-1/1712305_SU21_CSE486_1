package com.hmtsoft.uniclubz.ui.home.model;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemSectionTitleBinding;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_section_title)
public abstract class SectionTitleModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute
    String title;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemSectionTitleBinding binding = (ItemSectionTitleBinding) holder.getDataBinding();
        binding.title.setText(title);
    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
