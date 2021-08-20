package com.hmtsoft.uniclubz.ui.quiz2.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemMemberBinding;
import com.hmtsoft.uniclubz.databinding.ItemUniversityBinding;
import com.hmtsoft.uniclubz.model.UniversityModel;
import com.hmtsoft.uniclubz.model.UserDetailsModel;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    private List<UserDetailsModel> itemList;

    public MemberAdapter(List<UserDetailsModel> dataModelList) {
        this.itemList = dataModelList;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        ItemMemberBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_member, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserDetailsModel model = itemList.get(position);
        holder.binding.title.setText(model.getFullName());
        holder.binding.subTitle.setText(model.getNid());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemMemberBinding binding;

        public ViewHolder(ItemMemberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setItemList(List<UserDetailsModel> itemList) {
        this.itemList = itemList;
    }
}