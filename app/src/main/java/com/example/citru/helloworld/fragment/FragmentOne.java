package com.example.citru.helloworld.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.base.BaseFragment;

/**
 * Created by citrus on 2016/11/3.
 */

public class FragmentOne extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    SwipeRefreshLayout mRefresh;
    RecyclerView mRecyclerView;
    @Override
    public void initStatus() {

    }

    @Override
    public void initData() {
    }

    @Override
    public void addListener(View v) {
        mRefresh.setOnRefreshListener(this);
    }

    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.one_recyclerview);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.one_refresh);
        return view;
    }

    @Override
    public void setupView(View v) {

    }

    @Override
    protected String getPageName() {
        return null;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(false);
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }
}
