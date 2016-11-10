package com.example.citru.helloworld.viewholder;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.citru.helloworld.R;

/**
 * Created by citrus on 2016/11/8.
 */

public class FThreeBottomViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    RelativeLayout mQuanzi;
    RelativeLayout mRankOriginal;
    RelativeLayout mRankAll;
    RelativeLayout mGame;
    RelativeLayout mBiliyoo;
    ImageView      mDiscoveryNew;
    Context context;

    public FThreeBottomViewHolder(View itemView, Context context) {
        super(itemView);
        this.context=context;
        setupView(itemView);
        initListener();
        initData();

    }

    private void initData() {
        //设置动画
        AnimationDrawable ad = (AnimationDrawable) mDiscoveryNew.getBackground();
        ad.start();
    }

    private void initListener() {
        mQuanzi.setOnClickListener(this);
        mRankOriginal.setOnClickListener(this);
        mRankAll.setOnClickListener(this);
        mGame.setOnClickListener(this);
        mBiliyoo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.faxian_bottom_quanzi:
                Toast.makeText(context, "圈子", Toast.LENGTH_SHORT).show();
                break;
            case R.id.faxian_bottom_rank_original:
                Toast.makeText(context, "original", Toast.LENGTH_SHORT).show();
                break;
            case R.id.faxian_bottom_rank_all:
                Toast.makeText(context, "全部", Toast.LENGTH_SHORT).show();
                break;
            case R.id.faxian_bottom_game:
                Toast.makeText(context, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.faxian_bottom_biliyoo:
                Toast.makeText(context, "yooo", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setupView(View upView) {
        mQuanzi = (RelativeLayout) itemView.findViewById(R.id.faxian_bottom_quanzi);
        mRankOriginal = (RelativeLayout) itemView.findViewById(R.id.faxian_bottom_rank_original);
        mRankAll = (RelativeLayout) itemView.findViewById(R.id.faxian_bottom_rank_all);
        mGame = (RelativeLayout) itemView.findViewById(R.id.faxian_bottom_game);
        mBiliyoo = (RelativeLayout) itemView.findViewById(R.id.faxian_bottom_biliyoo);
        mDiscoveryNew = (ImageView) itemView.findViewById(R.id.faxian_bottom_discovery_new);
    }
}
