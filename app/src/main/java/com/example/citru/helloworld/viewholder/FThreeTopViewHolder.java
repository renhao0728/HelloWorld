package com.example.citru.helloworld.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citru.helloworld.R;

/**
 * Created by citrus on 2016/11/8.
 */

public class FThreeTopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mSearch;
    ImageView mScan;
    Context context;

    public FThreeTopViewHolder(View itemView,Context context) {
        super(itemView);
        this.context=context;
        setupView(itemView);
        initListener();
    }

    public void setupView(View itemView) {
        mSearch = (TextView) itemView.findViewById(R.id.faxian_top_search);
        mScan = (ImageView) itemView.findViewById(R.id.faxian_top_scan);
    }

    private void initListener() {
        mSearch.setOnClickListener(this);
        mScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.faxian_top_search:
                Toast.makeText(context, "搜索框", Toast.LENGTH_SHORT).show();
                break;
            case R.id.faxian_top_scan:
                Toast.makeText(context, "扫一扫", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
