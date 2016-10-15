package com.example.citru.helloworld.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.base.BaseActivity;

public class GuangboActivity extends BaseActivity {

    private Button btGuangbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_guangbo);
    }

    @Override
    protected void initStatus() {
        int i=10;
    }

    @Override
    protected void setupView() {
        btGuangbo = (Button) findViewById(R.id.bt_guangbo);
    }

    @Override
    protected void addListener() {
        btGuangbo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_guangbo:
                Intent intent = new Intent();
                intent.setAction("com.example.BROADCAST");
                intent.putExtra("msg", "这是广播发送的消息");
                sendBroadcast(intent);
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter dynamic_filter = new IntentFilter();
        dynamic_filter.addAction("com.example.BROADCAST");			//添加动态广播的Action
        registerReceiver(dynamicReceiver, dynamic_filter);	// 注册自定义动态广播消息
    }
    private BroadcastReceiver dynamicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.example.BROADCAST")){	//动作检测
                Toast.makeText(context, "广播发送成功", Toast.LENGTH_SHORT).show();

            }
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(dynamicReceiver);
        super.onDestroy();
    }
}
