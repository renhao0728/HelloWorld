package com.example.citru.helloworld.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.base.BaseFragment;

/**
 * Created by citrus on 2016/11/3.
 */

public class FragmentTwo extends BaseFragment {
    @Override
    public void initStatus() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListener(View v) {
    }

    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_two, null);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.panju_recyclerview);
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
