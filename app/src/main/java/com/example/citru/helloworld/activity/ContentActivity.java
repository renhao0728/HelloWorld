package com.example.citru.helloworld.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.adapter.ContetntAdapter;
import com.example.citru.helloworld.base.BaseActivity;
import com.example.citru.helloworld.entity.ContentEntity;

import java.util.ArrayList;

public class ContentActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private ContentEntity entity = new ContentEntity();
    private ArrayList<ContentEntity> entityArrayList = new ArrayList<ContentEntity>();
    private ContetntAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 5; i++) {
            entityArrayList.add(entity);
        }
        adapter = new ContetntAdapter(mContext,entityArrayList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_content);
    }

    @Override
    protected void initStatus() {

    }

    @Override
    protected void setupView() {
        lv = (ListView) findViewById(R.id.lv_content);
    }

    @Override
    protected void addListener() {
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
