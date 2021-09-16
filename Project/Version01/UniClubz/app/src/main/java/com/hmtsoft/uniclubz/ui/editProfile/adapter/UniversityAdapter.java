package com.hmtsoft.uniclubz.ui.editProfile.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hmtsoft.uniclubz.R;
import com.hmtsoft.uniclubz.databinding.ItemUniversityBinding;
import com.hmtsoft.uniclubz.model.UniversityModel;

import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {

    private List<UniversityModel> itemList;

    public UniversityAdapter(List<UniversityModel> dataModelList) {
        this.itemList = dataModelList;
    }

    @Override
    public UniversityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        ItemUniversityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_university, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UniversityModel model = itemList.get(position);
        holder.binding.title.setText(model.getUniversity());
        holder.binding.subTitle.setText(model.getStudyLevel() + "\n" + model.getDepartment());
        holder.binding.subTitle2.setText(model.getStudentId() + " • " + model.getEmail());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemUniversityBinding binding;

        public ViewHolder(ItemUniversityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setItemList(List<UniversityModel> itemList) {
        this.itemList = itemList;
    }
}