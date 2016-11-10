package com.example.citru.helloworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.entity.FragmentTwoEntity;
import com.example.citru.helloworld.viewholder.FragmentTwoViewHolder;

import java.util.List;

/**
 * Created by citrus on 2016/11/4.
 */

public class FragmentTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FragmentTwoEntity> mDatas;
    Context context;

    public FragmentTwoAdapter(List<FragmentTwoEntity> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_two, parent,false);
        return new FragmentTwoViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FragmentTwoViewHolder viewholder = (FragmentTwoViewHolder) holder;
        viewholder.loadData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
