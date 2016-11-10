package com.example.citru.helloworld.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.adapter.FragmentTwoAdapter;
import com.example.citru.helloworld.base.BaseFragment;
import com.example.citru.helloworld.entity.FragmentTwoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by citrus on 2016/11/3.
 */

public class FragmentTwo extends BaseFragment {
    private RecyclerView mRecyclerView;
    private List<FragmentTwoEntity> mDatas;
    private String[] mFenquArray;

    @Override
    public void initStatus() {

    }

    @Override
    public void initData() {
        mFenquArray = getContext().getResources().getStringArray(R.array.fenqu);
        mDatas = new ArrayList<>();
        for (int i = 0; i < mFenquArray.length; i++) {
            FragmentTwoEntity entity = new FragmentTwoEntity();
            entity.icon=R.mipmap.ic_category_01+i;
            entity.title=mFenquArray[i];
            mDatas.add(entity);
        }

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerView.setAdapter(new FragmentTwoAdapter(mDatas,getContext()));
    }

    @Override
    public void addListener(View v) {
    }

    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.two_recyclerview);
        return view;
    }

    @Override
    public void setupView(View v) {

    }

    @Override
    protected String getPageName() {
        return null;
    }


}
