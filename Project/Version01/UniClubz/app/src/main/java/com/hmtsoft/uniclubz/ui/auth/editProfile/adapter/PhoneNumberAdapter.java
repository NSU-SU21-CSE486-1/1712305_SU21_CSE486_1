package com.hmtsoft.uniclubz.ui.auth.editProfile.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemPhoneNumberBinding;
import com.hmtsoft.uniclubz.model.PhoneNumberModel;

import java.util.List;

public class PhoneNumberAdapter extends RecyclerView.Adapter<PhoneNumberAdapter.ViewHolder> {

    private List<PhoneNumberModel> itemList;

    public PhoneNumberAdapter(List<PhoneNumberModel> dataModelList) {
        this.itemList = dataModelList;

    }

    @Override
    public PhoneNumberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        ItemPhoneNumberBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_phone_number, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PhoneNumberModel model = itemList.get(position);
        holder.binding.title.setText(model.getTag());
        holder.binding.subTitle.setText(model.getPhoneNumber());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemPhoneNumberBinding binding;

        public ViewHolder(ItemPhoneNumberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


    public void setItemList(List<PhoneNumberModel> itemList) {
        this.itemList = itemList;
    }
}