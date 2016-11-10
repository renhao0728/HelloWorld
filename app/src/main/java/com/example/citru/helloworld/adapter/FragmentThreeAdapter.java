package com.example.citru.helloworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.viewholder.FThreeBottomViewHolder;
import com.example.citru.helloworld.viewholder.FThreeCenterViewHolder;
import com.example.citru.helloworld.viewholder.FThreeTopViewHolder;

/**
 * Created by citrus on 2016/11/5.
 */

public class FragmentThreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_TOP_SEARCH = 0;
    private static final int TYPE_CENTER = 1;
    private static final int TYPE_BOTTOM = 2;
    Context context;

    public FragmentThreeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP_SEARCH;
        } else if (position == 1) {
            return TYPE_CENTER;
        } else if (position == 2) {
            return TYPE_BOTTOM;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOP_SEARCH) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_faxian_top_search, parent, false);
            return new FThreeTopViewHolder(view,context);
        } else if (viewType == TYPE_CENTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_faxian_center, parent, false);
            return new FThreeCenterViewHolder(view,context);
        } else if (viewType == TYPE_BOTTOM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_faxian_bottom, parent, false);
            return new FThreeBottomViewHolder(view,context);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
