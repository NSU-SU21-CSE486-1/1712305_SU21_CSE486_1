package com.hmtsoft.uniclubz.ui.clubDetails.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemMemberBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_member)
public abstract class MemberModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute
    UserDetailsEntity model;

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    View.OnClickListener clickListener;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemMemberBinding binding = (ItemMemberBinding) holder.getDataBinding();

        binding.title.setText(model.getFullName());
        binding.subTitle.setText(model.getUniversities().get(0).getDepartment());
        binding.getRoot().setOnClickListener(clickListener);

    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding binding) {

    }

}
