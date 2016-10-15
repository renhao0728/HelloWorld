package com.example.citru.helloworld.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public abstract class BaseActivity extends Activity implements OnClickListener {
    protected RequestQueue mQueue;
    protected Activity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        mContext = this;
        mQueue = Volley.newRequestQueue(mContext);
        setContentView();
        initStatus();
        setupView();
        addListener();

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * setContentView(R.layout.xml)
     */
    protected abstract void setContentView();

    /**
     * 初始化
     */
    protected abstract void initStatus();

    /**
     * 找控件
     */
    protected abstract void setupView();

    /**
     * 监听
     */
    protected abstract void addListener();

    /**
     * 发送消息
     *
     * @param handler
     * @param what
     * @param arg1
     * @param arg2
     */
    protected void sendMSG(Handler handler, int what, int arg1, int arg2,
                           Object obj) {
        Message msg = handler.obtainMessage();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        msg.sendToTarget();
    }




}
