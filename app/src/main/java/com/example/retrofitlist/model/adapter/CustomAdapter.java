package com.example.retrofitlist.model.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitlist.R;
import com.example.retrofitlist.databinding.CustomRowBinding;
import com.example.retrofitlist.model.pojo.RetroPhoto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<RetroPhoto> dataList;

    public CustomAdapter(){
        this.dataList=new ArrayList<>();
    }

    public void setDataList(List<RetroPhoto> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private CustomRowBinding customRowBinding;


        CustomViewHolder(CustomRowBinding customRowBinding) {
            super(customRowBinding.getRoot());
            this.customRowBinding=customRowBinding;
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CustomRowBinding customRowBinding= DataBindingUtil.inflate(layoutInflater, R.layout.custom_row,parent,false);
        return new CustomViewHolder(customRowBinding);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if(dataList.size()>0){
            holder.customRowBinding.title.setText(dataList.get(position).getName());
            holder.customRowBinding.desc.setText(dataList.get(position).getDesc());
            Picasso.get().load(dataList.get(position).getImage())
                    .into(holder.customRowBinding.coverImage);
        }




    }

    @Override
    public int getItemCount() {
        Log.e("abc",dataList.size()+"");
        return dataList.size()>0?dataList.size():2;
    }
}