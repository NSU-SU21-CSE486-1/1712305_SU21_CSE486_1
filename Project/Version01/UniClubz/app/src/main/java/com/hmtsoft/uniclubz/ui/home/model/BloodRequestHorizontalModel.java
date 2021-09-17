package com.hmtsoft.uniclubz.ui.home.model;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemBloodRequestHorizontalBinding;
import com.hmtsoft.uniclubz.model.BloodRequestEntity;
import com.hmtsoft.uniclubz.ui.base.BaseDataBindingEpoxyModel;


@EpoxyModelClass(layout = R.layout.item_blood_request_horizontal)
public abstract class BloodRequestHorizontalModel extends BaseDataBindingEpoxyModel {

    @EpoxyAttribute
    BloodRequestEntity model;

    @Override
    public void bind(@NonNull DataBindingHolder holder) {
        super.bind(holder);
        ItemBloodRequestHorizontalBinding binding = (ItemBloodRequestHorizontalBinding) holder.getDataBinding();

        binding.bloodGroup.setText(model.getBloodGroup());
        binding.whenDate.setText(model.getDate());
        binding.address.setText(model.getAddress());
        binding.phone.setText(model.getPhoneNumber());
        binding.title.setText(model.getBags() + " Bags" + model.getBloodGroup() + " Blood Needed");

        binding.phone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", model.getPhoneNumber(), null));
            binding.phone.getContext().startActivity(intent);
        });


        binding.message.setOnClickListener(v -> {
            binding.message.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", model.getPhoneNumber(), null)));
        });

    }

    @Override
    protected void setDataBindingVariables(ViewDataBinding holder) {


    }

}
