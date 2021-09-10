package com.hmtsoft.uniclubz.ui.assignment03.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemMemberBinding;
import com.hmtsoft.uniclubz.model.UserDetailsEntity;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    private List<UserDetailsEntity> itemList;
    private ClickListener clickListener;

    public MemberAdapter(List<UserDetailsEntity> dataModelList, ClickListener clickListener) {
        this.itemList = dataModelList;
        this.clickListener = clickListener;
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
        UserDetailsEntity model = itemList.get(position);
        holder.binding.title.setText(model.getFullName());
        holder.binding.subTitle.setText(model.getNid());
        holder.binding.getRoot().setOnClickListener(v -> clickListener.onClick(model));
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

    public void setItemList(List<UserDetailsEntity> itemList) {
        this.itemList = itemList;
    }


    public interface ClickListener {
        void onClick(UserDetailsEntity model);

    }

}