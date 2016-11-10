package com.example.citru.helloworld.fragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.adapter.FragmentThreeAdapter;
import com.example.citru.helloworld.base.BaseFragment;

/**
 * Created by citrus on 2016/11/3.
 */

public class FragmentThree extends BaseFragment{
    private RecyclerView mRecyclerView;

    @Override
    public void initStatus() {

    }

    @Override
    public void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new FragmentThreeAdapter(getContext()));
    }

    @Override
    public void addListener(View v) {
    }

    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_three, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.three_recyclerview);
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
